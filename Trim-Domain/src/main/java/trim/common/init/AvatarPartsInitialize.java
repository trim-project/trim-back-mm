package trim.common.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import trim.domains.avatar.dao.entity.enums.*;
import trim.domains.avatar.dao.entity.item.Cloth;
import trim.domains.avatar.dao.entity.item.Eyes;
import trim.domains.avatar.dao.entity.item.Hair;
import trim.domains.avatar.dao.entity.item.Mouth;
import trim.domains.avatar.dao.entity.parts.ClothParts;
import trim.domains.avatar.dao.entity.parts.EyesParts;
import trim.domains.avatar.dao.entity.parts.HairParts;
import trim.domains.avatar.dao.entity.parts.MouthParts;
import trim.domains.avatar.dao.repository.item.ClothRepository;
import trim.domains.avatar.dao.repository.item.EyesRepository;
import trim.domains.avatar.dao.repository.item.HairRepository;
import trim.domains.avatar.dao.repository.item.MouthRepository;
import trim.domains.avatar.dao.repository.parts.ClothPartsRepository;
import trim.domains.avatar.dao.repository.parts.EyesPartsRepository;
import trim.domains.avatar.dao.repository.parts.HairPartsRepository;
import trim.domains.avatar.dao.repository.parts.MouthPartsRepository;

import java.util.Arrays;
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

                // enum 이름 조합: HAIR_1_DARK_BROWN
                String enumName = "HAIR_" + avatarNumber.name().replace("HAIR_", "") + "_" + color.name();
                HairForURL imageEnum = HairForURL.valueOf(enumName);

                HairParts part = HairParts.builder()
                        .hair(hair)
                        .hairColor(color)
                        .imageUrl(imageEnum)
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

            String enumName = "EYES_" + avatarNumber.name().replace("EYES_", "");
            EyesForURL imageEnum = EyesForURL.valueOf(enumName);

            EyesParts part = EyesParts.builder()
                    .eyes(eyes)
                    .imageUrl(imageEnum)
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

            String enumName = "MOUTH_" + avatarNumber.name().replace("MOUTH_", "");
            MouthForURL imageEnum = MouthForURL.valueOf(enumName);

            MouthParts part = MouthParts.builder()
                    .mouth(mouth)
                    .imageUrl(imageEnum)
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

                // enum 이름 예시: RED_R1
                String enumName = color.name() + "_" + avatarNumber.name().replace("CLOTH_", "");
                ClothForURL imageEnum = ClothForURL.valueOf(enumName);

                ClothParts part = ClothParts.builder()
                        .cloth(cloth)
                        .clothColor(color)
                        .imageUrl(imageEnum)
                        .build();

                clothPartsRepository.save(part);
            }
        }
    }

}
