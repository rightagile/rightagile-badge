/*     */
package rightagile.badge.stage.envoy.context;
/*     */
/*     */

import rightagile.badge.accent.shared.domain.nara.Workspace;
import rightagile.badge.accent.shared.domain.nara.WorkspaceList;
import rightagile.badge.accent.shared.util.json.JsonSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class DramaRequest
        /*     */ implements JsonSerializable
        /*     */ {
    /*     */   private final String audienceId;
    /*     */   private final String cineroomId;
    /*     */   private final List<String> cineroomRoles;
    /*     */   private WorkspaceList workspaceList;
    /*     */   private String loginId;
    /*     */   private Map<String, String> additionalInformation;
    /*     */   private List<String> cineroomIds;
    /*     */   private List<String> audienceIds;

    /*     */
    /*     */
    public DramaRequest(String audienceId, String cineroomId, List<String> cineroomRoles) {
        /*  26 */
        this.audienceId = audienceId;
        /*  27 */
        this.cineroomId = cineroomId;
        /*  28 */
        this.cineroomRoles = cineroomRoles;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public DramaRequest(String audienceId, String cineroomId, List<String> cineroomRoles, WorkspaceList workspaceList, String loginId) {
        /*  33 */
        this(audienceId, cineroomId, cineroomRoles);
        /*  34 */
        this.workspaceList = workspaceList;
        /*  35 */
        this.loginId = loginId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public DramaRequest(String audienceId, String cineroomId, List<String> cineroomRoles, WorkspaceList workspaceList, String loginId, Map<String, String> additionalInformation) {
        /*  40 */
        this(audienceId, cineroomId, cineroomRoles, workspaceList, loginId);
        /*  41 */
        this.additionalInformation = additionalInformation;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Map<String, String> getAdditionalInformation() {
        /*  46 */
        return this.additionalInformation;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public List<String> getCineroomIds() {
        /*  51 */
        if (this.cineroomIds == null) {
            /*  52 */
            this.cineroomIds = new ArrayList<>();
            /*  53 */
            if (this.workspaceList != null) {
                /*  54 */
                for (Workspace cineroomWorkspace : this.workspaceList.getCineroomWorkspaces()) {
                    /*  55 */
                    this.cineroomIds.add(cineroomWorkspace.getId());
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /*  59 */
        return this.cineroomIds;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public List<String> getAudienceIds() {
        /*  64 */
        if (this.audienceIds == null) {
            /*  65 */
            this.audienceIds = new ArrayList<>();
            /*  66 */
            if (this.workspaceList != null) {
                /*  67 */
                for (Workspace cineroomWorkspace : this.workspaceList.getCineroomWorkspaces()) {
                    /*  68 */
                    this.audienceIds.add(cineroomWorkspace.getTenantId());
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /*  72 */
        return this.audienceIds;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getAudienceId() {
        /*  77 */
        return this.audienceId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getCineroomId() {
        /*  82 */
        return this.cineroomId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public List<String> getCineroomRoles() {
        /*  87 */
        return this.cineroomRoles;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public WorkspaceList getWorkspaceList() {
        /*  92 */
        return this.workspaceList;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getLoginId() {
        /*  97 */
        return this.loginId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String toString() {
        /* 103 */
        return toJson();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static DramaRequest sample() {
        /* 108 */
        String audienceId = "r5-r3c@ne1-m5-3c";
        /* 109 */
        String cinerromId = "ne1-m5-3c";
        /* 110 */
        List<String> cineroomRoles = Arrays.asList("User", "Admin");
        /*     */
        /* 112 */
        return new DramaRequest(audienceId, cinerromId, cineroomRoles);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void main(String[] args) {
        /* 117 */
        System.out.println(sample());
        /*     */
    }
    /*     */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/context/DramaRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */