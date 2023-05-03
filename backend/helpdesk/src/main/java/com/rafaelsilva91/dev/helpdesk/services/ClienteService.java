package com.rafaelsilva91.dev.helpdesk.services;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()-> new RuntimeException("Cliente não Encontrado!"));
    }

    public List<Cliente> findAll(){
        List<Cliente> list = repository.findAll();
        return list;
    }
}
