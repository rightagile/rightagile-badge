package rightagile.badge.aggregate.category.service;

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;

import java.util.List;


public interface CategoryTaskService {
    Category registerCategory(CategoryCdo categoryCdo);

    Category findCategory(Long categoryId);

    OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset);

    Category modifyCategory(Long categoryId, CategoryCdo categoryCdo, boolean patched);

    void removeCategory(Long categoryId);

    Subcategory registerSubcategoryOfCategory(Long categoryId, SubcategoryCdo subcategoryCdo);

    List<Subcategory> findAllSubcategoriesOfCategory(Long categoryId);

    Subcategory findSubcategory(Long subcategoryId);

    Subcategory modifySubcategory(Long subcategoryId, SubcategoryCdo categoryCdo, boolean patched);

}
