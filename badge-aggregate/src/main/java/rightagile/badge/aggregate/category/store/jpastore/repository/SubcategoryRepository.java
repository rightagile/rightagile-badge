package rightagile.badge.aggregate.category.store.jpastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import rightagile.badge.aggregate.category.store.jpastore.jpo.SubcategoryJpo;

public interface SubcategoryRepository extends JpaRepository<SubcategoryJpo, Long>,
                                               QuerydslPredicateExecutor<SubcategoryJpo> {
}
