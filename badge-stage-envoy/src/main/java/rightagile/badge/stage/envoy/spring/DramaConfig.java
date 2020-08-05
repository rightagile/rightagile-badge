package rightagile.badge.stage.envoy.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import rightagile.badge.stage.envoy.util.YamlPropertySourceFactory;

@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = {"classpath:drama.yml"})
public class DramaConfig {
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/DramaConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */