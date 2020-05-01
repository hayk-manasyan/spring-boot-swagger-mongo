package com.project.io.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private final Logger log = LoggerFactory.getLogger(SpringFoxConfig.class);

    @Bean
    public Docket api() {
        log.debug("Starting Swagger");

        ApiInfo apiInfo = apiEndPointsInfo();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.project.io.demo.resources"))
                .paths(regex("/.*"))
                .build();
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Demo REST API")
                .description("Demo project REST API")
                .version("1.0.0")
                .build();
    }
}
