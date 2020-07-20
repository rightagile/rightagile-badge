package rightagile.badge.facade.aggregate.sdo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import rightagile.badge.aggregate.badge.category.entity.Category;
import rightagile.badge.aggregate.badge.category.entity.Subcategory;

@Setter
@Getter
@ToString
public class SubcategoryRdo {
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    private Category category;

    @Builder
    public SubcategoryRdo(Long id, String code, String name, String iconUrl, Category category) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
        this.category = category;
    }

    public static SubcategoryRdo toDomain(Subcategory subcategory) {
        return SubcategoryRdo.builder().id(subcategory.getId())
                .code(subcategory.getCode())
                .name(subcategory.getName())
                .iconUrl(subcategory.getIconUrl()).category(subcategory.getParentCategory()).build();
    }
}
