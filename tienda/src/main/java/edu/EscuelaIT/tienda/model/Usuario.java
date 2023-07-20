package edu.EscuelaIT.tienda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
