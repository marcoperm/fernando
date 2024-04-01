package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Evento;
import com.example.demo.service.serviceImplement.eventservice;

@Controller
public class controllerEvento {
    //private List<Evento> eventos = new LinkedList<>();
    @Autowired
    private eventservice eventoSer;
@GetMapping("/comiteevent")
    public String GestEvent(Model model) {
        model.addAttribute("eventos", eventoSer.obtenertodos());
        return "comiteevent";
}
    @GetMapping("/crearEvento")
    public String mostrarFormCrearEventol(Model model) {
        model.addAttribute("evento", new Evento());
        return "crearEvento";
    }

    @PostMapping("/crearEvento")
    @PreAuthorize("hasRole('comité organizador')")
    public String crearevento(@RequestParam String nombreEvent, @RequestParam LocalDate fechaInicio, @RequestParam
    LocalDate fechaFin, @RequestParam String descrip, MultipartFile[] imagen, Model model) throws IOException {
            Evento evento= new Evento();
            evento.setNombreEvent(nombreEvent);
            evento.setDescrip(descrip);
            evento.setFechaInicio(fechaInicio);
            evento.setFechaFin(fechaFin);
                    List<String> rutasImagenes = new ArrayList<>();
        for (MultipartFile file : imagen) {
            @SuppressWarnings("null")
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            rutasImagenes.add("/images/" + fileName);}
evento.setRutasImagenes(rutasImagenes);
            model.addAttribute("mensaje", "Se ha creado satisfactoriamente el evento");
            eventoSer.crearEvento(evento);
            return "crearEvento";

    }

    //Creando el evento
    /**/
    
    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoSer.eliminarEvento(id);
        return "redirect:/comiteevent";
    }

    @GetMapping("/editarevento/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoSer.obtenerEventoPorId(id);
        model.addAttribute("evento", evento);
        return "modificarEvento"; // Crear este archivo HTML para editar el evento.
    }
    @PostMapping("/modifEvento")
    public String modificarEvento(@ModelAttribute Evento evento) {
    eventoSer.modificar(evento);
    return "redirect:/comiteevent";
}
@GetMapping("/particEventosTodos")
    public String ListEvent(Model model) {
        model.addAttribute("eventos", eventoSer.obtenertodos());
        return "particEventosTodos";
}
@GetMapping("/verEvento/{id}")
    public String verEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoSer.obtenerEventoPorId(id);
    //List<String> imagenesBase64 = new ArrayList<>();
           // String imagenBase64 = Base64.getEncoder().encodeToString(evento.getImagen());
        model.addAttribute("evento", evento);
        return "detalleEvento";

}
/*   @GetMapping("/buscarEventos")
    public String buscarEventos(@RequestParam("nombreEvent") String nombreEvent, Model model) {
        List<Evento> eventosEncontrados = eventoSer.buscarPorNombre(nombreEvent);
        model.addAttribute("eventos", eventosEncontrados);
        return "comiteevent";

}*/
}