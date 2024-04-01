package com.example.demo.service.serviceInterface;

import java.util.List;

import com.example.demo.model.Usuario;

public interface IservUser {
    public List<Usuario> obtenerTodoslosUsuarios();
    public Usuario obtenerUserId(Long id);
    public void registrarse(String nombre, String apellidos,
String usuario, String clave,
String correo,  String facultad,
    String categdocente, Integer edad );
    public void actualizarRolUsuario(Long id, String nuevoRol);
    public void modificarUser(Usuario user);
    public void eliminarUser(Long id);
    
}
