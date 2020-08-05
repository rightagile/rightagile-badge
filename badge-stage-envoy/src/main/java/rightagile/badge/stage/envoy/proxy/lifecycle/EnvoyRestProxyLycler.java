/*    */
package rightagile.badge.stage.envoy.proxy.lifecycle;
/*    */
/*    */

import org.springframework.stereotype.Component;
import rightagile.badge.stage.client.EnvoyStageClient;
import rightagile.badge.stage.client.StageEnvoyClient;

/*    */
/*    */
/*    */
/*    */
@Component
/*    */ public class EnvoyRestProxyLycler
        /*    */ implements EnvoyProxyLycler
        /*    */ {
    /*    */   private final EnvoyStageClient envoyStageClient;

    /*    */
    /*    */
    public EnvoyRestProxyLycler(StageEnvoyClient stageEnvoyClient) {
        /* 14 */
        this.envoyStageClient = (EnvoyStageClient) stageEnvoyClient;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public EnvoyStageClient requestEnvoyStageClient() {
        /* 20 */
        return this.envoyStageClient;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/proxy/lifecycle/EnvoyRestProxyLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */