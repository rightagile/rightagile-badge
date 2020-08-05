/*    */
package rightagile.badge.stage.envoy.model;
/*    */
/*    */

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */
/*    */ public class FeatureAuthRole implements JsonSerializable {
    /*    */   private String featureName;
    /*    */   private List<String> editions;
    /*    */   private List<String> authRoleKeys;
    /*    */   private Map<String, OperationAuthRole> operationAuthRoleMap;

    /*    */
    /* 14 */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public void setEditions(List<String> editions) {
        this.editions = editions;
    }

    public void setAuthRoleKeys(List<String> authRoleKeys) {
        this.authRoleKeys = authRoleKeys;
    }

    public void setOperationAuthRoleMap(Map<String, OperationAuthRole> operationAuthRoleMap) {
        this.operationAuthRoleMap = operationAuthRoleMap;
    }

    /*    */
    /*    */
    /* 17 */
    public String getFeatureName() {
        return this.featureName;
    }

    /* 18 */
    public List<String> getEditions() {
        return this.editions;
    }

    /* 19 */
    public List<String> getAuthRoleKeys() {
        return this.authRoleKeys;
    }

    public Map<String, OperationAuthRole> getOperationAuthRoleMap() {
        /* 20 */
        return this.operationAuthRoleMap;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public FeatureAuthRole(String featureName, List<String> editions, List<String> authRoleKeys) {
        /* 26 */
        this.featureName = featureName;
        /* 27 */
        this.editions = editions;
        /* 28 */
        this.authRoleKeys = authRoleKeys;
        /* 29 */
        this.operationAuthRoleMap = new LinkedHashMap<>();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public String toString() {
        /* 34 */
        return toJson();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public boolean isAuthorizedRole(String roleKey) {
        /* 39 */
        return false;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static FeatureAuthRole fromJson(String json) {
        /* 44 */
        return (FeatureAuthRole) JsonUtil.fromJson(json, FeatureAuthRole.class);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static FeatureAuthRole sample() {
        /* 49 */
        String featureName = "talk room";
        /* 50 */
        List<String> editions = Arrays.asList("Standard", "Premium");
        /* 51 */
        List<String> authRoleKeys = Arrays.asList("User", "Admin");
        /*    */
        /* 53 */
        return new FeatureAuthRole(featureName, editions, authRoleKeys);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public static void main(String[] args) {
        /* 62 */
        System.out.println(sample());
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/model/FeatureAuthRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */