package rightagile.badge.aggregate.category.store.jpastore.jpo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import rightagile.badge.aggregate.category.entity.Category;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "category")
@SequenceGenerator(name = "category_seq_gen", sequenceName = "category_seq")
public class CategoryJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "parentCategoryJpo", fetch = FetchType.EAGER)
    private List<SubcategoryJpo> subcategoryJpoList;

    public CategoryJpo(Category category) {
        this.code = category.getCode();
        this.name = category.getName();
        this.iconUrl = category.getIconUrl();
    }

    public CategoryJpo update(Category category) {
        this.code = category.getCode();
        this.name = category.getName();
        this.iconUrl = category.getIconUrl();

        return this;
    }

    public CategoryJpo patch(Category category) {
        this.code = (category.getCode() != null) ? category.getCode() : this.code;
        this.name = (category.getName() != null) ? category.getName() : this.name;
        this.iconUrl = (category.getIconUrl() != null) ? category.getIconUrl() : this.iconUrl;

        return this;
    }

    public Category toDomain() {
        Category category = new Category(id, code, name, iconUrl);

        if (subcategoryJpoList != null) {
            category.setSubcategoryList(subcategoryJpoList.stream().map(subcategoryJpo -> subcategoryJpo.toDomain(category))
                    .collect(Collectors.toList()));
        }
        return category;
    }
}
