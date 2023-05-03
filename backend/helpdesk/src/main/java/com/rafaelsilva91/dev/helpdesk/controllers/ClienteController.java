package com.rafaelsilva91.dev.helpdesk.controllers;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
