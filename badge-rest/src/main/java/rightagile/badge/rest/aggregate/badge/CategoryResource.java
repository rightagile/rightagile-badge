package rightagile.badge.rest.aggregate.badge;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.aggregate.category.service.CategoryTaskService;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryRdo;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class CategoryResource /*implements CategoryTaskFacade */{
    private final CategoryTaskService categoryTaskService;

    public CategoryResource(CategoryTaskService categoryTaskService) {
        this.categoryTaskService = categoryTaskService;
    }

    @PostMapping("categories")
    public Category registerCategory(@RequestBody CategoryCdo categoryCdo) {
        return categoryTaskService.registerCategory(categoryCdo);
    }

    @GetMapping("categories/{categoryId}")
    public Category findCategory(@PathVariable(name="categoryId") Long categoryId) throws HttpRequestMethodNotSupportedException {
        /*
        System.out.println("NOT EXECUTED");
        if(true) {
            throw new EntityNotFoundException();
            //throw new IllegalArgumentException("TEst");
        }
         */

        //if(true) {
        //    throw new HttpRequestMethodNotSupportedException("TEST");
        //}
        return categoryTaskService.findCategory(categoryId);
    }

    @GetMapping("categories")
    public OffsetElementList<Category> findAllCategories(CategoryRdo searchCondition, Offset offset) {
        return categoryTaskService.findAllCategories(searchCondition, offset);
    }

    @PutMapping("categories")
    public Category updateCategory(Long categoryId, @RequestBody CategoryCdo categoryCdo) {
       return categoryTaskService.modifyCategory(categoryId, categoryCdo, false);
    }

    @PatchMapping("categories")
    public Category patchCategory(Long categoryId, @RequestBody CategoryCdo categoryCdo) {
        return categoryTaskService.modifyCategory(categoryId, categoryCdo, true);
    }

    @DeleteMapping("categories")
    public void removeCategory(Long categoryId) {
        categoryTaskService.removeCategory(categoryId);
    }


    @PostMapping("categories/{categoryId}/subcategories")
    public Subcategory registerSubcategoryOfCategory(@PathVariable(name="categoryId") Long categoryId, @RequestBody SubcategoryCdo subcategoryCdo) {
        return categoryTaskService.registerSubcategoryOfCategory(categoryId, subcategoryCdo);
    }

    @GetMapping("categories-subcategories/{subcategoryId}")
    public SubcategoryRdo findSubcategory(@PathVariable(name="subcategoryId") Long subcategoryId) {
        return SubcategoryRdo.toDomain(categoryTaskService.findSubcategory(subcategoryId));
    }

    @GetMapping("categories/{categoryId}/subcategories")
    public List<Subcategory> findAllSubcategoriesOfCategory(@PathVariable(name="categoryId") Long categoryId) {
        return categoryTaskService.findAllSubcategoriesOfCategory(categoryId);
    }

    @PutMapping("categories-subcategories/{subcategoryId}")
    public Subcategory updateSubcategory(@PathVariable(name="subcategoryId") Long subcategoryId, @RequestBody SubcategoryCdo subcategoryCdo) {
        return categoryTaskService.modifySubcategory(subcategoryId, subcategoryCdo, false);
    }

    @PatchMapping("categories-subcategories/{subcategoryId}")
    public Subcategory patchSubcategory(@PathVariable(name="subcategoryId") Long subcategoryId, @RequestBody SubcategoryCdo subcategoryCdo) {
        return categoryTaskService.modifySubcategory(subcategoryId, subcategoryCdo, true);
    }
}
