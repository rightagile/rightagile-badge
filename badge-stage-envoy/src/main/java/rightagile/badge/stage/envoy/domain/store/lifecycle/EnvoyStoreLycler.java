package rightagile.badge.stage.envoy.domain.store.lifecycle;


import rightagile.badge.stage.envoy.domain.store.AssignedSubscriptionKeysStore;
import rightagile.badge.stage.envoy.domain.store.DramaAssignmentStore;
import rightagile.badge.stage.envoy.domain.store.MappedDramaRoleStore;

public interface EnvoyStoreLycler {
    MappedDramaRoleStore requestDramaRoleMapStore();

    DramaAssignmentStore requestDramaAssignmentStore();

    AssignedSubscriptionKeysStore requestAssignedSubscriptionKeysStore();
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/lifecycle/EnvoyStoreLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */