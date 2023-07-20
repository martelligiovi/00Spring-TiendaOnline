package edu.EscuelaIT.tienda.dao;

import edu.EscuelaIT.tienda.model.Persona;
import edu.EscuelaIT.tienda.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
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
}
