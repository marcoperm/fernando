package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Evento;

@Repository
public interface eventorepository  extends JpaRepository <Evento, Long>{
   List<Evento> findByNombreEvent(String nombreEvent);
}
