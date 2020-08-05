/*    */
package rightagile.badge.stage.envoy.service.lifecycle;
/*    */
/*    */


import rightagile.badge.stage.envoy.domain.logic.AuthorizationFlowLogic;
import rightagile.badge.stage.envoy.domain.logic.DramaAssignmentLogic;
import rightagile.badge.stage.envoy.domain.logic.DramaRoleLogic;
import rightagile.badge.stage.envoy.domain.logic.StageClientLogic;
import rightagile.badge.stage.envoy.domain.logic.defaultprofile.DefaultProfileAuthorizationFlowLogic;
import rightagile.badge.stage.envoy.domain.logic.defaultprofile.DefaultProfileDramaAssignmentLogic;
import rightagile.badge.stage.envoy.domain.logic.defaultprofile.DefaultProfileDramaRoleLogic;
import rightagile.badge.stage.envoy.domain.spec.AuthorizationFlowService;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.spec.StageClient;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;
import rightagile.badge.stage.envoy.domain.store.lifecycle.EnvoyStoreLycler;
import rightagile.badge.stage.envoy.domain.store.lifecycle.memory.EnvoyMemoryStoreLycler;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;

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
/*    */
/*    */
/*    */
/*    */
/*    */ public class EnvoyServiceSpringLycler
        /*    */ implements EnvoyServiceLycler
        /*    */ {
    /*    */   private final DramaRoleService dramaRoleService;
    /*    */   private final DramaAssignmentService dramaAssignmentService;
    /*    */   private final AuthorizationFlowService authorizationFlowService;
    /*    */   private final StageClient stageClient;

    /*    */
    /*    */
    public EnvoyServiceSpringLycler(EnvoyProxyLycler proxyLycler, String activeProfile) {
        /* 31 */
        if (activeProfile.equals("default")) {
            /* 32 */
            this.dramaRoleService = (DramaRoleService) new DefaultProfileDramaRoleLogic();
            /* 33 */
            this.dramaAssignmentService = (DramaAssignmentService) new DefaultProfileDramaAssignmentLogic();
            /*    */
            /* 35 */
            this.authorizationFlowService = (AuthorizationFlowService) new DefaultProfileAuthorizationFlowLogic();
            /*    */
        } else {
            /*    */
            /* 38 */
            EnvoyStoreLycler storeLycler = EnvoyMemoryStoreLycler.getInstance();
            /*    */
            /* 40 */
            this.dramaRoleService = (DramaRoleService) new DramaRoleLogic(storeLycler, proxyLycler);
            /* 41 */
            this.dramaAssignmentService = (DramaAssignmentService) new DramaAssignmentLogic(storeLycler, proxyLycler);
            /*    */
            /* 43 */
            this.authorizationFlowService = (AuthorizationFlowService) new AuthorizationFlowLogic(this);
            /*    */
        }
        /* 45 */
        this.stageClient = (StageClient) new StageClientLogic(proxyLycler);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaRoleService requestDramaRoleService() {
        /* 51 */
        return this.dramaRoleService;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAssignmentService requestDramaAssignmentService() {
        /* 57 */
        return this.dramaAssignmentService;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public AuthorizationFlowService requestAuthorizationFlowService() {
        /* 63 */
        return this.authorizationFlowService;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public StageClient requestStageClient() {
        /* 69 */
        return this.stageClient;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/service/lifecycle/EnvoyServiceSpringLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */