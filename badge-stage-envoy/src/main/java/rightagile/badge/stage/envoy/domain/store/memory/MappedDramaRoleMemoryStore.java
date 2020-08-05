/*    */
package rightagile.badge.stage.envoy.domain.store.memory;
/*    */
/*    */


import rightagile.badge.stage.envoy.domain.store.MappedDramaRoleStore;
import rightagile.badge.stage.envoy.model.MappedDramaRole;

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
/*    */ public class MappedDramaRoleMemoryStore
        /*    */ implements MappedDramaRoleStore
        /*    */ {
    /* 15 */   private final Map<String, MappedDramaRole> map = new HashMap<>();

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void create(MappedDramaRole mappedDramaRole) {
        /* 21 */
        this.map.put(mappedDramaRole.getCineroomId(), mappedDramaRole);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public MappedDramaRole retrieve(String cineroomId) {
        /* 27 */
        return this.map.get(cineroomId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void update(MappedDramaRole mappedDramaRole) {
        /* 33 */
        this.map.remove(mappedDramaRole.getCineroomId());
        /* 34 */
        this.map.put(mappedDramaRole.getCineroomId(), mappedDramaRole);
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


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/memory/MappedDramaRoleMemoryStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */