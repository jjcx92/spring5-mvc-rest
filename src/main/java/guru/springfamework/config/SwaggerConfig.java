package guru.springfamework.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Juerghens castro on 07-10-20 and  07:00 PM to 2020
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {//extends WebMvcConfigurationSupport {

    //bean para la configuracion de swager 2
    @Bean
    public Docket api(){

        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }


    private ApiInfo metaData(){

        Contact contact = new Contact("J castro", "https://proof/about/",
                "jjcx92@gmail.com");

        return new ApiInfo(
                "Spring JJ",
                "Spring Framework 5: Beginner to Guru",
                "1.0",
                "Terms of Service: blah",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

//configuracion por si swagger no es presentada al ser configurada
/*    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }*/
}
