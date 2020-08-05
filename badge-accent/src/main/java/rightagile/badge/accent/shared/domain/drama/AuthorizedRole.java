package rightagile.badge.accent.shared.domain.drama;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizedRole {
  String[] roleNames();
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/drama/AuthorizedRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */