package edu.EscuelaIT.tienda.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edu.EscuelaIT.tienda.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDao implements usuariojava{


    @PersistenceContext
    EntityManager entityManager;



    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario u) {
        entityManager.merge(u);
    }

    public Usuario obtenerUsuarioPorCredenciales(Usuario u) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", u.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String hash = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        if (argon2.verify(hash, u.getPassword())){
            return lista.get(0);
        }
        return null;
    }
}
