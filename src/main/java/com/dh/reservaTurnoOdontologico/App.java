package com.dh.reservaTurnoOdontologico;

import com.dh.reservaTurnoOdontologico.model.Odontologo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //Agrego odonto
        List<Odontologo> odontologos=new ArrayList<>();
       Odontologo odonto1 = new Odontologo(278,"Perez", "jose");
        Odontologo odonto2 = new Odontologo(022,"Rodriguez", "moni");
        Odontologo odonto3 = new Odontologo(897,"Almeida", "pedro");
        Odontologo odonto4 = new Odontologo(111222,"Perez", "Romualdo" );

        System.out.println("Vemos a  odonto4: "+odonto4);


        System.out.println("---------------------agrego odontologos ----------------------");
        odontologos.add(odonto1);
        odontologos.add(odonto2);
        odontologos.add(odonto3);

        System.out.println("Muestro lista:  "+odontologos);











        //  ---------------  finMain ---------------------
    }
}
