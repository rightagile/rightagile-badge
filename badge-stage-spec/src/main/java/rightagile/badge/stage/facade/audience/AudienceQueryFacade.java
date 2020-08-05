package rightagile.badge.stage.facade.audience;

import rightagile.badge.accent.shared.domain.cineroom.AudienceSdo;
import rightagile.badge.accent.shared.domain.cineroom.CineroomBaseRequest;
import rightagile.badge.accent.shared.domain.cineroom.RoleBaseRequest;

import java.util.List;

public interface AudienceQueryFacade {
  List<AudienceSdo> findAudiences(CineroomBaseRequest paramCineroomBaseRequest);
  
  int countAudiences(String paramString);
  
  List<AudienceSdo> findAudiencesByRoleKey(RoleBaseRequest paramRoleBaseRequest);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-spec-0.5.0-SNAPSHOT.jar!/io/naraplatform/stage/facade/audience/AudienceQueryFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */