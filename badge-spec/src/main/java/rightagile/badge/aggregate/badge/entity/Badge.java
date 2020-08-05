package rightagile.badge.aggregate.badge.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Badge {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;

    private Long subcategoryId;
    private BadgeType badgeType;
    private BadgeLevel badgeLevel;

    private Long totalLearningTime;

    private String managingOrganizations;
    private String designOrganizations;

    private String certificationDescription;
    private String acquisitionCondition;
    private String qualificationDescription;

    private Person manager;

    private String tags;
}
