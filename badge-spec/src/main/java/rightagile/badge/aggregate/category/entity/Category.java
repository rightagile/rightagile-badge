package rightagile.badge.aggregate.category.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Setter(value = AccessLevel.NONE)
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    @JsonManagedReference
    private List<Subcategory> subcategoryList;

    @Builder
    public Category(Long id, String code, String name, String iconUrl) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
        this.subcategoryList = new ArrayList<>();
    }
}
