/*    */
package rightagile.badge.stage.envoy.domain.logic;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.stage.client.EnvoyStageClient;
import rightagile.badge.stage.envoy.context.DramaContext;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.store.MappedDramaRoleStore;
import rightagile.badge.stage.envoy.domain.store.lifecycle.EnvoyStoreLycler;
import rightagile.badge.stage.envoy.model.MappedDramaRole;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
/*    */ public class DramaRoleLogic implements DramaRoleService {
    /* 18 */   private static final Logger log = LoggerFactory.getLogger(DramaRoleLogic.class);
    /*    */
    /*    */   private final MappedDramaRoleStore mappedDramaRoleStore;
    /*    */
    /*    */   private final EnvoyStageClient envoyStageClient;

    /*    */
    /*    */
    /*    */
    public DramaRoleLogic(EnvoyStoreLycler storeLycler, EnvoyProxyLycler proxyLycler) {
        /* 26 */
        this.mappedDramaRoleStore = storeLycler.requestDramaRoleMapStore();
        /* 27 */
        this.envoyStageClient = proxyLycler.requestEnvoyStageClient();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public List<String> findDramaRoleKeys(String cineroomId, List<String> cineroomRoles) {
        /* 33 */
        MappedDramaRole mappedDramaRole = findMappedDramaRole(cineroomId);
        /*    */
        /* 35 */
        Set<String> mappedDramaRoleKeys = new HashSet<>();
        /* 36 */
        for (String townerRole : cineroomRoles) {
            /* 37 */
            mappedDramaRoleKeys.addAll(mappedDramaRole.getDramaRoles(townerRole));
            /*    */
        }
        /*    */
        /* 40 */
        return new ArrayList<>(mappedDramaRoleKeys);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void registerDramaRoleMap(String cineroomId, DramaRoleMap dramaRoleMap) {
        /* 46 */
        log.debug("\ncineroomId {} dramaRoleMap {}", cineroomId, dramaRoleMap);
        /* 47 */
        MappedDramaRole mappedDramaRole = this.mappedDramaRoleStore.retrieve(cineroomId);
        /* 48 */
        if (mappedDramaRole != null) {
            /* 49 */
            this.mappedDramaRoleStore.delete(cineroomId);
            /*    */
        }
        /* 51 */
        mappedDramaRole = new MappedDramaRole(cineroomId, dramaRoleMap);
        /* 52 */
        this.mappedDramaRoleStore.create(mappedDramaRole);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private MappedDramaRole findMappedDramaRole(String cineroomId) {
        /* 57 */
        MappedDramaRole mappedDramaRole = this.mappedDramaRoleStore.retrieve(cineroomId);
        /* 58 */
        if (mappedDramaRole != null) {
            /* 59 */
            return mappedDramaRole;
            /*    */
        }
        /*    */
        /* 62 */
        DramaRoleMap dramaRoleMap = this.envoyStageClient.findDramaRoleMap(cineroomId,
                /* 63 */         DramaContext.getInstance().getDramaId());
        /* 64 */
        log.debug("DramaRoleMap : {}", dramaRoleMap);
        /* 65 */
        mappedDramaRole = new MappedDramaRole(cineroomId, dramaRoleMap);
        /* 66 */
        this.mappedDramaRoleStore.create(mappedDramaRole);
        /*    */
        /* 68 */
        return mappedDramaRole;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/logic/DramaRoleLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */