package edu.EscuelaIT.tienda.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Usuario {
    @NonNull
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

}
