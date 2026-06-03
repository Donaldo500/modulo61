package com.ebac.Anotaciones.interfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FiguraService {
    @Autowired
    @Qualifier("cuadrado")
    Figura figura1;

    @Autowired
    @Qualifier("triangulo")
    Figura figura2;

    public void Nombre1() {
        figura1.nombre();
    }

    public void Nombre2() {
        figura2.nombre();
    }
}
