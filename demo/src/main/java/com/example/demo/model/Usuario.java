package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nombre;
    private String apellidos;
    @Column(unique = true)
    private String usuario;
    private String clave;
    private String facultad;
    private String correo;
    private String categdocente;
    private Integer edad;
    private String rol;

    @OneToMany(mappedBy = "autor")
    private List<Trabajo> trabajosSubidos;

    /*@OneToOne(mappedBy = "user",cascade = CascadeType.ALL, optional = false,
    orphanRemoval = true)
    private Rol role;*/

/*@ManyToMany(mappedBy = "usuarios")
    private List<Evento> eventos;
*/
}