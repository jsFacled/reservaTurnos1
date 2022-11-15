package com.dh.reservaTurnoOdontologico;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.service.ServiceOdontologo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRepositoryOdontologoh2 {

    @BeforeEach
    void doBefore(){
        System.out.println("Antes de iniciar la prueba muestro mensaje de inicioTest");

    }
    @Test
    void listaOdontologoModelTest(){
        //Condiciones
        List<Odontologo> odontologosTest = new ArrayList<>();
        Odontologo odontologoTest1=new Odontologo(111,"OdontoTest1","Odontito1");
        Odontologo odontologoTest2=new Odontologo(222,"OdontoTest2","Odontito2");
        Odontologo odontologoTest3=new Odontologo(333,"OdontoTest3","Odontito3");

        odontologosTest.add(odontologoTest1);
        odontologosTest.add(odontologoTest2);
        odontologosTest.add(odontologoTest3);

        System.out.println("En consola muestro la listaTest de prueba: -->> "+odontologosTest );

        //Entonces
        Assertions.assertEquals(true,odontologoTest1.getNombre()=="Odontito1");
        Assertions.assertEquals(true,odontologoTest2.getNombre()=="Odontito2");
        Assertions.assertEquals(true,odontologoTest3.getNombre()=="Odontito3");

    }
        /*@AfterEach
        void borrarLista(List<Odontologo> odontologoList){
           return;
           // odontologoList=null;
           }
         */

    @Test
    void listarTest(){

    }
}


