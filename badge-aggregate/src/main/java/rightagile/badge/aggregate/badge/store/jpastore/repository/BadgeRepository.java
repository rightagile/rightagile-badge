package rightagile.badge.aggregate.badge.store.jpastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import rightagile.badge.aggregate.badge.store.jpastore.jpo.BadgeJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.CategoryJpo;

public interface BadgeRepository extends JpaRepository<CategoryJpo, Long>,
        QuerydslPredicateExecutor<BadgeJpo> {
}
