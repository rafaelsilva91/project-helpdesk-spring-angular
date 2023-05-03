package com.rafaelsilva91.dev.helpdesk.config;

import com.rafaelsilva91.dev.helpdesk.services.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    private DBService dbService;

    public TestConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public void instanciaDB(){
        this.dbService.instanciaDB();
    }

}
