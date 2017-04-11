package customer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Jason on 4/10/17.
 */

@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class AppConfig {

}
