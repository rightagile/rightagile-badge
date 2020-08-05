package rightagile.badge.aggregate.category.store.jpastore;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;
import rightagile.badge.aggregate.category.store.CategoryStore;
import rightagile.badge.aggregate.category.store.jpastore.jpo.CategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.QCategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.QSubcategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.SubcategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.repository.CategoryRepository;
import rightagile.badge.aggregate.category.store.jpastore.repository.SubcategoryRepository;
import rightagile.badge.exception.BadgeException;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.CategoryRdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryJpaStore implements CategoryStore {
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public CategoryJpaStore(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(new CategoryJpo(category)).toDomain();
    }

    @Override
    public Subcategory createSubcategory(Long categoryId, Subcategory subcategory) {
        CategoryJpo categoryJpo = findCategoryJpoById(categoryId);

        return subcategoryRepository.save(new SubcategoryJpo(categoryJpo, subcategory)).toDomain();
    }

    @Override
    public Category retrieve(Long categoryId) {
        return findCategoryJpoById(categoryId).toDomain();
    }

    @Override
    public OffsetElementList<Category> retrieveAll(CategoryRdo searchCondition, Offset offset) {
        Pageable pageable = PageRequest.of(offset.page(), offset.limit());
        Page<CategoryJpo> categoryJpoPage = categoryRepository.findAll(makePredicate(searchCondition), pageable);

        return new OffsetElementList<>(categoryJpoPage.stream().map(CategoryJpo::toDomain).collect(Collectors.toList()),
                (int) categoryJpoPage.getTotalElements());
    }

    @Override
    public List<Subcategory> retrieveAllSubcategories(Long categoryId) {
        return findCategoryJpoById(categoryId).toDomain().getSubcategoryList();
    }

    @Override
    public Category update(Long categoryId, CategoryCdo categoryCdo) {
        CategoryJpo categoryJpo = findCategoryJpoById(categoryId);
        return categoryJpo.update(categoryCdo.toDomain()).toDomain();
    }

    @Override
    public Category patch(Long categoryId, CategoryCdo categoryCdo) {
        CategoryJpo categoryJpo = findCategoryJpoById(categoryId);
        return categoryJpo.patch(categoryCdo.toDomain()).toDomain();
    }

    @Override
    public void delete(Long categoryId) {
        CategoryJpo categoryJpo = findCategoryJpoById(categoryId);
        categoryRepository.delete(categoryJpo);
    }

    @Override
    public Subcategory retrieveSubcategory(Long subcategoryId) {
        return findSubcategoryJpoById(subcategoryId).toDomain();
    }

    @Override
    public Subcategory updateSubcategory(Long subcategoryId, SubcategoryCdo subcategoryCdo) {
        SubcategoryJpo categoryJpo = findSubcategoryJpoById(subcategoryId);
        return categoryJpo.update(subcategoryCdo.toDomain()).toDomain();
    }

    @Override
    public Subcategory patchSubcategory(Long subcategoryId, SubcategoryCdo subcategoryCdo) {
        SubcategoryJpo categoryJpo = findSubcategoryJpoById(subcategoryId);
        return categoryJpo.patch(subcategoryCdo.toDomain()).toDomain();
    }

    @Override
    public void deleteSubcategory(Long id) {

    }

    private CategoryJpo findCategoryJpoById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new BadgeException(BadgeException.Type.NOT_FOUND_ENTITY, categoryId + " Category Not Found"));
    }

    private SubcategoryJpo findSubcategoryJpoById(Long subcategoryId) {
        return subcategoryRepository.findById(subcategoryId).orElseThrow(() -> new BadgeException(BadgeException.Type.NOT_FOUND_ENTITY, subcategoryId + " Subcategory Not Found"));
    }

    private Predicate makePredicate(CategoryRdo searchCondition) {
        QCategoryJpo category = QCategoryJpo.categoryJpo;
        QSubcategoryJpo subcategory = category.subcategoryJpoList.any();

        return new BooleanBuilder().andAnyOf(
                (searchCondition.getId() != null) ? category.id.eq(searchCondition.getId()) : null,
                (searchCondition.getCode() != null) ? category.code.eq(searchCondition.getCode()) : null,
                (searchCondition.getName() != null) ? category.name.contains(searchCondition.getName()) : null,
                (searchCondition.getIconUrl() != null) ? category.iconUrl.contains(searchCondition.getIconUrl()) : null,
                (searchCondition.getSubcategoryId() != null) ? subcategory.id.eq(searchCondition.getSubcategoryId()) : null,
                (searchCondition.getSubcategoryCode() != null) ? subcategory.code.eq(searchCondition.getSubcategoryCode()) : null,
                (searchCondition.getSubcategoryName() != null) ? subcategory.name.contains(searchCondition.getSubcategoryName()) : null,
                (searchCondition.getSubcategoryIconUrl() != null) ? subcategory.iconUrl.contains(searchCondition.getSubcategoryIconUrl()) : null
        );
    }
}
