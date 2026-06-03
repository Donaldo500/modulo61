package com.ebac.Inyecciones.componentes;

import org.springframework.beans.factory.annotation.Autowired;

public class ServicioAnotaciones {
    @Autowired
    Model model;

    public ServicioAnotaciones(Model model) {
        this.model = model;
    }

    public void ejecutarServicio() {
        model.getData();
    }
}
