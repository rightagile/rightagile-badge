package rightagile.badge.facade.aggregate.sdo;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class CategoryRdo {
    private Long id;

    private String code;
    private String name;
    private String iconUrl;

    private Long subcategoryId;

    private String subcategoryCode;
    private String subcategoryName;
    private String subcategoryIconUrl;

}
