package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientAll(){
        return clientRepository.getClientAll();
    }

    public Optional<Client> getClientId(Integer clientId) {
        return clientRepository.getClientId(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clientAuxiliar= clientRepository.getClientId(client.getIdClient());
            if(clientAuxiliar.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientAuxiliar= clientRepository.getClientId(client.getIdClient());
            if(!clientAuxiliar.isEmpty()){
                if(client.getName()!=null){
                    clientAuxiliar.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    clientAuxiliar.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    clientAuxiliar.get().setPassword(client.getPassword());
                }
                clientRepository.save(clientAuxiliar.get());
                return clientAuxiliar.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(Integer id){
        boolean flag=false;
        Optional<Client> clientAuxiliar = clientRepository.getClientId(id);
        if(clientAuxiliar.isPresent()){
            clientRepository.delete(clientAuxiliar.get());
            flag=true;
        }
        return flag;
    }

    }

