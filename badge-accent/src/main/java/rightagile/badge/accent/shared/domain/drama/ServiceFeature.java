package rightagile.badge.accent.shared.domain.drama;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceFeature {
  String name();
  
  int order() default 0;
  
  String[] editions();
  
  String[] authorizedRoles();
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/drama/ServiceFeature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */