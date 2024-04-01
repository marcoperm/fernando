package com.example.demo.service.serviceImplement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Evento;
import com.example.demo.repository.eventorepository;
import com.example.demo.service.serviceInterface.InterfServEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class eventservice implements InterfServEvent{
    //inyeccion de dependencia
    @Autowired
    private  eventorepository eventoRepo;

    //listar eventos
    @Override
    public List<Evento> obtenertodos(){
        return eventoRepo.findAll();
    }

    //crear evento
    @Override
    @SuppressWarnings("null")
    public Evento crearEvento(Evento evento ){
    return eventoRepo.save(evento);
}
@SuppressWarnings("null")
@Override
    public void modificar(Evento evento) {
        eventoRepo.save(evento);
    }
    @Override
    @SuppressWarnings("null")
    public Evento obtenerEventoPorId(Long id) {
        return eventoRepo.findById(id).orElse(null);
    }
    @Override
    @SuppressWarnings("null")
    public void eliminarEvento(Long id) {
        eventoRepo.deleteById(id);
    }

@Override
public List<Evento> buscarPorNombre(String nombre) {
    return eventoRepo.findByNombreEvent(nombre);
}
/*  List<Evento> elist = eventoRepo.findAll();
    List<Evento> eventLi = null;
    for (Evento event : elist) {
        if (event.getNombreEvent().equals(nombre)) {
            eventLi.add(event);
        }}
        if (eventLi != null) {
        return eventLi;
}
        else{
            System.out.println("No se encontró el evento.");
            return eventoRepo.findAll();
        }

}*/
}