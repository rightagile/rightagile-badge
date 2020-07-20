package rightagile.badge.aggregate.category.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.badge.category.entity.Category;
import rightagile.badge.aggregate.badge.category.entity.Subcategory;
import rightagile.badge.aggregate.category.store.CategoryStore;
import rightagile.badge.facade.aggregate.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.sdo.SubcategoryCdo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryLogic {
    @Autowired
    private CategoryStore categoryStore;

    public Category findCategory(Long id) {
        return categoryStore.retrieve(id);
    }

    public List<Subcategory> findAllSubcategories(Long categoryId) {
        return categoryStore.retrieveAllSubcategories(categoryId);
    }

    public OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset) {
        return categoryStore.retrieveAll(searchCondition, offset);
    }

    public Category registerCategory(CategoryCdo categoryCdo) {
        return categoryStore.create(categoryCdo.toDomain());
    }

    public Subcategory registerSubcategory(Long categoryId, SubcategoryCdo subcategoryCdo) {
        return categoryStore.createSubcategory(categoryId, subcategoryCdo.toDomain());
    }

    public Subcategory findSubcategory(Long id) {
        return categoryStore.retrieveSubcategory(id);
    }

}
