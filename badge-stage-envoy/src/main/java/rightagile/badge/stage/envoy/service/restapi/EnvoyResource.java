/*    */
package rightagile.badge.stage.envoy.service.restapi;
/*    */

import org.springframework.web.bind.annotation.*;
import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.stage.envoy.context.DramaContext;
import rightagile.badge.stage.envoy.context.DramaRequest;
import rightagile.badge.stage.envoy.domain.spec.DramaAssignmentService;
import rightagile.badge.stage.envoy.domain.spec.DramaRoleService;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;

import java.util.List;

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
@RestController
/*    */
@RequestMapping({"envoy"})
/*    */ public class EnvoyResource {
    /*    */   private final DramaRoleService dramaRoleService;

    /*    */
    /*    */
    public EnvoyResource(EnvoyServiceLycler serviceLycler) {
        /* 22 */
        this.dramaRoleService = serviceLycler.requestDramaRoleService();
        /* 23 */
        this.dramaAssignmentService = serviceLycler.requestDramaAssignmentService();
        /*    */
    }

    /*    */   private final DramaAssignmentService dramaAssignmentService;

    /*    */
    /*    */
    @GetMapping({"healthCheck"})
    /*    */ public String healthCheck() {
        /* 29 */
        return "OK";
        /*    */
    }

    /*    */
    /*    */
    /*    */
    @GetMapping({"dramaRoles"})
    /*    */ public List<String> findDramaRoles() {
        /* 35 */
        DramaRequest dramaRequest = DramaContext.getCurrentRequest();
        /* 36 */
        return this.dramaRoleService.findDramaRoleKeys(dramaRequest.getCineroomId(), dramaRequest.getCineroomRoles());
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    @PostMapping({"assignedCineroom"})
    /*    */ public void registerAssignedCineroom(@RequestParam String cineroomId, @RequestParam String cineroomUsid, @RequestParam String dramaEdition) {
        /* 44 */
        this.dramaAssignmentService.registerAssignment(cineroomId, cineroomUsid, dramaEdition);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    @DeleteMapping({"assignedCineroom"})
    /*    */ public void removeAssignedConeroom(@RequestParam String cineroomId) {
        /* 50 */
        this.dramaAssignmentService.removeAssignment(cineroomId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    @PostMapping({"dramaRoleMap"})
    /*    */ public void registerDramaRoleMap(@RequestParam String cineroomId, @RequestBody DramaRoleMap dramaRoleMap) {
        /* 57 */
        this.dramaRoleService.registerDramaRoleMap(cineroomId, dramaRoleMap);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/service/restapi/EnvoyResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */