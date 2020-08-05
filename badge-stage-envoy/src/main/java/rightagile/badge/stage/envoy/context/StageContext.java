/*    */
package rightagile.badge.stage.envoy.context;
/*    */
/*    */

import org.springframework.context.ApplicationContext;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.spec.StageClient;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;

import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class StageContext
        /*    */ {
    /* 13 */   private static final ThreadLocal<DramaRequest> threadLocal = new ThreadLocal<>();
    /*    */
    /*    */   private StageClient stageClient;
    /*    */
    /*    */   private final ApplicationContext applicationContext;
    /*    */   private final DramaRoleService dramaRoleService;
    /*    */   private final DramaAssignmentService dramaAssignmentService;

    /*    */
    /*    */
    public StageContext(ApplicationContext applicationContext) {
        /* 22 */
        this.applicationContext = applicationContext;
        /* 23 */
        EnvoyServiceLycler envoyServiceLycler = (EnvoyServiceLycler) applicationContext.getBean(EnvoyServiceLycler.class);
        /* 24 */
        this.dramaRoleService = envoyServiceLycler.requestDramaRoleService();
        /* 25 */
        this.dramaAssignmentService = envoyServiceLycler.requestDramaAssignmentService();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static void setCurrentRequest(DramaRequest dramaRequest) {
        /* 30 */
        threadLocal.set(dramaRequest);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static void clearCurrentRequest() {
        /* 35 */
        threadLocal.remove();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static DramaRequest getCurrentRequest() {
        /* 40 */
        return threadLocal.get();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public List<String> getCurrentDramaRoles() {
        /* 45 */
        DramaRequest currentRequest = getCurrentRequest();
        /* 46 */
        return this.dramaRoleService.findDramaRoleKeys(currentRequest
/* 47 */.getCineroomId(), currentRequest.getCineroomRoles());
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public String getCurrentCineroomUsid() {
        /* 52 */
        String cineroomId = getCurrentRequest().getCineroomId();
        /* 53 */
        return this.dramaAssignmentService.findDramaAssignment(cineroomId).getCineroomUsid();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public StageClient getStageClient() {
        /* 61 */
        if (this.stageClient == null) {
            /* 62 */
            this.stageClient = ((EnvoyServiceLycler) this.applicationContext.getBean(EnvoyServiceLycler.class)).requestStageClient();
            /*    */
        }
        /* 64 */
        return this.stageClient;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/context/StageContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */