/*package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.convocatoria;
import com.example.demo.service.serviceImplement.convserv;

@RestController
@RequestMapping("/convocatorias")
public class controlVerConvocat {
    @Autowired
    private convserv servconv;
    @GetMapping
    public List<convocatoria> verconvocatorias(){
        return servconv.obtenertodos();
    }
}
*/