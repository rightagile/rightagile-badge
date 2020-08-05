/*   */
package rightagile.badge.stage.envoy.domain.logic.defaultprofile;
/*   */
/*   */


import rightagile.badge.stage.envoy.domain.spec.AuthorizationFlowService;

/*   */
/*   */ public class DefaultProfileAuthorizationFlowLogic
        /*   */ implements AuthorizationFlowService
        /*   */ {
    /*   */
    public boolean isAuthorized(String[] editions, String featureName, String operationId) {
        /* 9 */
        return true;
        /*   */
    }
    /*   */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/defaultprofile/DefaultProfileAuthorizationFlowLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */