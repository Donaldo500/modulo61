package com.ebac.Inyecciones;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ebac.Inyecciones.componentes.ServicioSetter;
import com.ebac.Inyecciones.componentes.ServicioConstructor;
import com.ebac.Inyecciones.componentes.ServicioAnotaciones;

public class Contexto {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

        //ServicioSetter servicioSetter = (ServicioSetter) context.getBean("ServicioSetterBean");
        //servicioSetter.ejecutarServicio();

        //ServicioConstructor servicioConstructor = (ServicioConstructor) context.getBean("ServicioConstructorBean");
        //servicioConstructor.ejecutarServicio();

        ServicioAnotaciones servicioAnotaciones = (ServicioAnotaciones) context.getBean("ServicioAnotacionesBean");
        servicioAnotaciones.ejecutarServicio();
    }
}
