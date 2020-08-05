package rightagile.badge.stage.envoy.domain.store;


import rightagile.badge.stage.envoy.model.MappedDramaRole;

public interface MappedDramaRoleStore {
    void create(MappedDramaRole paramMappedDramaRole);

    MappedDramaRole retrieve(String paramString);

    void update(MappedDramaRole paramMappedDramaRole);

    void delete(String paramString);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/MappedDramaRoleStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */