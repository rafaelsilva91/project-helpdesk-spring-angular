package com.rafaelsilva91.dev.helpdesk.config;

import com.rafaelsilva91.dev.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean instanciaDB(){
        if(value.equals("create")){
            this.dbService.instanciaDB();
        }
        return false;
    }

}
