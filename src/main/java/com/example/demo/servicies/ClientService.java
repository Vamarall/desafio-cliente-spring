package com.example.demo.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {

        @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> findById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client;
    }
    
}
