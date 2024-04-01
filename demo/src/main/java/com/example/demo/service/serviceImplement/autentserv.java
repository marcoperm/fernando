package com.example.demo.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.userrepository;

@Service
public class autentserv {
    @Autowired
    private userrepository userRepository;


    public String authenticateUser(String username, String password) {
        Usuario user = userRepository.findByUsuario(username);
        if(user != null && user.getClave().equals(password)){
        return user.getRol();
        }
        return null;
    }
    

    }
    

