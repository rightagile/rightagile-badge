package rightagile.badge.stage.envoy.spring.headerconsumer;

import org.springframework.http.HttpHeaders;

import java.util.function.Consumer;

public interface EnvoyHeaderConsumerProvider {
    Consumer<HttpHeaders> getConsumer();
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/headerconsumer/EnvoyHeaderConsumerProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */