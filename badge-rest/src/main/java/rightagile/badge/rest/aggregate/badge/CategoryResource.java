package rightagile.badge.rest.aggregate.badge;

import org.springframework.web.bind.annotation.*;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.aggregate.category.service.CategoryTaskService;
import rightagile.badge.facade.aggregate.category.CategoryTaskFacade;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryRdo;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class CategoryResource implements CategoryTaskFacade {
    private final CategoryTaskService categoryTaskService;

    public CategoryResource(CategoryTaskService categoryTaskService) {
        this.categoryTaskService = categoryTaskService;
    }

    @GetMapping("categories/{categoryId}")
    public Category findCategory(@PathVariable(name="categoryId") Long categoryId) {
        return categoryTaskService.findCategory(categoryId);
    }

    @GetMapping("categories/{categoryId}/subcategories")
    public List<Subcategory> findAllSubcategoriesOfCategory(@PathVariable(name="categoryId") Long categoryId) {
        return categoryTaskService.findAllSubcategoriesOfCategory(categoryId);
    }

    @GetMapping("subcategories/{subcategoryId}")
    public SubcategoryRdo findSubcategory(@PathVariable(name="subcategoryId") Long subcategoryId) {
        return SubcategoryRdo.toDomain(categoryTaskService.findSubcategory(subcategoryId));
    }

    @GetMapping("categories")
    public OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset) {
        return categoryTaskService.findAllCategories(searchCondition, offset);
    }

    @PostMapping("categories")
    public Category registerCategory(@RequestBody CategoryCdo categoryCdo) {
        return categoryTaskService.registerCategory(categoryCdo);
    }

    @PostMapping("categories/{categoryId}")
    public Subcategory registerSubcategoryOfCategory(@PathVariable(name="categoryId") Long categoryId, @RequestBody SubcategoryCdo subcategoryCdo) {
        return categoryTaskService.registerSubcategoryOfCategory(categoryId, subcategoryCdo);
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
