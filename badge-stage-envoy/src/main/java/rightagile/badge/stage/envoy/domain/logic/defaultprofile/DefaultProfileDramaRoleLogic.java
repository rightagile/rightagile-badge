/*    */
package rightagile.badge.stage.envoy.domain.logic.defaultprofile;
/*    */
/*    */

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class DefaultProfileDramaRoleLogic
        /*    */ implements DramaRoleService
        /*    */ {
    /*    */
    public List<String> findDramaRoleKeys(String cineroomId, List<String> cineroomRoles) {
        /* 18 */
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        /* 19 */
        HttpServletRequest request = requestAttributes.getRequest();
        /* 20 */
        return (List<String>) Arrays.<String>stream(request.getHeader("dramaRoles").split(",")).map(String::trim).collect(Collectors.toList());
        /*    */
    }

    /*    */
    /*    */
    public void registerDramaRoleMap(String cineroomId, DramaRoleMap dramaRoleMap) {
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/defaultprofile/DefaultProfileDramaRoleLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */