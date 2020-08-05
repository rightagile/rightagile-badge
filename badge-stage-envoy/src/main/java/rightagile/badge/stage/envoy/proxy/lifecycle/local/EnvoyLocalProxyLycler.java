/*    */
package rightagile.badge.stage.envoy.proxy.lifecycle.local;
/*    */
/*    */


import rightagile.badge.stage.client.EnvoyStageClient;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class EnvoyLocalProxyLycler
        /*    */ implements EnvoyProxyLycler
        /*    */ {
    /* 12 */   private final EnvoyStageClient envoyStageClient = new EnvoyStageLocalClient();

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public EnvoyStageClient requestEnvoyStageClient() {
        /* 18 */
        return this.envoyStageClient;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static EnvoyProxyLycler getInstance() {
        /* 23 */
        return LazyHolder.INSTANCE;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static EnvoyProxyLycler newInstance() {
        /* 28 */
        return new EnvoyLocalProxyLycler();
        /*    */
    }

    /*    */
    /*    */   private static class LazyHolder
            /*    */ {
        /* 33 */     private static final EnvoyProxyLycler INSTANCE = new EnvoyLocalProxyLycler();
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/proxy/lifecycle/local/EnvoyLocalProxyLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */