package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event;
    @Basic
    private String nombreEvent;
    @Basic
    private String descrip;
    @Basic
    private LocalDate fechaInicio;
    @Basic
    private LocalDate fechaFin;
        @ElementCollection
    private List<String> rutasImagenes;

    /*private List<MultipartFile> imagen;*/
    
/*@ManyToMany
    @JoinTable(name = "Usuario",
        joinColumns = @JoinColumn(name = "id_event"),
        inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Usuario> usuarios;
*/

}
