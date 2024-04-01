package com.example.demo.service.serviceImplement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Usuario;
import com.example.demo.repository.userrepository;
import com.example.demo.service.serviceInterface.IservUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class servuser implements IservUser{
    //inyeccion de dependencia
    @Autowired
    private  userrepository userrepos;
    @Override
    public List<Usuario> obtenerTodoslosUsuarios(){
        return userrepos.findAll();}
    
    @SuppressWarnings("null")
    @Override
    public Usuario obtenerUserId(Long id){
        return userrepos.findById(id).orElse(null);
    }

    //Registrar usuario agregando automaticamente el rol de participante
    public void registrarse(String nombre, String apellidos,
String usuario, String clave,
String correo,  String facultad,
    String categdocente, Integer edad ){
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setApellidos(apellidos);
        user.setUsuario(usuario);
        user.setClave(clave);
        user.setCorreo(correo);
        user.setFacultad(facultad);
        user.setCategdocente(categdocente);
        user.setEdad(edad);
        user.setRol("participante");
        userrepos.save(user);
        /*Rol role = new Rol();
        role.setRoldesemp("participante");
        role.setUser(user);
        rolrepos.save(role);
        user.setRole(role);
        userrepos.save(user);*/
    }
    @Override
    @Transactional
    public void actualizarRolUsuario(Long id, String nuevoRol) {
        @SuppressWarnings("null")
        Usuario usuario = userrepos.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setRol(nuevoRol);
        userrepos.save(usuario);

}
@SuppressWarnings("null")
@Override
public void modificarUser(Usuario user){
    userrepos.save(user);
}

@SuppressWarnings("null")
@Override
public void eliminarUser(Long id) {
    userrepos.deleteById(id);
}
}

        
    


