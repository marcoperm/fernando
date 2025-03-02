package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;



@Repository
public interface userrepository extends JpaRepository <Usuario, Long> {
    Usuario findByUsuario(String usuario);

        /*@Query("SELECT u FROM Usuario u")
    List<Usuario> obtenerTodosLosUsuarios();*/

}

