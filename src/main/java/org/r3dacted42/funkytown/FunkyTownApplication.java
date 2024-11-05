package org.r3dacted42.funkytown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FunkyTownApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunkyTownApplication.class, args);
    }

}
