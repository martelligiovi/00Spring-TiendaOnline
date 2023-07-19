package edu.EscuelaIT.tienda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column (name = "email")
    private String email;

    @Column (name = "password")
    private String password;

    public Usuario(){
    }
    public Usuario(Long id){
        this.id = id;
    }
}
