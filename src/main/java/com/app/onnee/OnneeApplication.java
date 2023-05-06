package com.app.onnee;

import com.app.onnee.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
//@EntityScan("com.app.onnee.model")
public class OnneeApplication implements CommandLineRunner{
    @Autowired
    Environment environment;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OnneeApplication.class, args);
//        UserController userController = applicationContext.getBean(UserController.class);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running on Envioemnt --> " + Arrays.toString(environment.getActiveProfiles()));
    }

}
