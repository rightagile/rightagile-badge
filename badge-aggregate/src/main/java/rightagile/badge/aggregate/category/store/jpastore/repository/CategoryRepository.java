package rightagile.badge.aggregate.category.store.jpastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import rightagile.badge.aggregate.category.store.jpastore.jpo.CategoryJpo;

public interface CategoryRepository extends JpaRepository<CategoryJpo, Long>,
                                            QuerydslPredicateExecutor<CategoryJpo> {
}
