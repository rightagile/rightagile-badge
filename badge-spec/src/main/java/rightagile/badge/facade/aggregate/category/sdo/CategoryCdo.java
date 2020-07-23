package rightagile.badge.facade.aggregate.category.sdo;

import lombok.*;
import rightagile.badge.aggregate.category.entity.Category;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryCdo {
    private String code;
    private String name;
    private String iconUrl;

    public CategoryCdo(String code, String name, String iconUrl) {
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public Category toDomain() {
        return Category.builder().code(code).name(name).iconUrl(iconUrl).build();
    }
}
