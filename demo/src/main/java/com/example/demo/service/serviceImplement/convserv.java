package com.example.demo.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.convocatoria;
import com.example.demo.repository.convocatoriaRepository;
import com.example.demo.service.serviceInterface.InterServConv;
@Service
public class convserv implements InterServConv {
@Autowired
private convocatoriaRepository convrepo;

    @Override
    public List<convocatoria> obtenertodos() {
    return  convrepo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public void guardar(convocatoria conv){
        convrepo.save(conv);
    }

    @SuppressWarnings("null")
    @Override
    public void eliminarConvocatoria(Long id){
        convrepo.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public convocatoria enconConvocatoria(Long id){
        return convrepo.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Override
    public void ModificarConvoc(convocatoria convocatoriaModificada){
        convrepo.save(convocatoriaModificada);
    }

    @Override
    public List<convocatoria> buscarPorNombre(String nombre) {
        return convrepo.findByNombre(nombre);
    }
}
