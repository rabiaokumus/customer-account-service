package customer.account.config;

import customer.account.application.inteceptors.CustomerIdInterceptor;
import customer.account.domain.facades.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CustomerFacade customerFacade;

    @Autowired
    public WebConfig(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomerIdInterceptor(customerFacade))
                .addPathPatterns("/customer/{id}", "/account/customer/{customerId}");
    }
}
