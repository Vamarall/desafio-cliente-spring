package com.example.demo.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

        @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Optional<Client> findById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client;
    }

    @Transactional
    public Optional<Client> insert(Client client){
        Client novoCliente = clientRepository.save(client);
        return Optional.of(novoCliente);
    }

    @Transactional
    public Optional<Client> update(Long id, Client client) {

        Optional<Client> entidadeOptional = clientRepository.findById(id);

        Client entidade = entidadeOptional.get();

        entidade.setName(client.getName());
        entidade.setCpf(client.getCpf());
        entidade.setIncome(client.getIncome());
        entidade.setBirthDate(client.getBirthDate());
        entidade.setChildren(client.getChildren());
        
        clientRepository.save(entidade);
        return Optional.of(entidade);
    }

    @Transactional
    public void delete(Long id){
        clientRepository.deleteById(id);
    }
    
}
