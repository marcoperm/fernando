package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.service.serviceImplement.servuser;

@Controller
public class controlUser {
    @GetMapping("/registrar")
    public String Registrar() {
        return "registrar";
    }
    @Autowired
    private servuser userserv;

    @GetMapping("/usuarios")
    public String verTodos(Model model) {
        model.addAttribute("usuarios", userserv.obtenerTodoslosUsuarios());
        /*List<Usuario> usuarios= userserv.obtenerTodoslosUsuarios();
        for (Usuario user : usuarios) {
            model.addAttribute("nombre", user.getNombre());
        model.addAttribute("apellidos", user.getApellidos());
        model.addAttribute("correo", user.getCorreo());
        model.addAttribute("role", user.getRol());}*/
        return "usuarios";
    }
    @PostMapping("/registrarse")
    public String procesar(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
    @RequestParam("usuario") String usuario, @RequestParam("clave") String clave,
    @RequestParam("correo") String correo, @RequestParam("facultad") String facultad,
    @RequestParam("categdocente") String categdocente, @RequestParam("edad") Integer edad, Model model) {
        userserv.registrarse(nombre, apellidos, usuario, clave, correo, facultad, categdocente, edad);
        model.addAttribute("mensaje", "Se ha registrado satisfactoriamente");
        return "registrar";
    }
    @GetMapping("/cancelar")
    public String cancelar(){
return "redirect:/";
    }
    
    @PostMapping("/editarRol/{id}")
    public String editarRolUsuario(@PathVariable("id") Long id, @RequestParam("nuevoRol") String nuevoRol) {
        userserv.actualizarRolUsuario(id, nuevoRol);
        return "redirect:/usuarios";
    }
@GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario user = userserv.obtenerUserId(id);
        model.addAttribute("user", user);
        return "modificarUser"; // Crear este archivo HTML para editar el evento.
    }
    
@PostMapping("/editarUser")
    public String modificarUser( Usuario user) {
    userserv.modificarUser(user);
    return "redirect:/";
}
@GetMapping("/eliminarUsuario/{id}")
public String eliminarUsuario(@PathVariable Long id, Model model) {
    userserv.eliminarUser(id);
    return "redirect:/"; // Crear este archivo HTML para editar el evento.
}
    
}