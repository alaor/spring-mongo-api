package com.dito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dito.controller"))
            .paths(PathSelectors.any())
            .build()
                .apiInfo(metaData())
            .useDefaultResponseMessages(true);

}

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Dito API")
                .description("Uma API para cadastro de eventos e exibição de timeline de compras.")
                .version("0.0.1").contact(
                        new Contact("Alaor Lopes de Resende",
                                "https://github.com/alaor",
                                "alaor.resende@gmail.com.br"))
                .build();
    }


}
