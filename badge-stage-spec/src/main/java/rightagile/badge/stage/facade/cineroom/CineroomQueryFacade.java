package rightagile.badge.stage.facade.cineroom;


import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.stage.rom.cineroom.StageDramaAssignment;

public interface CineroomQueryFacade {
  StageDramaAssignment findDramaAssignment(String paramString1, String paramString2);
  
  DramaRoleMap findDramaRoleMap(String paramString1, String paramString2);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-spec-0.5.0-SNAPSHOT.jar!/io/naraplatform/stage/facade/cineroom/CineroomQueryFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */