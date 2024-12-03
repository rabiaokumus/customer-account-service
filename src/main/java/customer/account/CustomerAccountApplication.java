package customer.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages = {"customer.account.domain.facades"})
@EnableJpaRepositories("customer.account.infra.mysql.repository")
@EntityScan(basePackages = "customer.account.infra.mysql.entity")
@SpringBootApplication()
public class CustomerAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerAccountApplication.class, args);
    }
}
