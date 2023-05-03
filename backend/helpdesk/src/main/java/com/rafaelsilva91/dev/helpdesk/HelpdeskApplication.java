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
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

}
