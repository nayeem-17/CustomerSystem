package com.minegocio.customersystem.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configurable
@EnableSwagger2
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("My API")
                .description("API documentation")
                .version("1.0")
                .build();
    }

    // private ApiKey apiKey() {
    // return new ApiKey(AUTHORIZATION_HEADER, "JWT", "header");
    // }

    // private SecurityContext securityContext() {
    // return SecurityContext.builder().securityReferences(defaultAuth()).build();
    // }

    // private List<SecurityReference> defaultAuth() {
    // AuthorizationScope authorizationScope = new AuthorizationScope("global",
    // "accessEverything");
    // AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    // authorizationScopes[0] = authorizationScope;
    // return Arrays.asList(new SecurityReference(AUTHORIZATION_HEADER,
    // authorizationScopes));
    // }

}
