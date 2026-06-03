package com.ebac.Inyecciones.componentes;

public class ServicioSetter {
    private Model model;

    public void ejecutarServicio() {
        model.getData();
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
