package com.rafaelsilva91.dev.helpdesk.controllers;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.domain.dtos.TecnicoDto;
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
    public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id){
        Tecnico tecnico = this.service.findById(id);
        return ResponseEntity.ok().body(new TecnicoDto(tecnico));
    }

//    @GetMapping
//    public ResponseEntity<List<TecnicoDto>> findAll(){
//        List<Tecnico> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }


}
