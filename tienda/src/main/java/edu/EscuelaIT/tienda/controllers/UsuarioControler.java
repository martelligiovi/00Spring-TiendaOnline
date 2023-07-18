package edu.EscuelaIT.tienda.controllers;


import edu.EscuelaIT.tienda.model.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControler {

    @RequestMapping("/usuarios/{id}")
public Usuario getUsuarios(@PathVariable Long id) {
    Usuario usuario = new Usuario(id);
    usuario.setNombre("Pepe");
    usuario.setApellido("Perez");
    return usuario;
}

    @RequestMapping("/usuario")
    public List<Usuario> getUsuarios() {
        Usuario usuario = new Usuario(1L);
        usuario.setNombre("Pepe");
        usuario.setApellido("Perez");
        usuario.setEmail("pepe@gmail.com");

        Usuario usuario2 = new Usuario(2L);
        usuario2.setNombre("juan");
        usuario2.setApellido("Perez");
        usuario2.setEmail("juan@gmail.com");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        usuarios.add(usuario2);
        return usuarios;

    }




}
