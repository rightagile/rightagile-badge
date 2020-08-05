/*    */
package rightagile.badge.stage.envoy.domain.logic.defaultprofile;
/*    */
/*    */

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import rightagile.badge.accent.shared.domain.patron.AudienceKey;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.model.DramaAssignment;

import javax.servlet.http.HttpServletRequest;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class DefaultProfileDramaAssignmentLogic
        /*    */ implements DramaAssignmentService
        /*    */ {
    /*    */
    public boolean hasValidAssignment(String cineroomId, String[] editions) {
        /* 16 */
        return true;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAssignment findDramaAssignment(String cineroom) {
        /* 22 */
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        /* 23 */
        HttpServletRequest request = requestAttributes.getRequest();
        /* 24 */
        String audienceId = request.getHeader("audienceId");
        /* 25 */
        String cineroomUsid = request.getHeader("cineroomUsid");
        /* 26 */
        String cineroomId = AudienceKey.fromKeyString(audienceId).genCineroomKeyString();
        /* 27 */
        return new DramaAssignment(cineroomId, cineroomUsid, true, "Standard");
        /*    */
    }

    /*    */
    /*    */
    public void registerAssignment(String cineroomId, String cineroomUsid, String edition) {
    }

    /*    */
    /*    */
    public void removeAssignment(String cineroomId) {
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/defaultprofile/DefaultProfileDramaAssignmentLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */