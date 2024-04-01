package com.example.demo.service.serviceInterface;

import java.util.List;

import com.example.demo.model.Evento;

public interface InterfServEvent {
    public List<Evento> obtenertodos();
    public Evento crearEvento(Evento evento );
    public void modificar(Evento evento);
    public Evento obtenerEventoPorId(Long id);
    public void eliminarEvento(Long id);
    public List<Evento> buscarPorNombre(String nombre) ;
}
