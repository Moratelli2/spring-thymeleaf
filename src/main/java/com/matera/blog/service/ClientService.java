package com.matera.blog.service;

import com.matera.blog.model.Client;
import com.matera.blog.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findOne(Long id) {
        return repository.findOne(id);
    }

    public Client save(Client client) {
        return repository.saveAndFlush(client);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
