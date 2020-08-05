/*    */
package rightagile.badge.stage.envoy.model;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.*;

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
/*    */ public class MappedDramaRole implements JsonSerializable {
    /* 14 */   private static final Logger log = LoggerFactory.getLogger(MappedDramaRole.class);
    /*    */   private String cineroomId;
    private Map<String, Set<String>> cineroomDramaRoleMap;

    /* 16 */
    public void setCineroomId(String cineroomId) {
        this.cineroomId = cineroomId;
    }

    public void setCineroomDramaRoleMap(Map<String, Set<String>> cineroomDramaRoleMap) {
        this.cineroomDramaRoleMap = cineroomDramaRoleMap;
    }

    public MappedDramaRole(String cineroomId, Map<String, Set<String>> cineroomDramaRoleMap) {
        /* 17 */
        this.cineroomId = cineroomId;
        this.cineroomDramaRoleMap = cineroomDramaRoleMap;
        /*    */
    }

    /*    */
    /*    */
    public MappedDramaRole() {
    }

    /* 21 */
    public String getCineroomId() {
        return this.cineroomId;
    }

    public Map<String, Set<String>> getCineroomDramaRoleMap() {
        /* 22 */
        return this.cineroomDramaRoleMap;
        /*    */
    }

    /*    */
    /*    */
    public MappedDramaRole(String cineroomId, DramaRoleMap dramaRoleMap) {
        /* 26 */
        this.cineroomId = cineroomId;
        /* 27 */
        this.cineroomDramaRoleMap = new HashMap<>();
        /* 28 */
        List<String> dramaRoleKeys = dramaRoleMap.getDramaRoleKeys();
        /*    */
        /* 30 */
        for (String cineroomRole : dramaRoleMap.getCineroomRoleKeys()) {
            /* 31 */
            log.debug("# cineroomRole ({})", cineroomRole);
            /* 32 */
            Set<String> dramaRoles = new HashSet<>();
            /* 33 */
            for (String dramaRole : dramaRoleKeys) {
                /* 34 */
                if (dramaRoleMap.isMarked(cineroomRole, dramaRole)) {
                    /* 35 */
                    dramaRoles.add(dramaRole);
                    /* 36 */
                    log.debug("    - {}", dramaRole);
                    /*    */
                }
                /*    */
            }
            /* 39 */
            this.cineroomDramaRoleMap.put(cineroomRole, dramaRoles);
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Set<String> getDramaRoles(String cineroomRole) {
        /* 45 */
        return this.cineroomDramaRoleMap.get(cineroomRole);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public String toString() {
        /* 50 */
        return toJson();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public MappedDramaRole fromJson(String json) {
        /* 55 */
        return (MappedDramaRole) JsonUtil.fromJson(json, MappedDramaRole.class);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/model/MappedDramaRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */