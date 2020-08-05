/*    */
package rightagile.badge.stage.envoy.domain.spec.lifecycle.local;
/*    */
/*    */

import rightagile.badge.stage.envoy.domain.logic.AuthorizationFlowLogic;
import rightagile.badge.stage.envoy.domain.logic.DramaAssignmentLogic;
import rightagile.badge.stage.envoy.domain.logic.DramaRoleLogic;
import rightagile.badge.stage.envoy.domain.logic.StageClientLogic;
import rightagile.badge.stage.envoy.domain.spec.AuthorizationFlowService;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.spec.StageClient;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;
import rightagile.badge.stage.envoy.domain.store.lifecycle.EnvoyStoreLycler;
import rightagile.badge.stage.envoy.domain.store.lifecycle.memory.EnvoyMemoryStoreLycler;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;
import rightagile.badge.stage.envoy.proxy.lifecycle.local.EnvoyLocalProxyLycler;

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
/*    */
/*    */
/*    */ public class EnvoyLocalServiceLycler
        /*    */ implements EnvoyServiceLycler
        /*    */ {
    /*    */   private final DramaRoleService dramaRoleService;
    /*    */   private final DramaAssignmentService dramaAssignmentService;
    /*    */   private final AuthorizationFlowService authorizationFlowService;
    /*    */   private final StageClient stageClient;

    /*    */
    /*    */
    public EnvoyLocalServiceLycler(EnvoyStoreLycler storeLycler, EnvoyProxyLycler proxyLycler) {
        /* 27 */
        this.dramaRoleService = (DramaRoleService) new DramaRoleLogic(storeLycler, proxyLycler);
        /* 28 */
        this.dramaAssignmentService = (DramaAssignmentService) new DramaAssignmentLogic(storeLycler, proxyLycler);
        /* 29 */
        this.authorizationFlowService = (AuthorizationFlowService) new AuthorizationFlowLogic(this);
        /* 30 */
        this.stageClient = (StageClient) new StageClientLogic(proxyLycler);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaRoleService requestDramaRoleService() {
        /* 36 */
        return this.dramaRoleService;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAssignmentService requestDramaAssignmentService() {
        /* 42 */
        return this.dramaAssignmentService;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public AuthorizationFlowService requestAuthorizationFlowService() {
        /* 48 */
        return this.authorizationFlowService;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public StageClient requestStageClient() {
        /* 54 */
        return this.stageClient;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static EnvoyServiceLycler getInstance() {
        /* 59 */
        return LazyHolder.INSTANCE;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static EnvoyServiceLycler newInstance() {
        /* 64 */
        return new EnvoyLocalServiceLycler(
                /* 65 */         EnvoyMemoryStoreLycler.newInstance(), EnvoyLocalProxyLycler.newInstance());
        /*    */
    }

    /*    */
    /*    */   private static class LazyHolder
            /*    */ {
        /* 70 */     private static final EnvoyServiceLycler INSTANCE = new EnvoyLocalServiceLycler(
                /* 71 */         EnvoyMemoryStoreLycler.getInstance(), EnvoyLocalProxyLycler.getInstance());
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/spec/lifecycle/local/EnvoyLocalServiceLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */