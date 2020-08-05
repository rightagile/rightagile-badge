package rightagile.badge.stage.envoy.domain.spec;

import rightagile.badge.accent.shared.domain.cineroom.AudienceSdo;
import rightagile.badge.accent.shared.domain.cineroom.CineroomBaseRequest;

import java.util.List;

public interface StageClient {
    int countAudiences(String paramString);

    List<AudienceSdo> findAudiences(CineroomBaseRequest paramCineroomBaseRequest);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/spec/StageClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */