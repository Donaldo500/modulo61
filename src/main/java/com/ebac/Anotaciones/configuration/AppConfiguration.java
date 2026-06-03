package com.ebac.Anotaciones.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.ebac.Anotaciones.service.DataBase;

@Configuration
@PropertySource("classpath:META-INF/application.properties")
public class AppConfiguration {
    
    @Bean
    public DataBase dataBase() {
        return new DataBase();
    }
}
