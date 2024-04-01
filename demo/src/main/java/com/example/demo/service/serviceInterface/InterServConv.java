package com.example.demo.service.serviceInterface;

import java.util.List;

import com.example.demo.model.convocatoria;

public interface InterServConv {
public List<convocatoria> obtenertodos();
    public void guardar(convocatoria conv);
public void eliminarConvocatoria(Long id);
public convocatoria enconConvocatoria(Long id);
public void ModificarConvoc(convocatoria convocatoriaModificada);
public List<convocatoria> buscarPorNombre(String nombre) ;
}

