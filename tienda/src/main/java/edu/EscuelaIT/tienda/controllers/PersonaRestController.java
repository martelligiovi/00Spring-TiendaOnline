package edu.EscuelaIT.tienda.controllers;

import edu.EscuelaIT.tienda.domain.Persona;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaRestController {

    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"juan"),
                    new Persona(2L,"pedro"),
                    new Persona(3L,"maria")
            )

    );
@GetMapping("/personas/{id}")
     public Persona getPersonaPorId(@PathVariable Long id) {
    //recorrer cada persona del arraylist
            for (Persona persona : this.personas) {
                //buscar la persona con el id que me pasan
                if (persona.getId().equals(id)) {
                    //devolver la persona
                    return persona;
                }
            }
            return null;
     }
     @GetMapping("/personas")
     public List<Persona> listPersona() {
         return this.personas;
     }
     public Persona createPersona(Persona persona) {
         return null;
     }
     public Persona updatePersona(Persona persona) {
         return null;
     }
     @DeleteMapping("/personas/{id}")
     public void deletePersona(Long id) {
         for (Persona persona : this.personas) {
             //buscar la persona con el id que me pasan
             if (persona.getId().equals(id)) {
                 //devolver la persona
                    this.personas.remove(persona);
             }
         }

     }




}
