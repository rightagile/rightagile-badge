/*    */
package rightagile.badge.stage.envoy.domain.store.memory;
/*    */
/*    */


import rightagile.badge.stage.envoy.domain.store.AssignedSubscriptionKeysStore;

import java.util.*;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class AssignedSubscriptionKeysMemoryStore
        /*    */ implements AssignedSubscriptionKeysStore
        /*    */ {
    /* 14 */   private final Map<String, List<String>> map = new HashMap<>();
    /* 15 */   private final Set<String> cachedMapKeys = new HashSet<>();

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public List<String> find(String cineroomId) {
        /* 21 */
        return this.map.get(cineroomId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public boolean isCached(String cineroomId) {
        /* 27 */
        return this.cachedMapKeys.contains(cineroomId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void cache(String cineroomId, List<String> assignedSubscriptionKeys) {
        /* 33 */
        this.map.put(cineroomId, assignedSubscriptionKeys);
        /* 34 */
        this.cachedMapKeys.add(cineroomId);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/memory/AssignedSubscriptionKeysMemoryStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */