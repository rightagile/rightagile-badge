package rightagile.badge.stage.envoy.domain.spec.lifecycle;


import rightagile.badge.stage.envoy.domain.spec.AuthorizationFlowService;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.spec.StageClient;

public interface EnvoyServiceLycler {
    DramaRoleService requestDramaRoleService();

    DramaAssignmentService requestDramaAssignmentService();

    AuthorizationFlowService requestAuthorizationFlowService();

    StageClient requestStageClient();
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/spec/lifecycle/EnvoyServiceLycler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */