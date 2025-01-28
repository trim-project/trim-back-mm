package trim.domains.tag.dao.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import trim.common.model.BaseTimeEntity;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tag", indexes = {
        @Index(name = "idx_tag_name", columnList = "name")
})
public class Tag extends BaseTimeEntity {

    private static final int MAX_TAG_LENGTH = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = MAX_TAG_LENGTH)
    private String name;

    public static Tag of(String name) {
        return Tag.builder()
                .name(name)
                .build();
    }

}
