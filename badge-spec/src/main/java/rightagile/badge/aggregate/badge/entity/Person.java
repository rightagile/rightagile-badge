package rightagile.badge.aggregate.badge.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {
    private String name;
    private String email;
    private String company;
    private String department;
}
