package com.ebac.Anotaciones;
import com.ebac.Anotaciones.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ebac.Anotaciones.interfaces.FiguraService;

public class Contexto {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.ebac.Anotaciones");
        context.refresh();

        Service service = context.getBean(Service.class);
        System.out.println("HashCode del objeto Service: " + service.hashCode());
        String ById = service.getById(17);
        System.out.println(ById);

        System.out.println("----------------------------------------------");
        FiguraService figuraService = context.getBean(FiguraService.class);
        figuraService.Nombre1();
        figuraService.Nombre2();
    }
}
