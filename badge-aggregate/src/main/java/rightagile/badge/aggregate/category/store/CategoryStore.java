package rightagile.badge.aggregate.category.store;

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;

import java.util.List;

public interface CategoryStore {
    Category create(Category category);
    Category retrieve(Long categoryId);
    OffsetElementList<Category> retrieveAll(CategoryRdo searchCondition, Offset offset);
    void update(Category category);
    void delete(Long categoryId);

    Subcategory createSubcategory(Long categoryId, Subcategory subcategory);
    Subcategory retrieveSubcategory(Long id);
    List<Subcategory> retrieveAllSubcategories(Long categoryId);
    void updateSubcategory(Subcategory subcategory);
    void deleteSubcategory(Long id);
}