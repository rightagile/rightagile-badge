package rightagile.badge.stage.envoy.domain.store;

import java.util.List;

public interface AssignedSubscriptionKeysStore {
    List<String> find(String paramString);

    boolean isCached(String paramString);

    void cache(String paramString, List<String> paramList);
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/domain/store/AssignedSubscriptionKeysStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */