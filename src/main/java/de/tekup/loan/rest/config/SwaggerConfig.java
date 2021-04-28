package de.tekup.loan.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfoBuilder()
					.title("Loan Eligeblity Check")
					.description("A system to check the eligeblity of a client to get a bank loan")
					.termsOfServiceUrl("termsOfServiceUrl")
					.contact(new Contact("Hmida Rojbani", "", "hmida.rojbani@tek-up.de"))
					.license("Apache version 2.0")
					.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
					.build();
		
		return apiInfo;
	}

}
