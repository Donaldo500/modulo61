package com.ebac.Anotaciones.interfaces;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
@Qualifier("triangulo")
public class Triangulo implements Figura {
    @Override
    public void nombre() {
        System.out.println("Soy un triangulo");
    } 
}
