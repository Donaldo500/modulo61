package com.ebac.Anotaciones.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Service {
    @Autowired
    private DataBase dataBase;

    public String getById(int id) {
        if (id < 10) {
            return "El id no puede ser menor que 10";
        }
        return dataBase.getById(id);
    }
}
