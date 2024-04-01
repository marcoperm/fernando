package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.convocatoria;

public interface convocatoriaRepository extends JpaRepository <convocatoria, Long> {
List<convocatoria> findByNombre(String nombre);
}
