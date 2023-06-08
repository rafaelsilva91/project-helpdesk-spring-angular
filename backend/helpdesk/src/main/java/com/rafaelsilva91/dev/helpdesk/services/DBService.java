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
        Tecnico tec1 = new Tecnico(null, "Elon Musk", "06495069014", "musk@mail.com", "123");
        tec1.addPerfil(PerfilEnum.ADMIN);

        Tecnico tec2 = new Tecnico(null, "Mark Zuckberg", "45355576087", "zuckberg@mail.com", "123");
        tec2.addPerfil(PerfilEnum.TECNICO);

        Tecnico tec3 = new Tecnico(null, "Linus Torvalds", "53044500001", "torvalds@mail.com", "123");
        tec3.addPerfil(PerfilEnum.TECNICO);

        Cliente cli1 = new Cliente(null, "Maira Rosa de Sá", "48542442083", "rosa@mail.com", "123");
        cli1.addPerfil(PerfilEnum.CLIENTE);

        Cliente cli2 = new Cliente(null, "Neide Souza Silva", "49070876086", "souza@mail.com", "123");
        cli2.addPerfil(PerfilEnum.CLIENTE);

        Chamado c1 = new Chamado(null, PrioridadeEnum.MEDIA, StatusEnum.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec2, cli1);
        Chamado c2 = new Chamado(null, PrioridadeEnum.ALTA, StatusEnum.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        chamadoRepository.saveAll(Arrays.asList(c1, c2));
    }
}
