package ar.com.grupoesfera.repartir.services;

import ar.com.grupoesfera.repartir.clients.Persona;
import ar.com.grupoesfera.repartir.clients.PersonasClient;
import ar.com.grupoesfera.repartir.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UsuariosServiceTest {

    private final Persona DANIEL = new Persona() {{
        setId("daniel");
        setNombre("Daniel Rosales");
        setCorreo("daniel@repartir.com");
        setDocumento("34564783");
    }};

    private UsuariosService service;

    private PersonasClient personasClientMock;

    @BeforeEach
    public void crear() {

        service = new UsuariosService();

        personasClientMock = mock(PersonasClient.class);
        service.personasClient = personasClientMock;
    }

    @Test
    void recuperarUsuarioExistenteDelServicioDePersonas() {

        dadoQueEnElServicioDePersonasEstaRegistrado(DANIEL);

        Usuario usuarioDaniel = service.recuperar("daniel");

        entoncesSonConcordantes(DANIEL, usuarioDaniel);
    }

    private void dadoQueEnElServicioDePersonasEstaRegistrado(Persona persona) {

        when(personasClientMock.recuperarPorId(persona.getId())).thenReturn(persona);
    }

    private void entoncesSonConcordantes(Persona persona, Usuario usuario) {

        assertThat(usuario.getId()).isEqualTo(DANIEL.getId());
        assertThat(usuario.getCorreo()).isEqualTo(DANIEL.getCorreo());
    }
}