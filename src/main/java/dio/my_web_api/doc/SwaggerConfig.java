package dio.my_web_api.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contato() {
        return new Contact(
                "Seu nome",
                "http://www.seusite.com.br",
                "voce@seusite.com.br");
    }

    private ApiInfoBuilder informacoesApi() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Title - Rest API")
                .description("API exemplo de uso de Springboot REST API")
                .version("1.0")
                .termsOfServiceUrl("Termo de uso: Open Source")
                .license("Licença - Sua empresa")
                .licenseUrl("http:/www.seusite.com.br")
                .contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("dio.my_web_api.controller")) // Corrigido para o pacote correto
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(java.util.Arrays.asList("application/json"))) // Corrigido
                .produces(new HashSet<String>(java.util.Arrays.asList("application/json"))); // Corrigido
    }
}
