package edu.EscuelaIT.tienda.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Persona {
    @NonNull
    private Long id;
    @NonNull
    private String nombre;
    private String apellido;

}
