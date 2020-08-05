/*    */
package rightagile.badge.stage.envoy.proxy.lifecycle.local;
/*    */
/*    */


import rightagile.badge.accent.shared.domain.cineroom.AudienceSdo;
import rightagile.badge.accent.shared.domain.cineroom.CineroomBaseRequest;
import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.accent.shared.domain.cineroom.RoleBaseRequest;
import rightagile.badge.stage.client.EnvoyStageClient;
import rightagile.badge.stage.rom.cineroom.StageDramaAssignment;

import java.util.Arrays;
import java.util.List;

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
/*    */ public class EnvoyStageLocalClient
        /*    */ implements EnvoyStageClient
        /*    */ {
    /*    */
    public DramaRoleMap findDramaRoleMap(String cineroomId, String dramaId) {
        /* 19 */
        List<String> dramaRoleKeys = Arrays.asList("sweetie", "heartbreaker");
        /* 20 */
        List<String> cineroomRoleKeys = Arrays.asList("Admin", "User");
        /*    */
        /* 22 */
        DramaRoleMap dramaRoleMap = new DramaRoleMap(null, dramaRoleKeys, cineroomRoleKeys);
        /* 23 */
        dramaRoleMap.mark("Admin", "heartbreaker");
        /* 24 */
        dramaRoleMap.mark("User", "sweetie");
        /*    */
        /* 26 */
        return dramaRoleMap;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public StageDramaAssignment findDramaAssignment(String cineroomId, String dramaId) {
        /* 32 */
        return null;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public int countAudiences(String cineroomId) {
        /* 38 */
        return 0;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public List<AudienceSdo> findAudiences(CineroomBaseRequest cineroomBaseRequest) {
        /* 44 */
        return null;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public List<AudienceSdo> findAudiencesByRoleKey(RoleBaseRequest roleBaseRequest) {
        /* 50 */
        return null;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/proxy/lifecycle/local/EnvoyStageLocalClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */