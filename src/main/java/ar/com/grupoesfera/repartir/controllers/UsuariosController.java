package ar.com.grupoesfera.repartir.controllers;

import ar.com.grupoesfera.repartir.exceptions.GrupoNoEncontradoException;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.model.Usuario;
import ar.com.grupoesfera.repartir.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuarios;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> recuperar(@PathVariable String id) {

        return ResponseEntity.ok(usuarios.recuperar(id));
    }
}
