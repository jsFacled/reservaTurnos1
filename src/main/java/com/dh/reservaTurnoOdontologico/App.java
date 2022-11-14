package com.dh.reservaTurnoOdontologico;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.repository.impl.RepositoryOdontologoH2;
import com.dh.reservaTurnoOdontologico.service.ServiceOdontologo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        //Agrego odonto
        List<Odontologo> odontologos=new ArrayList<>();
       Odontologo odonto1 = new Odontologo(278,"Perez", "jose");
        Odontologo odonto2 = new Odontologo(322,"Rodriguez", "moni");
        Odontologo odonto3 = new Odontologo(897,"Almeida", "pedro");
        Odontologo odonto4 = new Odontologo(111222,"Perez", "Romualdo" );

        System.out.println("Vemos a  odonto4: "+odonto4);


        System.out.println("---------------------agrego odontologos ----------------------");
        odontologos.add(odonto1);
        odontologos.add(odonto2);
        odontologos.add(odonto3);

        System.out.println("Muestro lista:  "+odontologos);

// ------------------------------------  prueba main  -----------------------------------

        System.out.println("-----------             --------------");
        System.out.println("----------- prueba main --------------");
        System.out.println("-----------             --------------");


        ServiceOdontologo serviceOdontologo = new ServiceOdontologo(new RepositoryOdontologoH2());

        Odontologo odontologo = new Odontologo(574, "Pereira", "Roberto");
        // Guardar
        serviceOdontologo.guardar(odontologo);
        serviceOdontologo.guardar(odonto1);
        serviceOdontologo.guardar(odonto2);
        serviceOdontologo.guardar(odonto3);

        // Buscar
        Odontologo odontobuscado1 = serviceOdontologo.buscar(2);
        // Detalle
        System.out.println("Detallamos a dodonteCreado1" + odontobuscado1);
        //ListarTodos
        System.out.println("Vemos la lista: "+ serviceOdontologo.listarTodos());









        //  ---------------  finMain ---------------------
    }
}
