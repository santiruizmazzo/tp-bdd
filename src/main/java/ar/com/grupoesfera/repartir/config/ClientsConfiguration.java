package ar.com.grupoesfera.repartir.config;

import ar.com.grupoesfera.repartir.clients.PersonasClient;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import(FeignClientsConfiguration.class)
public class ClientsConfiguration {

    @Value("${personas.api.url}")
    String personasApiUrl;

    @Bean
    @Autowired
    public PersonasClient personasClient(Encoder encoder, Decoder decoder, Contract contract) {

        return Feign.builder()
                .contract(contract)
                .encoder(encoder)
                .decoder(decoder)
                .target(PersonasClient.class, personasApiUrl);
    }
}
