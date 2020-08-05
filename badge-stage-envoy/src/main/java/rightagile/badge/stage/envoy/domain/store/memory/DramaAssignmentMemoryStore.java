/*    */
package rightagile.badge.stage.envoy.domain.store.memory;
/*    */
/*    */


import rightagile.badge.stage.envoy.domain.store.DramaAssignmentStore;
import rightagile.badge.stage.envoy.model.DramaAssignment;

import java.util.HashMap;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class DramaAssignmentMemoryStore
        /*    */ implements DramaAssignmentStore
        /*    */ {
    /* 15 */   private final Map<String, DramaAssignment> map = new HashMap<>();

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void create(DramaAssignment dramaAssignment) {
        /* 21 */
        this.map.put(dramaAssignment.getCineroomId(), dramaAssignment);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAssignment retrieve(String cineroomId) {
        /* 27 */
        return this.map.get(cineroomId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void update(DramaAssignment dramaAssignment) {
        /* 33 */
        this.map.remove(dramaAssignment.getCineroomId());
        /* 34 */
        this.map.put(dramaAssignment.getCineroomId(), dramaAssignment);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void delete(String cineroomId) {
        /* 40 */
        this.map.remove(cineroomId);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/memory/DramaAssignmentMemoryStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */