package com.ebac.Inyecciones.componentes;

public class ServicioConstructor {
    private final Model model;

    public ServicioConstructor(Model model) {
        this.model = model;
    }

    public void ejecutarServicio() {
        model.getData();
    }
}
