package com.example.demo.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.servicies.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Client not found"));
        return client;
    }

    @Transactional
    public Optional<Client> insert(Client client) {
        Client novoCliente = clientRepository.save(client);
        return Optional.of(novoCliente);
    }

    @Transactional
    public Client update(Long id, Client client) {

        Client clientEntity = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found"));

        clientEntity.setName(client.getName());
        clientEntity.setCpf(client.getCpf());
        clientEntity.setIncome(client.getIncome());
        clientEntity.setBirthDate(client.getBirthDate());
        clientEntity.setChildren(client.getChildren());

        clientRepository.save(clientEntity);
        return clientEntity;
    }

    @Transactional
    public void delete(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client not found"));
        clientRepository.delete(client);
    }

    public Page<Client> findAll(Pageable pageable) {
        Page<Client> list = clientRepository.findAll(pageable);
        return list;
    }

}
