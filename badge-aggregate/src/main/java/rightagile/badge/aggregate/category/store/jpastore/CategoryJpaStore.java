package rightagile.badge.aggregate.category.store.jpastore;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.OffsetElementList;
import rightagile.badge.aggregate.badge.category.entity.Category;
import rightagile.badge.aggregate.badge.category.entity.Subcategory;
import rightagile.badge.aggregate.category.store.CategoryStore;
import rightagile.badge.aggregate.category.store.jpastore.jpo.CategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.QCategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.QSubcategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.jpo.SubcategoryJpo;
import rightagile.badge.aggregate.category.store.jpastore.repository.CategoryRepository;
import rightagile.badge.aggregate.category.store.jpastore.repository.SubcategoryRepository;
import rightagile.badge.facade.aggregate.sdo.CategoryRdo;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryJpaStore implements CategoryStore {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    private CategoryJpo findCategoryJpoById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(()->new IllegalArgumentException(categoryId + " 카테고리가 없습니다."));
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

        QCategoryJpo category = QCategoryJpo.categoryJpo;
        QSubcategoryJpo subcategory = category.subcategoryJpoList.any();

        BooleanBuilder condition = new BooleanBuilder();

        condition.andAnyOf(
                (searchCondition.getId() != null) ? category.id.eq(searchCondition.getId()) : null,
                (searchCondition.getCode() != null) ? category.code.eq(searchCondition.getCode()) : null,
                (searchCondition.getName() != null) ? category.name.contains(searchCondition.getName()) : null,
                (searchCondition.getIconUrl() != null) ? category.iconUrl.contains(searchCondition.getIconUrl()) : null,
                (searchCondition.getSubcategoryId() != null) ? subcategory.id.eq(searchCondition.getSubcategoryId()) : null,
                (searchCondition.getSubcategoryCode() != null) ? subcategory.code.eq(searchCondition.getSubcategoryCode()) : null,
                (searchCondition.getSubcategoryName() != null) ? subcategory.name.contains(searchCondition.getSubcategoryName()) : null,
                (searchCondition.getSubcategoryIconUrl() != null) ? subcategory.iconUrl.contains(searchCondition.getSubcategoryIconUrl()) : null
        );

        Page<CategoryJpo> categoryJpoPage = categoryRepository.findAll(condition, pageable);
        return new OffsetElementList<>(categoryJpoPage.stream().map(CategoryJpo::toDomain).collect(Collectors.toList()),
                (int)categoryJpoPage.getTotalElements());
    }

    @Override
    public List<Subcategory> retrieveAllSubcategories(Long categoryId) {
        return findCategoryJpoById(categoryId).toDomain().getSubcategoryList();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public Subcategory retrieveSubcategory(Long subcategoryId) {
        SubcategoryJpo subcategoryJpo = subcategoryRepository.findById(subcategoryId)
                .orElseThrow(()->new IllegalArgumentException(subcategoryId + "서브카테고리가 없습니다."));
        return subcategoryJpo.toDomain();
    }


    @Override
    public void updateSubcategory(Subcategory subcategory) {

    }

    @Override
    public void deleteSubcategory(Long id) {

    }
}
