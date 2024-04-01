package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlComite {



    @GetMapping("/comite")
    public String Comit(Model model) {
        return "comite";
    }
    

}



    
    
    
    /*
    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificacion(@PathVariable Long id, Model model) {
        Evento evento = eventoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id de evento inválido: " + id));
        model.addAttribute("evento", evento);
        return "formularioModificarEvento";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificarEvento(@PathVariable Long id, @ModelAttribute Evento evento) {
        evento.setId(id);
        eventoRepo.save(evento);
        return "redirect:/eventos";
    }
    
    @GetMapping("/eliminar/{id_event}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoRepo.deleteById(id_event);
        return "redirect:/eventos";
    }
*/


