package com.dh.reservaTurnoOdontologico;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;

public class OdontologoTest {
    Odontologo odontologo;

    @BeforeEach
    void doBefore(){
        System.out.println("Antes de iniciar la prueba creo un odontologo");
        odontologo=new Odontologo(888,"OdontoTest1","Odonto1");

    }
    @Test
    void funcionTest(){
        //Condiciones
        String nombreValido ="testito";
        Odontologo odontologo1=new Odontologo();


        //Cuando
        odontologo1.setNombre(nombreValido);


        //Entonces
        Assertions.assertEquals(true,odontologo1.getNombre()=="testito");


    }
}
