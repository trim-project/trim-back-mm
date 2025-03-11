package trim.api.common.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import trim.api.common.dto.JwtToken;
import trim.api.domains.member.vo.auth.CustomUserDetails;
import trim.common.exception.ErrorStatus;
import trim.common.exception.GeneralException;
import trim.common.service.RedisService;
import trim.domains.member.business.adaptor.MemberAdaptor;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService{
    private final Key key;      //security yml 파일 생성 후 app.jwt.secret에 값 넣어주기(보안을 위해 따로 연락주세요)
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final Environment env;
    private final RedisService redisService;
    private final MemberAdaptor memberAdaptor;

    public TokenServiceImpl(AuthenticationManagerBuilder authenticationManagerBuilder,
                            Environment env,
                            RedisService redisService,
                            MemberAdaptor memberAdaptor) {
        this.env = env;
        byte[] keyBytes = Decoders.BASE64.decode(env.getProperty("token.secret"));
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.redisService = redisService;
        this.memberAdaptor = memberAdaptor;
    }
    @Override       //TODO oauth2적용시 필요 없음
    public JwtToken login(String username) {
        CustomUserDetails customUserDetails = new CustomUserDetails(memberAdaptor.queryMemberByUsername(username));
        Authentication authentication = new UsernamePasswordAuthenticationToken(customUserDetails, "",
                customUserDetails.getAuthorities());
        return generateToken(authentication);
    }

    @Override
    public JwtToken issueTokens(String refreshToken) {
        // Refresh Token 유효성 검사
        if (!validateToken(refreshToken) || !existsRefreshToken(refreshToken)) {
            throw new GeneralException(ErrorStatus._UNAUTHORIZED);
        }

        // 이전 리프레시 토큰 삭제
        redisService.deleteValue(refreshToken);

        // 새로운 Authentication 객체 생성
        Claims claims = parseClaims(refreshToken);
        String username = claims.getSubject();
        CustomUserDetails customUserDetails = new CustomUserDetails(memberAdaptor.queryMemberByUsername(username));
        Authentication authentication = new UsernamePasswordAuthenticationToken(customUserDetails, "",
                customUserDetails.getAuthorities());

        // 새 토큰 생성
        JwtToken newTokens = generateToken(authentication);

        return newTokens;
    }

    @Override
    public JwtToken generateToken(Authentication authentication) {
        // 권한 가져오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();

        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now + 1800000);   // 30분
        log.info("date = {}", accessTokenExpiresIn);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("auth", authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        // Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setSubject(authentication.getName())
                .setExpiration(new Date(now + 604800000))    // 7일
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        // 새 리프레시 토큰을 Redis에 저장
        redisService.setValue(refreshToken, authentication.getName());

        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public Authentication getAuthentication(String accessToken) {
        // Jwt 토큰 복호화
        Claims claims = parseClaims(accessToken);

        if (claims.get("auth") == null) {
            throw new RuntimeException();
        }

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // UserDetails 객체를 만들어서 Authentication return
        // UserDetails: interface, User: UserDetails를 구현한 class
        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
            throw new RuntimeException();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
            throw new RuntimeException();
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
            throw new RuntimeException();
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
            throw new RuntimeException();
        }
    }

    @Override
    public boolean logout(String refreshToken) {
        redisService.deleteValue(refreshToken);
        return true;
    }

    @Override
    public boolean existsRefreshToken(String refreshToken) {
        return redisService.getValue(refreshToken) != null;
    }

    @Override
    public Date parseExpiration(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getExpiration();
        } catch (JwtException exception) {
            throw new RuntimeException();
        }
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
