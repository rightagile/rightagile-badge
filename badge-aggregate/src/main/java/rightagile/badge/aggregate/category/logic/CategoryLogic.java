package rightagile.badge.aggregate.category.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.aggregate.category.service.CategoryTaskService;
import rightagile.badge.aggregate.category.store.CategoryStore;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;

import java.util.List;

@Service
@Transactional
public class CategoryLogic implements CategoryTaskService {
    private final CategoryStore categoryStore;

    public CategoryLogic(CategoryStore categoryStore) {
        this.categoryStore = categoryStore;
    }

    @Override
    public Category registerCategory(CategoryCdo categoryCdo) {
        return categoryStore.create(categoryCdo.toDomain());
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategory(Long categoryId) {
        return categoryStore.retrieve(categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset) {
        return categoryStore.retrieveAll(searchCondition, offset);
    }

    @Override
    public Subcategory registerSubcategoryOfCategory(Long categoryId, SubcategoryCdo subcategoryCdo) {
        return categoryStore.createSubcategory(categoryId, subcategoryCdo.toDomain());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subcategory> findAllSubcategoriesOfCategory(Long categoryId) {
        return categoryStore.retrieveAllSubcategories(categoryId);
    }

    @Transactional(readOnly = true)
    public Subcategory findSubcategory(Long subcategoryId) {
        return categoryStore.retrieveSubcategory(subcategoryId);
    }
}
