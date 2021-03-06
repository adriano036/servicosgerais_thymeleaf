package servicosgerais.thymeleaf.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@Profile({"dev", "hom"})
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("servicosgerais.thymeleaf.controller"))
                .paths(PathSelectors.any())
                .build()
                //.tags(new Tag("APP servicosgerais", "APP de Serviços Gerais"))
                .apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfo("servicosgerais APP (thymeleaf)",
               "APP de Serviços Gerais (thymeleaf)",
               "v1.0.3",
               "",
               new Contact("Serviços Gerais teste","http://www.teste.com/servicosgerais",""),
               "",
               "",
                Collections.emptyList());
    }
}
