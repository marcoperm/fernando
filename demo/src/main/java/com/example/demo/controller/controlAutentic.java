package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Usuario;
import com.example.demo.repository.userrepository;
import com.example.demo.service.serviceImplement.autentserv;

@Controller
public class controlAutentic {
    @GetMapping("/autenticar")
    public String Autenticarse() {
        return "/autenticar";
    }
    @Autowired
    private autentserv authenticationService;
    @Autowired
    private userrepository userrep;

    @GetMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String clave, Model model) {
        String Authenticated = authenticationService.authenticateUser(usuario, clave);
        if (Authenticated!= null) {
            Usuario user = userrep.findByUsuario(usuario);
            model.addAttribute("id", user.getId());
            model.addAttribute("nombre", user.getNombre());
            model.addAttribute("apellidos", user.getApellidos());
            model.addAttribute("correo", user.getCorreo());
        }

        if (Authenticated!= null) {
            if ("participante".equals(Authenticated)) {
            return "/participantePrinc";
            }
        }
        if (Authenticated!= null) {
            if ("vicerrectoria".equals(Authenticated)) {
            return "/vicerrectoria";
            }
        }
        if (Authenticated!= null) {
            if ("comité organizador".equals(Authenticated)) {
            return "/comite";
            }
        }
        if (Authenticated!= null) {
            if ("revisor".equals(Authenticated)) {
            return "/revisor";
            }
        }
            return "/index";
        
    }

}
