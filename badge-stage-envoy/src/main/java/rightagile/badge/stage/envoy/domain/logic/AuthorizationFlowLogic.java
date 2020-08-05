/*    */
package rightagile.badge.stage.envoy.domain.logic;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rightagile.badge.stage.envoy.context.DramaContext;
import rightagile.badge.stage.envoy.context.DramaRequest;
import rightagile.badge.stage.envoy.context.StageContext;
import rightagile.badge.stage.envoy.domain.spec.AuthorizationFlowService;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;
import rightagile.badge.stage.envoy.model.DramaAuthPolicy;
import rightagile.badge.stage.envoy.model.OperationAuthRole;

import java.util.List;

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
/*    */
/*    */
/*    */ public class AuthorizationFlowLogic implements AuthorizationFlowService {
    /* 16 */   private static final Logger log = LoggerFactory.getLogger(AuthorizationFlowLogic.class);
    /*    */
    /*    */   private final DramaRoleService dramaRoleService;
    /*    */
    /*    */   private final DramaAssignmentService dramaAssignmentService;

    /*    */
    /*    */
    /*    */
    public AuthorizationFlowLogic(EnvoyServiceLycler serviceLycler) {
        /* 24 */
        this.dramaRoleService = serviceLycler.requestDramaRoleService();
        /* 25 */
        this.dramaAssignmentService = serviceLycler.requestDramaAssignmentService();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public boolean isAuthorized(String[] editions, String featureName, String operationId) {
        /* 31 */
        DramaRequest dramaRequest = StageContext.getCurrentRequest();
        /* 32 */
        String cineroomId = dramaRequest.getCineroomId();
        /*    */
        /* 34 */
        boolean isAssigned = this.dramaAssignmentService.hasValidAssignment(cineroomId, editions);
        /* 35 */
        if (!isAssigned) {
            /* 36 */
            log.warn("not assigned cineroom {}, edition {}", cineroomId, editions);
            /* 37 */
            return false;
            /*    */
        }
        /*    */
        /* 40 */
        List<String> dramaRoleKeys = this.dramaRoleService.findDramaRoleKeys(cineroomId, dramaRequest
/* 41 */.getCineroomRoles());
        /* 42 */
        log.debug("cineroomRoles {}, dramaRoleKeys {}", dramaRequest.getCineroomRoles(), dramaRoleKeys);
        /* 43 */
        DramaAuthPolicy dramaAuthPolicy = DramaContext.getInstance().getDramaAuthPolicy();
        /* 44 */
        OperationAuthRole operationAuthRole = dramaAuthPolicy.getOperationAuthRole(featureName, operationId);
        /* 45 */
        for (String authRoleKey : operationAuthRole.getAuthRoleKeys()) {
            /* 46 */
            if (dramaRoleKeys.contains(authRoleKey)) {
                /* 47 */
                return true;
                /*    */
            }
            /*    */
        }
        /*    */
        /* 51 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/AuthorizationFlowLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */