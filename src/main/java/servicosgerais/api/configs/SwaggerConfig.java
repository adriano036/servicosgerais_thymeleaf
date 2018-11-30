package servicosgerais.api.configs;

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
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("API servicosgerais", "API de Serviços Gerais"))
                .apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfo("servicosgerais API",
               "API de Serviços Gerais",
               "v1.0.2",
               "",
               new Contact("Serviços Gerais","http://www.google.com/servicosgerais",""),
               "",
               "",
                Collections.emptyList());
    }
}
