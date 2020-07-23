package rightagile.badge.facade.aggregate.category.sdo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import rightagile.badge.aggregate.category.entity.Category;
import rightagile.badge.aggregate.category.entity.Subcategory;


@Setter
@Getter
@ToString
public class SubcategoryRdo {
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    private ParentCategory parentCategory;

    @Getter
    class ParentCategory {
        private Long id;
        private String code;
        private String name;
        private String iconUrl;

        private ParentCategory(Category category) {
            this.id = category.getId();
            this.code = category.getCode();
            this.name = category.getName();
            this.iconUrl = category.getIconUrl();
        }
    }

    @Builder
    public SubcategoryRdo(Long id, String code, String name, String iconUrl, Category category) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
        this.parentCategory = new ParentCategory(category);
    }

    public static SubcategoryRdo toDomain(Subcategory subcategory) {
        return SubcategoryRdo.builder().id(subcategory.getId())
                .code(subcategory.getCode())
                .name(subcategory.getName())
                .iconUrl(subcategory.getIconUrl())
                .category(subcategory.getParentCategory()).build();
    }
}


