package ar.com.grupoesfera.repartir.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UsuarioTest {

    @Test
    void crearSinParametros() {

        new Usuario();
    }

    @Test
    void tieneUnIdQueLoAsociaConOtrosSistemasExternos() {

        Usuario carla = new Usuario();
        carla.setId("carla");
        assertThat(carla.getId()).isEqualTo("carla");
    }

    @Test
    void tieneUnCorreoQueSeObtieneDelServicioDePersonas() {

        Usuario marcos = new Usuario();
        marcos.setCorreo("marcos@repartir.com");
        assertThat(marcos.getCorreo()).isEqualTo("marcos@repartir.com");
    }
}
