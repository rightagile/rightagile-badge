package rightagile.badge.facade.aggregate.category;

import rightagile.badge.accent.shared.domain.FacadeCandidate;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.accent.shared.domain.drama.ServiceFeature;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryRdo;

import java.util.List;

@FacadeCandidate
@ServiceFeature(name = "CategoryTask", editions = { "Standard" }, authorizedRoles = { "User", "CompanyManager", "CollegeManager", "SuperManager" })
public interface CategoryTaskFacade {
    Category registerCategory(CategoryCdo categoryCdo);
    Category findCategory(Long categoryId);
    OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset);
    Category updateCategory(Long categoryId, CategoryCdo categoryCdo);
    Category patchCategory(Long categoryId, CategoryCdo categoryCdo);
    void removeCategory(Long categoryId);

    Subcategory registerSubcategoryOfCategory(Long categoryId, SubcategoryCdo subcategoryCdo);
    List<Subcategory> findAllSubcategoriesOfCategory(Long categoryId);
    Subcategory updateSubcategory(Long subcategoryId, SubcategoryCdo subcategoryCdo);
    Subcategory patchSubcategory(Long subcategoryId, SubcategoryCdo subcategoryCdo);

    SubcategoryRdo findSubcategory(Long subcategoryId);
}
