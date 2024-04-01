package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Trabajo;
import com.example.demo.service.serviceImplement.servTrabajo;



@Controller
public class controlTrabajo {

    @Autowired
    private servTrabajo servTrab;
    @GetMapping("/subirTrabajo")
    public String subir() {
        return "subirTrabajo";
    }

    @PostMapping("/subirTrabajo")
    public String subirTrab(@ModelAttribute Trabajo trabajo, File archivoPDF) {
    
        servTrab.subirTrabajo(trabajo);
    return "redirect:detalleEvento";
    }
    @GetMapping("/revTrab")
    public String GestEvent(Model model) {
        model.addAttribute("trabajos", servTrab.obteTrabajos());
        return "revTrab";
}
}