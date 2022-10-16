package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getClientAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClientId(Integer clientId) {
        return clientCrudRepository.findById(clientId);
    }

    public Client save(Client client) {
        return clientCrudRepository.save(client);
    }

    /*public void update(Client client){
        clientCrudRepository.update(client);
    }
*/
    public void delete(Client client) {
        clientCrudRepository.delete(client);
    }
}
