package servicosgerais.api.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
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
public class SpringConfig {

//	@Bean
//	public ErrorPageFilter errorPageFilter() {
//	    return new ErrorPageFilter();
//	}
//
//	@Bean
//	public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
//	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//	    filterRegistrationBean.setFilter(filter);
//	    filterRegistrationBean.setEnabled(false);
//	    return filterRegistrationBean;
//	}
}
