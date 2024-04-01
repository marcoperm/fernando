package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.convocatoria;
import com.example.demo.service.serviceImplement.convserv;

@Controller
public class principal {

@Autowired
    private convserv servcon;

    @GetMapping("/")
    public String mostrarconvocatorias(Model model) {
        List<convocatoria> convocatorias= servcon.obtenertodos();
        model.addAttribute("convocatorias",convocatorias );
        return "index";
    }

@GetMapping("/participantelist")
    public String Autentic() {
        return "/participantelist";
    }
    
    @GetMapping("/vicerrectoria")
    public String vice() {
        return "/vicerrectoria";
    }
    
    

}
