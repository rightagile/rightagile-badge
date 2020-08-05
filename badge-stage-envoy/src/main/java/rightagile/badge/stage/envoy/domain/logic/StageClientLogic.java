/*    */
package rightagile.badge.stage.envoy.domain.logic;
/*    */
/*    */

import rightagile.badge.accent.shared.domain.cineroom.AudienceSdo;
import rightagile.badge.accent.shared.domain.cineroom.CineroomBaseRequest;
import rightagile.badge.stage.client.EnvoyStageClient;
import rightagile.badge.stage.envoy.domain.spec.StageClient;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;

import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class StageClientLogic
        /*    */ implements StageClient
        /*    */ {
    /*    */   private final EnvoyStageClient envoyStageClient;

    /*    */
    /*    */
    public StageClientLogic(EnvoyProxyLycler proxyLycler) {
        /* 17 */
        this.envoyStageClient = proxyLycler.requestEnvoyStageClient();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public int countAudiences(String cineroomId) {
        /* 23 */
        return this.envoyStageClient.countAudiences(cineroomId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public List<AudienceSdo> findAudiences(CineroomBaseRequest cineroomBaseRequest) {
        /* 29 */
        return this.envoyStageClient.findAudiences(cineroomBaseRequest);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/StageClientLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */