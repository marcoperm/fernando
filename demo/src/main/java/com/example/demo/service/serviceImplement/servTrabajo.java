package com.example.demo.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Trabajo;
import com.example.demo.repository.TrabRepository;
import com.example.demo.service.serviceInterface.IservTrabajo;

@Service
public class servTrabajo implements IservTrabajo {
    
    @Autowired
    private TrabRepository repotrab;

    @Override
    public List<Trabajo> obteTrabajos(){
        return repotrab.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public void subirTrabajo(Trabajo trab){
        repotrab.save(trab);
    }
    
}
