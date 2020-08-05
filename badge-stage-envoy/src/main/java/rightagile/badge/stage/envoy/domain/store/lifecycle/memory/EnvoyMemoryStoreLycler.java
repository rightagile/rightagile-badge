/*    */
package rightagile.badge.stage.envoy.domain.store.lifecycle.memory;
/*    */
/*    */

import rightagile.badge.stage.envoy.domain.store.AssignedSubscriptionKeysStore;
import rightagile.badge.stage.envoy.domain.store.DramaAssignmentStore;
import rightagile.badge.stage.envoy.domain.store.MappedDramaRoleStore;
import rightagile.badge.stage.envoy.domain.store.lifecycle.EnvoyStoreLycler;
import rightagile.badge.stage.envoy.domain.store.memory.AssignedSubscriptionKeysMemoryStore;
import rightagile.badge.stage.envoy.domain.store.memory.DramaAssignmentMemoryStore;
import rightagile.badge.stage.envoy.domain.store.memory.MappedDramaRoleMemoryStore;

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
/*    */ public class EnvoyMemoryStoreLycler
        /*    */ implements EnvoyStoreLycler
        /*    */ {
    /* 19 */   private final MappedDramaRoleStore mappedDramaRoleStore = (MappedDramaRoleStore) new MappedDramaRoleMemoryStore();
    /* 20 */   private final DramaAssignmentStore dramaAssignmentStore = (DramaAssignmentStore) new DramaAssignmentMemoryStore();
    /* 21 */   private final AssignedSubscriptionKeysStore assignedSubscriptionKeysStore = (AssignedSubscriptionKeysStore) new AssignedSubscriptionKeysMemoryStore();

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public MappedDramaRoleStore requestDramaRoleMapStore() {
        /* 27 */
        return this.mappedDramaRoleStore;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAssignmentStore requestDramaAssignmentStore() {
        /* 33 */
        return this.dramaAssignmentStore;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public AssignedSubscriptionKeysStore requestAssignedSubscriptionKeysStore() {
        /* 39 */
        return this.assignedSubscriptionKeysStore;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static EnvoyStoreLycler getInstance() {
        /* 44 */
        return LazyHolder.INSTANCE;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static EnvoyStoreLycler newInstance() {
        /* 49 */
        return new EnvoyMemoryStoreLycler();
        /*    */
    }

    /*    */
    /*    */   private static class LazyHolder
            /*    */ {
        /* 54 */     private static final EnvoyStoreLycler INSTANCE = new EnvoyMemoryStoreLycler();
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/lifecycle/memory/EnvoyMemoryStoreLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */