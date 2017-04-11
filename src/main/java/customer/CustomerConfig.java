package customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason on 4/10/17.
 */

@Configuration
public class CustomerConfig {

    @Bean(name="customer")
    public CustomerBo customerBo(){
        return new CustomerBo();
    }
}
