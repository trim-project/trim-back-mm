package trim.common.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import trim.domains.avatar.dao.entity.*;
import trim.domains.avatar.dao.entity.enums.*;
import trim.domains.avatar.dao.repository.*;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class AvatarPartsInitialize {

    private final HairRepository hairRepository;
    private final HairPartsRepository hairPartsRepository;

    private final EyesRepository eyesRepository;
    private final EyesPartsRepository eyesPartsRepository;

    private final MouthRepository mouthRepository;
    private final MouthPartsRepository mouthPartsRepository;

    private final ClothRepository clothRepository;
    private final ClothPartsRepository clothPartsRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        log.info("AvatarPartsInitialize 실행됨");
        initHairParts();
        initEyesParts();
        initMouthParts();
        initClothParts();
    }

    private void initHairParts() {
        Set<String> existing = hairPartsRepository.findAll().stream()
                .map(p -> p.getHair().getAvatarNumber().name() + "_" + p.getHairColor().getKey())
                .collect(Collectors.toSet());

        for (HairAvatarNumber avatarNumber : HairAvatarNumber.values()) {
            for (HairColor color : HairColor.values()) {
                String key = avatarNumber.name() + "_" + color.getKey();
                if (existing.contains(key)) continue;

                Hair hair = hairRepository.findByAvatarNumber(avatarNumber)
                        .orElseGet(() -> hairRepository.save(Hair.builder()
                                .avatarNumber(avatarNumber)
                                .price(10)
                                .build()));

                String url = "/images/hair/" + avatarNumber.name().toLowerCase() + "_" + color.getKey() + ".svg";
                HairParts part = HairParts.builder()
                        .hair(hair)
                        .hairColor(color)
                        .imageUrl(url)
                        .build();
                hairPartsRepository.save(part);
            }
        }
    }

    private void initEyesParts() {
        Set<String> existing = eyesPartsRepository.findAll().stream()
                .map(p -> p.getEyes().getAvatarNumber().name())
                .collect(Collectors.toSet());

        for (EyesAvatarNumber avatarNumber : EyesAvatarNumber.values()) {
            if (existing.contains(avatarNumber.name())) continue;

            Eyes eyes = eyesRepository.findByAvatarNumber(avatarNumber)
                    .orElseGet(() -> eyesRepository.save(Eyes.builder()
                            .avatarNumber(avatarNumber)
                            .price(10)
                            .build()));

            String url = "/images/eyes/" + avatarNumber.name().toLowerCase() + ".svg";
            EyesParts part = EyesParts.builder()
                    .eyes(eyes)
                    .imageUrl(url)
                    .build();
            eyesPartsRepository.save(part);
        }
    }

    private void initMouthParts() {
        Set<String> existing = mouthPartsRepository.findAll().stream()
                .map(p -> p.getMouth().getAvatarNumber().name())
                .collect(Collectors.toSet());

        for (MouthAvatarNumber avatarNumber : MouthAvatarNumber.values()) {
            if (existing.contains(avatarNumber.name())) continue;

            Mouth mouth = mouthRepository.findByAvatarNumber(avatarNumber)
                    .orElseGet(() -> mouthRepository.save(Mouth.builder()
                            .avatarNumber(avatarNumber)
                            .price(10)
                            .build()));

            String url = "/images/mouth/" + avatarNumber.name().toLowerCase() + ".svg";
            MouthParts part = MouthParts.builder()
                    .mouth(mouth)
                    .imageUrl(url)
                    .build();
            mouthPartsRepository.save(part);
        }
    }

    private void initClothParts() {
        Set<String> existing = clothPartsRepository.findAll().stream()
                .map(p -> p.getCloth().getAvatarNumber().name() + "_" + p.getClothColor().getKey())
                .collect(Collectors.toSet());

        for (ClothAvatarNumber avatarNumber : ClothAvatarNumber.values()) {
            for (ClothColor color : ClothColor.values()) {
                String key = avatarNumber.name() + "_" + color.getKey();
                if (existing.contains(key)) continue;

                Cloth cloth = clothRepository.findByAvatarNumber(avatarNumber)
                        .orElseGet(() -> clothRepository.save(Cloth.builder()
                                .avatarNumber(avatarNumber)
                                .price(10)
                                .build()));

                String url = "/images/cloth/" + avatarNumber.name().toLowerCase() + "_" + color.getKey() + ".svg";
                ClothParts part = ClothParts.builder()
                        .cloth(cloth)
                        .clothColor(color)
                        .imageUrl(url)
                        .build();
                clothPartsRepository.save(part);
            }
        }
    }
}
