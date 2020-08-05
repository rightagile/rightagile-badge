/*    */
package rightagile.badge.stage.envoy.spring;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import rightagile.badge.accent.shared.domain.nara.Workspace;
import rightagile.badge.accent.shared.domain.nara.WorkspaceList;
import rightagile.badge.accent.shared.domain.patron.AudienceKey;
import rightagile.badge.accent.shared.util.exception.NaraException;
import rightagile.badge.accent.shared.util.json.JsonUtil;
import rightagile.badge.stage.envoy.context.DramaRequest;

import java.util.List;
import java.util.Map;

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
/*    */
/*    */
@Component
/*    */ public class JwtUtil {
    /* 20 */   private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);
    /*    */
    /*    */
    /*    */   private final TokenStore tokenStore;

    /*    */
    /*    */
    /*    */
    /*    */
    public JwtUtil(TokenStore tokenStore) {
        /* 28 */
        this.tokenStore = tokenStore;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public DramaRequest createDramaRequest(String audienceId) {
        /* 33 */
        Map<String, Object> additionalInformation = getAdditionalInformationFromJwtToken();
        /* 34 */
        WorkspaceList workspaceList = WorkspaceList.fromJson(JsonUtil.toJson(additionalInformation.get("workspaces")));
        /*    */
        /* 36 */
        String cineroomId = AudienceKey.fromKeyString(audienceId).genCineroomKeyString();
        /*    */
        /* 38 */
        List<String> cineroomRoleKeys = getCineroomRoleKeys(cineroomId, workspaceList);
        /* 39 */
        String loginId = (String) additionalInformation.get("loginId");
        /*    */
        /* 41 */
        Object informationMapObject = additionalInformation.get("additionalInformation");
        /* 42 */
        Map<String, String> informationMap = null;
        /* 43 */
        if (informationMapObject != null) {
            /* 44 */
            informationMap = (Map<String, String>) informationMapObject;
            /*    */
        }
        /* 46 */
        DramaRequest dramaRequest = new DramaRequest(audienceId, cineroomId, cineroomRoleKeys, workspaceList, loginId, informationMap);
        /*    */
        /* 48 */
        return dramaRequest;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public WorkspaceList extractWorkspaceListFromJwt() {
        /* 53 */
        return getWorkspaceList();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public List<String> extractCineroomRoleKeysFromJwt(String audienceId) {
        /* 59 */
        String cineroomKey = AudienceKey.fromKeyString(audienceId).genCineroomKeyString();
        /*    */
        /* 61 */
        WorkspaceList workspaces = getWorkspaceList();
        /*    */
        /* 63 */
        return getCineroomRoleKeys(cineroomKey, workspaces);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private List<String> getCineroomRoleKeys(String cineroomKey, WorkspaceList workspaces) {
        /* 68 */
        log.debug("extracted cineroomKey {}", cineroomKey);
        /*    */
        /* 70 */
        for (Workspace cineroomWorkspace : workspaces.getCineroomWorkspaces()) {
            /* 71 */
            log.debug("cineroomWorkspace, cineroom id : '{}'", cineroomWorkspace.getId());
            /* 72 */
            if (cineroomWorkspace.getId().equals(cineroomKey)) {
                /* 73 */
                return cineroomWorkspace.getRoles();
                /*    */
            }
            /*    */
        }
        /*    */
        /* 77 */
        throw new NaraException("request is not authorized : Can't find CineroomRoleKeys");
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private WorkspaceList getWorkspaceList() {
        /* 82 */
        Map<String, Object> additionalInformation = getAdditionalInformationFromJwtToken();
        /* 83 */
        return WorkspaceList.fromJson(JsonUtil.toJson(additionalInformation.get("workspaces")));
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private Map<String, Object> getAdditionalInformationFromJwtToken() {
        /* 88 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        /* 89 */
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        /* 90 */
        OAuth2AccessToken accessToken = this.tokenStore.readAccessToken(details.getTokenValue());
        /* 91 */
        return accessToken.getAdditionalInformation();
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/JwtUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */