package rightagile.badge.rest.aggregate.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.badge.category.entity.Category;
import rightagile.badge.aggregate.badge.category.entity.Subcategory;
import rightagile.badge.aggregate.category.logic.CategoryLogic;
import rightagile.badge.facade.aggregate.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.sdo.SubcategoryCdo;
import rightagile.badge.facade.aggregate.sdo.SubcategoryRdo;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class CategoryResource {
    @Autowired
    private CategoryLogic categoryLogic;

    @GetMapping("categories/{categoryId}")
    public Category findCategory(@PathVariable(name="categoryId") Long categoryId) {
        return categoryLogic.findCategory(categoryId);
    }

    @GetMapping("categories/{categoryId}/subcategories")
    public List<Subcategory> findAllSubcategories(@PathVariable(name="categoryId") Long categoryId) {
        return categoryLogic.findAllSubcategories(categoryId);
    }

    @GetMapping("subcategories/{subcategoryId}")
    public SubcategoryRdo findSubcategory(Long subcategoryId) {
        return SubcategoryRdo.toDomain(categoryLogic.findSubcategory(subcategoryId));
    }

    @GetMapping("categories")
    public OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset) {
        return categoryLogic.findAllCategories(searchCondition, offset);
    }

    @PostMapping("categories")
    public Category registerCategory(@RequestBody CategoryCdo categoryCdo) {
        return categoryLogic.registerCategory(categoryCdo);
    }

    @PostMapping("categories/{categoryId}")
    public Subcategory registerSubcategory(@PathVariable(name="categoryId") Long categoryId, @RequestBody SubcategoryCdo subcategoryCdo) {
        return categoryLogic.registerSubcategory(categoryId, subcategoryCdo);
    }

    /*
//    @Override
    @PostMapping("/badges")
    public Badge registerBadge(@RequestBody BadgeCdo badgeCdo) {
        return badgeLogic.registerBadge(badgeCdo);
    }

    @GetMapping("/badges")
    public List<BadgeWithCategory> findAllBadges() {
        return badgeLogic.findAllBadges();
    }
     */
}
