package com.project.io.demo;

import com.project.io.demo.config.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.project.io.demo.domain")
@EnableAutoConfiguration
public class DemoApplication {

    @Autowired
    private YAMLConfig myConfig;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("using environment: " + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
    }

}
