package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.convocatoria;
import com.example.demo.service.serviceImplement.convserv;



@Controller
public class controlConvocatoria {

    @Autowired
private convserv convServ;

    @GetMapping("comiteconv")
    public String listConvocatorias(Model model) {
        model.addAttribute("convocatorias", convServ.obtenertodos());
        return "comiteconv";
    }

    @GetMapping("/crearConvocatoria")
    public String mostrarFormularioCreacion(convocatoria conv) {
        return "crearConvocatoria";
    }

    @PostMapping("/guardar")
    public String guardarConvocatoria(convocatoria conv) {
        convServ.guardar(conv);
        return "redirect:/comiteconv";
    }
@GetMapping("/editarconv/{id}")
    public String editarConv(@PathVariable Long id, Model model) {
        convocatoria conv = convServ.enconConvocatoria(id);
        model.addAttribute("convocatoria", conv);
        return "ModificarConvoc";
    }


    @GetMapping("/eliminarconv/{id}")
    public String eliminarConvocatoria(@PathVariable Long id) {
        convServ.eliminarConvocatoria(id);
        return "redirect:/comiteconv";

    }

    @PostMapping("/guardarModificacion")
    public String modificarConvoc(@ModelAttribute convocatoria conv) {
        convServ.ModificarConvoc(conv);
        return "redirect:/comiteconv";
    }
    
    @GetMapping("/buscarConvocatorias")
    public String buscarConvoc(@RequestParam("nombre") String nombre, Model model) {
        List<convocatoria> convEncontr = convServ.buscarPorNombre(nombre);
        model.addAttribute("convocatorias", convEncontr);
        return "comiteconv";
}
}

