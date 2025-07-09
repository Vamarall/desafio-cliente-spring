package com.example.demo.controllers;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Client;
import com.example.demo.servicies.ClientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Optional<Client> cliente = clientService.findById(id);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
   public ResponseEntity<Client> insert(@RequestBody Client client){
    Optional<Client> novoCliente = clientService.insert(client);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoCliente.get().getId())
                .toUri();

    return ResponseEntity.created(uri).body(novoCliente.get());

   }

   @PutMapping("/{id}")
   public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
    Optional<Client> clienteAtualizado = clientService.update(id, client);
    return clienteAtualizado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id){
    clientService.delete(id);
    return ResponseEntity.noContent().build();
   }
  
    
    
}
