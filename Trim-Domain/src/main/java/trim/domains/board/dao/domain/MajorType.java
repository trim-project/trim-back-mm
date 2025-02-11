package trim.domains.board.dao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import trim.common.interfaces.KeyedEnum;

@Getter
@RequiredArgsConstructor
public enum MajorType implements KeyedEnum {
    // Humanities & Social Sciences
    LIBERAL_ARTS("Liberal Arts College"),
    SOCIAL_SCIENCES("Social Sciences College"),
    BUSINESS_ADMINISTRATION("Business Administration College"),
    LAW("Law College"),
    EDUCATION("Education College"),

    // Natural Sciences
    NATURAL_SCIENCES("Natural Sciences College"),
    LIFE_SCIENCES("Life Sciences College"),
    VETERINARY_MEDICINE("Veterinary Medicine College"),
    PHARMACY("Pharmacy College"),

    // Engineering
    ENGINEERING("Engineering College"),
    INFORMATION_COMMUNICATIONS("Information & Communications College"),
    INDUSTRIAL_ENGINEERING("Industrial Engineering College"),

    // Arts & Sports
    MUSIC("Music College"),
    FINE_ARTS("Fine Arts College"),
    PHYSICAL_EDUCATION("Physical Education College"),

    // Medical
    MEDICINE("Medical College"),
    DENTISTRY("Dentistry College"),
    NURSING("Nursing College"),

    // Agriculture & Marine
    AGRICULTURAL_LIFE_SCIENCES("Agricultural & Life Sciences College"),
    MARINE_SCIENCES("Marine Sciences College"),

    // Human Ecology
    HUMAN_ECOLOGY("Human Ecology College"),
    HOUSING_ENVIRONMENT("Housing Environment College");

    private final String key;
}
