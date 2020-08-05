package rightagile.badge.stage.envoy.domain.store;


import rightagile.badge.stage.envoy.model.DramaAssignment;

public interface DramaAssignmentStore {
    void create(DramaAssignment paramDramaAssignment);

    DramaAssignment retrieve(String paramString);

    void update(DramaAssignment paramDramaAssignment);

    void delete(String paramString);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/DramaAssignmentStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */