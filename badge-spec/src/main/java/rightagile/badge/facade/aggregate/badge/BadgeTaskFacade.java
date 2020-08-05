package rightagile.badge.facade.aggregate.badge;

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.badge.entity.Badge;

public interface BadgeTaskFacade {
    Badge registerBadge(Badge badge);
    Badge findBadge(Long categoryId);
    OffsetElementList<Badge> findAllBadges(Badge searchCondition, Offset offset);
    Badge updateBadge(Long badgeId, Badge badge);
    Badge patchBadge(Long badgeId, Badge badge);
    void removeBadge(Long badgeId);
}
