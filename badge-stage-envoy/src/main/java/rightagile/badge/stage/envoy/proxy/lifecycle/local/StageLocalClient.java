/*    */
package rightagile.badge.stage.envoy.proxy.lifecycle.local;
/*    */
/*    */


import rightagile.badge.accent.shared.domain.cineroom.AudienceSdo;
import rightagile.badge.accent.shared.domain.cineroom.CineroomBaseRequest;
import rightagile.badge.stage.envoy.domain.spec.StageClient;

import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class StageLocalClient
        /*    */ implements StageClient
        /*    */ {
    /*    */
    public int countAudiences(String cineroomId) {
        /* 14 */
        return 0;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public List<AudienceSdo> findAudiences(CineroomBaseRequest cineroomBaseRequest) {
        /* 20 */
        return null;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/proxy/lifecycle/local/StageLocalClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */