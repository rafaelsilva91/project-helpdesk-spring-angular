package com.rafaelsilva91.dev.helpdesk.services;

import com.rafaelsilva91.dev.helpdesk.domain.Chamado;
import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.domain.enums.PerfilEnum;
import com.rafaelsilva91.dev.helpdesk.domain.enums.PrioridadeEnum;
import com.rafaelsilva91.dev.helpdesk.domain.enums.StatusEnum;
import com.rafaelsilva91.dev.helpdesk.repositories.ChamadoRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.ClienteRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    private TecnicoRepository tecnicoRepository;
    private ClienteRepository clienteRepository;
    private ChamadoRepository chamadoRepository;

    public DBService(TecnicoRepository tecnicoRepository, ClienteRepository clienteRepository, ChamadoRepository chamadoRepository) {
        this.tecnicoRepository = tecnicoRepository;
        this.clienteRepository = clienteRepository;
        this.chamadoRepository = chamadoRepository;
    }

    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "João Silva Ribeiro", "45355576087", "ribeiro@mail.com", "123");
        tec1.addPerfil(PerfilEnum.ADMIN);

        Cliente cli1 = new Cliente(null, "Maira Rosa de Sá", "48542442083", "rosa@mail.com", "123");
        tec1.addPerfil(PerfilEnum.CLIENTE);

        Chamado c1 = new Chamado(null, PrioridadeEnum.MEDIA, StatusEnum.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
