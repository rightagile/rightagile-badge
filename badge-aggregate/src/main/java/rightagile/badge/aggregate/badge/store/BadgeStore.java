package rightagile.badge.aggregate.badge.store;

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.badge.entity.Badge;

public interface BadgeStore {
    Badge create(Badge badge);

    Badge retrieve(Long badgeId);

    OffsetElementList<Badge> retrieveAll(Badge searchCondition, Offset offset);

    Badge update(Long badgeId, Badge badge);

    Badge patch(Long badgeId, Badge badge);

    void delete(Long badgeId);
}
