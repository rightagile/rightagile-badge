/*    */
package rightagile.badge.stage.envoy.model;
/*    */
/*    */


import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

/*    */
/*    */
/*    */ public class DramaAssignment implements JsonSerializable {
    /*    */   private String cineroomId;
    /*    */   private String cineroomUsid;

    /*    */
    /*    */
    public void setCineroomId(String cineroomId) {
        /* 11 */
        this.cineroomId = cineroomId;
    }

    public void setCineroomUsid(String cineroomUsid) {
        this.cineroomUsid = cineroomUsid;
    }

    public void setAssigend(boolean assigend) {
        this.assigend = assigend;
    }

    public void setDramaEdition(String dramaEdition) {
        this.dramaEdition = dramaEdition;
    }

    public DramaAssignment(String cineroomId, String cineroomUsid, boolean assigend, String dramaEdition) {
        /* 12 */
        this.cineroomId = cineroomId;
        this.cineroomUsid = cineroomUsid;
        this.assigend = assigend;
        this.dramaEdition = dramaEdition;
        /*    */
    }

    /*    */
    /*    */
    public String getCineroomId() {
        /* 16 */
        return this.cineroomId;
        /* 17 */
    }

    public String getCineroomUsid() {
        return this.cineroomUsid;
    }

    /* 18 */   private boolean assigend = false;

    public boolean isAssigend() {
        return this.assigend;
    }

    private String dramaEdition;

    public String getDramaEdition() {
        /* 19 */
        return this.dramaEdition;
        /*    */
    }

    /*    */
    /*    */
    public DramaAssignment(String cineroomId) {
        /* 23 */
        this.cineroomId = cineroomId;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public String toString() {
        /* 28 */
        return toJson();
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public DramaAssignment fromJson(String json) {
        /* 33 */
        return (DramaAssignment) JsonUtil.fromJson(json, DramaAssignment.class);
        /*    */
    }

    /*    */
    /*    */
    public DramaAssignment() {
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/model/DramaAssignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */