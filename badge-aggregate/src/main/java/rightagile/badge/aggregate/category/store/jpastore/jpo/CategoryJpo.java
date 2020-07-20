package rightagile.badge.aggregate.category.store.jpastore.jpo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import rightagile.badge.aggregate.badge.category.entity.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="category")
@SequenceGenerator(name="category_seq_gen", sequenceName = "category_seq")
public class CategoryJpo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "category_seq_gen")
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    @OneToMany(mappedBy = "parentCategoryJpo", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<SubcategoryJpo> subcategoryJpoList;

    public CategoryJpo(Category category) {
        this.code = category.getCode();
        this.name = category.getName();
        this.iconUrl = category.getIconUrl();
    }

    public Category toDomain() {
        Category category = new Category(id, code, name, iconUrl);

        if(subcategoryJpoList != null) {
            category.setSubcategoryList(subcategoryJpoList.stream().map(subcategoryJpo -> subcategoryJpo.toDomain(category))
                    .collect(Collectors.toList()));
        }
        return category;
    }
}
