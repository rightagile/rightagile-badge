package rightagile.badge.stage.envoy.domain.spec;


import rightagile.badge.stage.envoy.model.DramaAssignment;

public interface DramaAssignmentService {
    boolean hasValidAssignment(String paramString, String[] paramArrayOfString);

    DramaAssignment findDramaAssignment(String paramString);

    void registerAssignment(String paramString1, String paramString2, String paramString3);

    void removeAssignment(String paramString);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/spec/DramaAssignmentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */