package com.app.onnee;

import com.app.onnee.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("com.app.onnee.model")
public class OnneeApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OnneeApplication.class, args);
//        UserController userController = applicationContext.getBean(UserController.class);

    }

}
