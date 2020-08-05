package rightagile.badge.aggregate.badge.store.jpastore.jpo;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PersonJpo {
    private String name;
    private String email;
    private String company;
    private String department;
}
