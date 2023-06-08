package com.rafaelsilva91.dev.helpdesk.services;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.repositories.TecnicoRepository;
import com.rafaelsilva91.dev.helpdesk.services.exceptions.ObjectNotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    private TecnicoRepository repository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.repository = tecnicoRepository;
    }

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExceptions("Objeto não encontrado! Id: "+id));
    }

    public List<Tecnico> findAll(){
        List<Tecnico> list = repository.findAll();
        return list;
    }
}
