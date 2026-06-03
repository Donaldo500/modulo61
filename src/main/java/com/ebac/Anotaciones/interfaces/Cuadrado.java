package com.ebac.Anotaciones.interfaces;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("cuadrado")
public class Cuadrado implements Figura {
    @Override
    public void nombre() {
        System.out.println("Soy un cuadrado");
    } 
}
