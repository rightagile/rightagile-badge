package rightagile.badge.aggregate.badge.store.jpastore.jpo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import rightagile.badge.aggregate.badge.entity.BadgeLevel;
import rightagile.badge.aggregate.badge.entity.BadgeType;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "badge")
@SequenceGenerator(name = "badge_seq_gen", sequenceName = "badge_seq")
public class BadgeJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    private Long id;

    private String name;

    private Long subcategoryId;

    @Enumerated(EnumType.STRING)
    private BadgeType badgeType;

    @Enumerated(EnumType.STRING)
    private BadgeLevel badgeLevel;

    private Long totalLearningTime;

    private String managingOrganizations;
    private String designOrganizations;

    private String certificationDescription;
    private String acquisitionCondition;
    private String qualificationDescription;

    @ElementCollection
    private List<PersonJpo> manager;

    private String tags;
}
