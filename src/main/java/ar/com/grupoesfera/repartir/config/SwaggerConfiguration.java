package ar.com.grupoesfera.repartir.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import javax.servlet.Filter;

import static org.springdoc.core.Constants.*;
import static org.springdoc.core.Constants.SPRINGDOC_SWAGGER_UI_ENABLED;

@Configuration
@ConditionalOnProperty(value = SPRINGDOC_SWAGGER_UI_ENABLED, matchIfMissing = true)
public class SwaggerConfiguration {

    @Bean
    public OpenAPI configureOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Repartir")
                        .description("Repartimos los gastos grupales"));
    }

    @Bean
    public Filter configureForwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }
}
