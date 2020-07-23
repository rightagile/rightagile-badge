package rightagile.badge.aggregate.category.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@ToString(exclude="parentCategory")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subcategory {
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    @JsonBackReference
    private Category parentCategory;

    @Builder
    public Subcategory(Long id, String code, String name, String iconUrl, Category category) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
        this.parentCategory = category;
    }
}
