package edu.EscuelaIT.tienda.controllers;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edu.EscuelaIT.tienda.dao.UsuarioDao;
import edu.EscuelaIT.tienda.model.Usuario;
import edu.EscuelaIT.tienda.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControler {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    JWTUtil jwtUtil;

    @RequestMapping("api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return null;
        }
        return usuarioDao.getUsuarios();
    }
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }



    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization") String token,@PathVariable Long id) {if (!validarToken(token)) {
        return;
    }
        usuarioDao.eliminar (id);
    }
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrar(@RequestBody Usuario u) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String hash = argon2.hash(1,1024,1,u.getPassword());
        u.setPassword(hash);

        usuarioDao.registrar(u);
    }




}
