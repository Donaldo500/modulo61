package com.ebac.Anotaciones.service;

import org.springframework.beans.factory.annotation.Value;

public class DataBase {
    @Value("${db.dev.url}")
    String dbUrl;

    @Value("root")
    String user;

    @Value("root")
    String password;

    @Value("${VARIABLE_AMBIENTE}")
    String variableDeAmbiente;

    public String getById(int id) {
        System.out.println("Conectando a la base de datos en: " + dbUrl);
        System.out.println("Usuario: " + user);
        System.out.println("Contraseña: " + password);
        System.out.println("Variable de ambiente: " + variableDeAmbiente);
        return "Data for ID: " + id;
    }
}
