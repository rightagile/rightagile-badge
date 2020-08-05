/*    */
package rightagile.badge.stage.envoy.model;
/*    */
/*    */

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Arrays;
import java.util.List;

/*    */
/*    */
/*    */
/*    */ public class OperationAuthRole implements JsonSerializable {
    /*    */   private String operationId;
    /*    */   private String operationName;
    /*    */   private List<String> authRoleKeys;

    /*    */
    /* 12 */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setAuthRoleKeys(List<String> authRoleKeys) {
        this.authRoleKeys = authRoleKeys;
    }

    /*    */
    /*    */
    /*    */
    public String getOperationId() {
        /* 16 */
        return this.operationId;
        /* 17 */
    }

    public String getOperationName() {
        return this.operationName;
    }

    public List<String> getAuthRoleKeys() {
        /* 18 */
        return this.authRoleKeys;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public OperationAuthRole(String operationName, List<String> paramTypes, List<String> authRoleKeys) {
        /* 24 */
        this.operationId = genOperationId(operationName, paramTypes);
        /* 25 */
        this.operationName = operationName;
        /*    */
        /* 27 */
        this.authRoleKeys = authRoleKeys;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public String toString() {
        /* 33 */
        return toJson();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static String genOperationId(String operationName, List<String> paramTypes) {
        /* 38 */
        if (paramTypes.size() == 0) {
            /* 39 */
            return operationName + ":void";
            /*    */
        }
        /*    */
        /* 42 */
        StringBuilder builder = new StringBuilder();
        /* 43 */
        builder.append(operationName);
        /*    */
        /* 45 */
        for (String paramType : paramTypes) {
            /* 46 */
            builder.append(":").append(paramType);
            /*    */
        }
        /*    */
        /* 49 */
        return builder.toString();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static OperationAuthRole fromJson(String json) {
        /* 54 */
        return (OperationAuthRole) JsonUtil.fromJson(json, OperationAuthRole.class);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static OperationAuthRole sample() {
        /* 59 */
        String name = "registerCustomer";
        /* 60 */
        List<String> paramTypes = Arrays.asList("CustomerCdo");
        /* 61 */
        List<String> authorizedRoles = Arrays.asList("Admin");
        /*    */
        /* 63 */
        return new OperationAuthRole(name, paramTypes, authorizedRoles);
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
        /* 72 */
        System.out.println(sample());
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/model/OperationAuthRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */