package customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason on 4/10/17.
 */
@Configuration
public class SchedulerConfig {

    @Bean(name="scheduler")
    public SchedulerBo suchedulerBo(){

        return new SchedulerBo();

    }

}