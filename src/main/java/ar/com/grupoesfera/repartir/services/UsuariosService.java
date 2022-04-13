package ar.com.grupoesfera.repartir.services;

import ar.com.grupoesfera.repartir.clients.Persona;
import ar.com.grupoesfera.repartir.clients.PersonasClient;
import ar.com.grupoesfera.repartir.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    PersonasClient personasClient;

    public Usuario recuperar(String id) {

        Persona persona = personasClient.recuperarPorId(id);

        Usuario usuario = new Usuario();
        usuario.setId(persona.getId());
        usuario.setCorreo(persona.getCorreo());

        return usuario;
    }
}
