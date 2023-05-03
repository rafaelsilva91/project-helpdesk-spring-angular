package com.rafaelsilva91.dev.helpdesk;

import com.rafaelsilva91.dev.helpdesk.domain.Chamado;
import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.domain.enums.PerfilEnum;
import com.rafaelsilva91.dev.helpdesk.domain.enums.PrioridadeEnum;
import com.rafaelsilva91.dev.helpdesk.domain.enums.StatusEnum;
import com.rafaelsilva91.dev.helpdesk.repositories.ChamadoRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.ClienteRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.TecnicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	private TecnicoRepository tecnicoRepository;
	private ClienteRepository clienteRepository;
	private ChamadoRepository chamadoRepository;

	public HelpdeskApplication(TecnicoRepository tecnicoRepository, ClienteRepository clienteRepository, ChamadoRepository chamadoRepository) {
		this.tecnicoRepository = tecnicoRepository;
		this.clienteRepository = clienteRepository;
		this.chamadoRepository = chamadoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Rafael Rodrigues", "45355576087", "rafael@mail.com", "123");
		tec1.addPerfil(PerfilEnum.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "48542442083", "torvalds@mail.com", "123");
		tec1.addPerfil(PerfilEnum.CLIENTE);

		Chamado c1 = new Chamado(null, PrioridadeEnum.MEDIA, StatusEnum.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
