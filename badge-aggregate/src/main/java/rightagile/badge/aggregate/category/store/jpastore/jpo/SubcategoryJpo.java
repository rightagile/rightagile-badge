package rightagile.badge.aggregate.category.store.jpastore.jpo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rightagile.badge.aggregate.badge.category.entity.Category;
import rightagile.badge.aggregate.badge.category.entity.Subcategory;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
@Entity(name="subcategory")
@SequenceGenerator(name="subcategory_seq_gen", sequenceName = "subcategory_seq")
public class SubcategoryJpo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "subcategory_seq_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name="parent_category_id")
    private CategoryJpo parentCategoryJpo;

    private String code;
    private String name;
    private String iconUrl;

    public SubcategoryJpo(CategoryJpo categoryJpo, Subcategory subcategory) {
        this.code = subcategory.getCode();
        this.name = subcategory.getName();
        this.iconUrl = subcategory.getIconUrl();
        this.parentCategoryJpo = categoryJpo;
    }

    /*
    public void setParentCategoryJpo(CategoryJpo categoryJpo) {
        this.parentCategoryJpo = categoryJpo;
    }
     */

    public Subcategory toDomain() {
        //
        return new Subcategory(id, code, name, iconUrl, parentCategoryJpo.toDomain());
    }

    public Subcategory toDomain(Category parentCategory) {
        //
        return new Subcategory(id, code, name, iconUrl, parentCategory);
    }

    public static List<Subcategory> toDomains(List<SubcategoryJpo> subcategoryJpoList) {
//        return subcategoryJpoList.stream().map(SubcategoryJpo::toDomain).collect(Collectors.toList());
        return null;
    }

}
