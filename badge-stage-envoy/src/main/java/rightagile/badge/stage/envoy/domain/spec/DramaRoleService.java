package rightagile.badge.stage.envoy.domain.spec;


import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;

import java.util.List;

public interface DramaRoleService {
    List<String> findDramaRoleKeys(String paramString, List<String> paramList);

    void registerDramaRoleMap(String paramString, DramaRoleMap paramDramaRoleMap);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/spec/DramaRoleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */