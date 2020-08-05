/*    */
package rightagile.badge.stage.envoy.model;
/*    */
/*    */


import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class DramaAuthPolicy implements JsonSerializable {
    /*    */   private String dramaId;
    /*    */   private String dramaName;

    /*    */
    /* 14 */
    public void setDramaId(String dramaId) {
        this.dramaId = dramaId;
    }

    private List<String> roleKeys;
    private Map<String, FeatureAuthRole> featureAuthRoleMap;
    private long processingTime;

    public void setDramaName(String dramaName) {
        this.dramaName = dramaName;
    }

    public void setRoleKeys(List<String> roleKeys) {
        this.roleKeys = roleKeys;
    }

    public void setFeatureAuthRoleMap(Map<String, FeatureAuthRole> featureAuthRoleMap) {
        this.featureAuthRoleMap = featureAuthRoleMap;
    }

    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }

    /*    */
    /*    */
    /* 17 */
    public String getDramaId() {
        return this.dramaId;
    }

    public String getDramaName() {
        /* 18 */
        return this.dramaName;
        /*    */
    }

    public List<String> getRoleKeys() {
        /* 20 */
        return this.roleKeys;
        /*    */
    }

    /* 22 */
    public Map<String, FeatureAuthRole> getFeatureAuthRoleMap() {
        return this.featureAuthRoleMap;
    }

    public long getProcessingTime() {
        /* 23 */
        return this.processingTime;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public DramaAuthPolicy(String dramaId, String dramaName, List<String> roleKeys) {
        /* 30 */
        this.dramaId = dramaId;
        /* 31 */
        this.dramaName = dramaName;
        /*    */
        /* 33 */
        this.roleKeys = roleKeys;
        /* 34 */
        this.featureAuthRoleMap = new HashMap<>();
        /* 35 */
        this.processingTime = System.currentTimeMillis();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public DramaAuthPolicy(List<FeatureAuthRole> featureAuthRoles) {
        /* 40 */
        this.featureAuthRoleMap = new HashMap<>();
        /* 41 */
        this.processingTime = System.currentTimeMillis();
        /*    */
        /* 43 */
        for (FeatureAuthRole featureAuthRole : featureAuthRoles) {
            /* 44 */
            this.featureAuthRoleMap.put(featureAuthRole.getFeatureName(), featureAuthRole);
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public OperationAuthRole getOperationAuthRole(String featureName, String operationId) {
        /* 50 */
        return this.featureAuthRoleMap.get(featureName)
/* 51 */.getOperationAuthRoleMap().get(operationId);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public String toString() {
        /* 56 */
        return toJson();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static DramaAuthPolicy fromJson(String json) {
        /* 61 */
        return (DramaAuthPolicy) JsonUtil.fromJson(json, DramaAuthPolicy.class);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public static DramaAuthPolicy sample() {
        /* 67 */
        String dramaId = "003F";
        /* 68 */
        String dramaName = "nara.drama.talk";
        /* 69 */
        List<String> roleKeys = Arrays.asList("User", "Admin");
        /*    */
        /* 71 */
        return new DramaAuthPolicy(dramaId, dramaName, roleKeys);
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
        /* 80 */
        System.out.println(sample());
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/model/DramaAuthPolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */