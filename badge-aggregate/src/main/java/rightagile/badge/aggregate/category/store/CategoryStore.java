package rightagile.badge.aggregate.category.store;

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;

import java.util.List;

public interface CategoryStore {
    Category create(Category category);

    Category retrieve(Long categoryId);

    OffsetElementList<Category> retrieveAll(CategoryRdo searchCondition, Offset offset);

    Category update(Long categoryId, CategoryCdo categoryCdo);

    Category patch(Long categoryId, CategoryCdo categoryCdo);

    void delete(Long categoryId);

    Subcategory createSubcategory(Long categoryId, Subcategory subcategory);

    Subcategory retrieveSubcategory(Long id);

    List<Subcategory> retrieveAllSubcategories(Long categoryId);

    Subcategory updateSubcategory(Long subcategoryId, SubcategoryCdo subcategory);
    Subcategory patchSubcategory(Long subcategoryId, SubcategoryCdo subcategory);

    void deleteSubcategory(Long id);
}