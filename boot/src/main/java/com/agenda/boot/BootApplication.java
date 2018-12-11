package com.agenda.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
//@ComponentScan({"com.agenda.restapi", "com.agenda.restapiimpl",
//        "com.agenda.serviceapi", "com.agenda.serviceapiimpl"})
//

@ComponentScan({"com.agenda.*", "security"})
@EnableJpaRepositories("com.agenda.model.repository")
@EntityScan({"com.agenda.model.entity"})
@Configuration
@EnableSwagger2
@EnableWebSecurity
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}

//Acccess form browser: localhost:8080/swagger-ui.html
