package rightagile.badge.facade.aggregate.category;

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryRdo;

import java.util.List;

public interface CategoryTaskFacade {
    Category registerCategory(CategoryCdo categoryCdo);
    Category findCategory(Long categoryId);
    OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset);

    Subcategory registerSubcategoryOfCategory(Long categoryId, SubcategoryCdo subcategoryCdo);
    List<Subcategory> findAllSubcategoriesOfCategory(Long categoryId);

    SubcategoryRdo findSubcategory(Long id);
}
