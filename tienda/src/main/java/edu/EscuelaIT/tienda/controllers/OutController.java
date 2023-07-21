package edu.EscuelaIT.tienda.controllers;

import edu.EscuelaIT.tienda.dao.UsuarioDao;
import edu.EscuelaIT.tienda.model.Usuario;
import edu.EscuelaIT.tienda.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario u) {
        Usuario usuarioLogueado =  usuarioDao.obtenerUsuarioPorCredenciales(u);
        if (usuarioLogueado != null) {
            return jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
        }
        return "FAIL";



    }
}
