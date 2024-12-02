package customer.account.config;

import customer.account.application.inteceptors.AccountIdInterceptor;
import customer.account.application.inteceptors.CustomerIdInterceptor;
import customer.account.domain.facades.AccountFacade;
import customer.account.domain.facades.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CustomerFacade customerFacade;

    private final AccountFacade accountFacade;

    @Autowired
    public WebConfig(CustomerFacade customerFacade, AccountFacade accountFacade) {
        this.customerFacade = customerFacade;
        this.accountFacade = accountFacade;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomerIdInterceptor(customerFacade))
                .addPathPatterns("/customer/{id}", "/account/customer/{customerId}");
        registry.addInterceptor(new AccountIdInterceptor(accountFacade))
                .addPathPatterns("/transaction/account/{accountId}");
    }
}
