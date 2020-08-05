/*    */
package rightagile.badge.stage.envoy.domain.logic;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rightagile.badge.stage.client.EnvoyStageClient;
import rightagile.badge.stage.envoy.context.DramaContext;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.store.AssignedSubscriptionKeysStore;
import rightagile.badge.stage.envoy.domain.store.DramaAssignmentStore;
import rightagile.badge.stage.envoy.domain.store.lifecycle.EnvoyStoreLycler;
import rightagile.badge.stage.envoy.model.DramaAssignment;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;
import rightagile.badge.stage.rom.cineroom.StageDramaAssignment;

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
/*    */ public class DramaAssignmentLogic implements DramaAssignmentService {
    /* 14 */   private static final Logger log = LoggerFactory.getLogger(DramaAssignmentLogic.class);
    /*    */
    /*    */   private final DramaAssignmentStore dramaAssignmentStore;
    /*    */
    /*    */   private final AssignedSubscriptionKeysStore assignedSubscriptionKeysStore;
    /*    */
    /*    */   private final EnvoyStageClient envoyStageClient;

    /*    */
    /*    */
    public DramaAssignmentLogic(EnvoyStoreLycler storeLycler, EnvoyProxyLycler proxyLycler) {
        /* 23 */
        this.dramaAssignmentStore = storeLycler.requestDramaAssignmentStore();
        /* 24 */
        this.assignedSubscriptionKeysStore = storeLycler.requestAssignedSubscriptionKeysStore();
        /* 25 */
        this.envoyStageClient = proxyLycler.requestEnvoyStageClient();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public boolean hasValidAssignment(String cineroomId, String[] editions) {
        /* 31 */
        DramaAssignment dramaAssignment = findDramaAssignment(cineroomId);
        /*    */
        /* 33 */
        if (!dramaAssignment.isAssigend()) {
            /* 34 */
            return false;
            /*    */
        }
        /*    */
        /* 37 */
        for (String edition : editions) {
            /* 38 */
            if (edition.equals(dramaAssignment.getDramaEdition())) {
                /* 39 */
                return true;
                /*    */
            }
            /*    */
        }
        /*    */
        /* 43 */
        return false;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAssignment findDramaAssignment(String cineroomId) {
        /* 49 */
        DramaAssignment dramaAssignment = this.dramaAssignmentStore.retrieve(cineroomId);
        /* 50 */
        if (dramaAssignment != null) {
            /* 51 */
            return dramaAssignment;
            /*    */
        }
        /*    */
        /* 54 */
        String dramaId = DramaContext.getInstance().getDramaId();
        /*    */
        /* 56 */
        dramaAssignment = new DramaAssignment();
        /* 57 */
        dramaAssignment.setCineroomId(cineroomId);
        /* 58 */
        StageDramaAssignment stageDramaAssignment = this.envoyStageClient.findDramaAssignment(cineroomId, dramaId);
        /* 59 */
        log.debug("\nstageDramaAssignment {}", stageDramaAssignment);
        /* 60 */
        if (stageDramaAssignment != null) {
            /* 61 */
            dramaAssignment.setAssigend(true);
            /* 62 */
            dramaAssignment.setCineroomUsid(stageDramaAssignment.getCineroomUsid());
            /* 63 */
            dramaAssignment.setDramaEdition(stageDramaAssignment.getDramaEdition());
            /*    */
        }
        /* 65 */
        this.dramaAssignmentStore.create(dramaAssignment);
        /*    */
        /* 67 */
        return dramaAssignment;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void registerAssignment(String cineroomId, String cineroomUsid, String dramaEdition) {
        /* 73 */
        log.debug("\nregisterAssignment cineroomId {}, cineroomUsid {}, dramaEdition {}", cineroomId, cineroomUsid, dramaEdition);
        /* 74 */
        DramaAssignment dramaAssignment = this.dramaAssignmentStore.retrieve(cineroomId);
        /* 75 */
        if (dramaAssignment != null) {
            /* 76 */
            dramaAssignment.setAssigend(true);
            /* 77 */
            dramaAssignment.setDramaEdition(dramaEdition);
            /* 78 */
            this.dramaAssignmentStore.update(dramaAssignment);
            /*    */
        } else {
            /*    */
            /* 81 */
            dramaAssignment = new DramaAssignment(cineroomId, cineroomUsid, true, dramaEdition);
            /* 82 */
            this.dramaAssignmentStore.create(dramaAssignment);
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void removeAssignment(String cineroomId) {
        /* 89 */
        log.debug("\nremoveAssignment cineroomId {}", cineroomId);
        /* 90 */
        DramaAssignment dramaAssignment = this.dramaAssignmentStore.retrieve(cineroomId);
        /* 91 */
        if (dramaAssignment != null) {
            /* 92 */
            dramaAssignment.setAssigend(false);
            /* 93 */
            this.dramaAssignmentStore.update(dramaAssignment);
            /*    */
        } else {
            /*    */
            /* 96 */
            dramaAssignment = new DramaAssignment(cineroomId);
            /* 97 */
            this.dramaAssignmentStore.create(dramaAssignment);
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/DramaAssignmentLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */