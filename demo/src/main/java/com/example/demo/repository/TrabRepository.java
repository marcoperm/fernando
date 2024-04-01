package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Trabajo;

public interface TrabRepository extends JpaRepository<Trabajo, Long> {
    
}
