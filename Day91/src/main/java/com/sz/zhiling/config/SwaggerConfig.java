package com.sz.zhiling.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean 
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo()).
                select().apis(RequestHandlerSelectors.basePackage("com.sz.zhiling.controller")).
                paths(PathSelectors.any()) .build(); 
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder() .
                title("SpringBoot 集成 SwaggerUi 框架") .
                description("Test") .termsOfServiceUrl("htt://www.baidu.com") .
                contact(new Contact("ccc","aaa","bbb")) .version("1.0") .build();
    }

}
