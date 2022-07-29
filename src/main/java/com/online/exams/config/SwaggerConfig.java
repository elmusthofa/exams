package com.online.exams.config;

import com.google.common.base.Predicates;
import com.online.exams.exception.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Profile({"development"})
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-user")
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(new ApiKey("JWT", Constant.HEADER_AUTHORIZATION, "header")))
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API Online Course")
                .description("API Online Course")
                .contact(new Contact("Muhammad Sabili", "", "muhammad.sabili@iconpln.co.id"))
                .license("Private Unlicensed Project")
                .version("1.0-SNAPSHOT").build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .forPaths(PathSelectors.any())
                .securityReferences(Collections.singletonList(new SecurityReference("JWT",
                        new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})))
                .build();
    }

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select().apis(RequestHandlerSelectors.basePackage("com.online.exams.controller"))
//                .build()
//                .apiInfo(apiInfo());
//    }

//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

}
