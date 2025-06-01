package net.ayyoub.bdccensetmvc;

import net.ayyoub.bdccensetmvc.entities.Product;
import net.ayyoub.bdccensetmvc.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BdccEnsetMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdccEnsetMvcApplication.class, args);
    }
    @Bean
    public CommandLineRunner sart(ProductRepository repository) {
        return args -> {
            repository.save(Product.builder()
                            .name("Computer")
                            .price(1000.0)
                            .quantity(5.)
                    .build());
            repository.save(Product.builder()
                            .name("Printer")
                            .price(100.0)
                            .quantity(2.)
                    .build());
            repository.save(Product.builder().name("Smart phone").price(100.0).quantity(50.).build());
            repository.findAll().forEach(c-> System.out.println(c.toString()));
        };

    }

}
