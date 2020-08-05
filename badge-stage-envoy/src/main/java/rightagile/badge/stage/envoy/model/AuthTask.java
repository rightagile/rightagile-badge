/*    */
package rightagile.badge.stage.envoy.model;
/*    */
/*    */

import java.util.List;

/*    */
/*    */
/*    */ public class AuthTask
        /*    */ {
    /*    */   private final DramaAuthPolicy dramaAuthPolicy;

    /*    */
    /*    */
    public AuthTask(DramaAuthPolicy authPolicy) {
        /* 11 */
        this.dramaAuthPolicy = authPolicy;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public boolean isAuthorizedInFeature(String featureName, String roleKey) {
        /* 17 */
        return false;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public boolean isAuthorizedInOperation(String operationId, List<String> roleKeys) {
        /* 23 */
        return false;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public boolean isAuthorizedInOperation(String featureName, String operationId, List<String> roleKeys) {
        /* 28 */
        OperationAuthRole operationAuthRole = this.dramaAuthPolicy.getFeatureAuthRoleMap().get(featureName).getOperationAuthRoleMap().get(operationId);
        /* 29 */
        for (String authRoleKey : operationAuthRole.getAuthRoleKeys()) {
            /* 30 */
            if (roleKeys.contains(authRoleKey)) {
                /* 31 */
                return true;
                /*    */
            }
            /*    */
        }
        /* 34 */
        return false;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public boolean isAuthorized(String[] authorizedRoleNames, List<String> roleKeys) {
        /* 39 */
        for (String roleName : authorizedRoleNames) {
            /* 40 */
            if (roleKeys.contains(roleName)) {
                /* 41 */
                return true;
                /*    */
            }
            /*    */
        }
        /* 44 */
        return false;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public DramaAuthPolicy getDramaAuthPolicy() {
        /* 49 */
        return this.dramaAuthPolicy;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/model/AuthTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */