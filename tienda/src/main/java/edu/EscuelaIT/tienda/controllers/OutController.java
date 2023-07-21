package edu.EscuelaIT.tienda.controllers;

import edu.EscuelaIT.tienda.dao.UsuarioDao;
import edu.EscuelaIT.tienda.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario u) {
        if(usuarioDao.verificarCredenciales(u)) {
            return "OK";
        } else {
            return "Login incorrecto";
        }
    }
}
