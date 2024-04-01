package com.example.demo.service.serviceInterface;

import java.util.List;

import com.example.demo.model.Trabajo;


public interface IservTrabajo {
    public List<Trabajo> obteTrabajos();
    public void subirTrabajo(Trabajo trab);
}
