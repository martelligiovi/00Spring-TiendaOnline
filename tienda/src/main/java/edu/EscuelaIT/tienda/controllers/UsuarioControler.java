package edu.EscuelaIT.tienda.controllers;


import edu.EscuelaIT.tienda.dao.UsuarioDao;
import edu.EscuelaIT.tienda.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControler {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping("api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();

    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar (id);
    }




}
