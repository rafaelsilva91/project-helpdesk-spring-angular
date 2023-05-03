package com.rafaelsilva91.dev.helpdesk.controllers;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.services.TecnicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tecnicos")
@CrossOrigin(origins = "*")
public class TecnicoController {

    private TecnicoService service;

    public TecnicoController(TecnicoService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
        Tecnico obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> findAll(){
        List<Tecnico> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


}
