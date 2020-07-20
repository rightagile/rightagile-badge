package rightagile.badge.facade.aggregate.sdo;

import lombok.*;
import rightagile.badge.aggregate.badge.category.entity.Subcategory;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubcategoryCdo {
    private String code;
    private String name;
    private String iconUrl;

    public SubcategoryCdo(String code, String name, String iconUrl) {
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public Subcategory toDomain() {
        return Subcategory.builder().code(code).name(name).iconUrl(iconUrl).build();
    }
}
