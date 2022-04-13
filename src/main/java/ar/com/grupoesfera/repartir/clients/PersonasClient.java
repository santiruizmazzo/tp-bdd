package ar.com.grupoesfera.repartir.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "personas")
public interface PersonasClient {

    @GetMapping(path = "/personas/{id}",
                produces = APPLICATION_JSON_VALUE)
    Persona recuperarPorId(@PathVariable("id") String id);
}
