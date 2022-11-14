package com.dh.reservaTurnoOdontologico.aplication;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.repository.impl.RepositoryOdontologoH2;
import com.dh.reservaTurnoOdontologico.service.ServiceOdontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        logger.info("---- iniciando prueba de Odontologo Class ----");

        //Agrego odonto
        List<Odontologo> odontologosPrueba=new ArrayList<>();
       Odontologo odonto1 = new Odontologo(278,"Perez", "jose");
        Odontologo odonto2 = new Odontologo(322,"Rodriguez", "moni");
        Odontologo odonto3 = new Odontologo(897,"Almeida", "pedro");
        Odontologo odonto4 = new Odontologo(111222,"Perez", "Romualdo" );

        System.out.println("Vemos a  odonto4: "+odonto4);


        System.out.println("---------------------agrego odontologos en odontologosPrueba----------------------");
        logger.info("---------- Agrego odontologos en odontologosPrueba --------");

        odontologosPrueba.add(odonto1);
        odontologosPrueba.add(odonto2);
        odontologosPrueba.add(odonto3);

        System.out.println("Muestro lista:  "+odontologosPrueba);
        logger.info("=============  fin prueba Odontologos class  =========");

// ------------------------------------  prueba main  -----------------------------------

        System.out.println("-----------             --------------");
        System.out.println("----------- prueba main --------------");
        System.out.println("-----------             --------------");

        logger.info("===== iniciando prueba Main =====");

        ServiceOdontologo serviceOdontologo = new ServiceOdontologo(new RepositoryOdontologoH2());

        Odontologo odontologo = new Odontologo(574, "Pereira", "Roberto");
        // Guardar en h2
        serviceOdontologo.guardar(odontologo);
        serviceOdontologo.guardar(odonto1);
        serviceOdontologo.guardar(odonto2);
        serviceOdontologo.guardar(odonto3);

        // Buscar desde h2
        Odontologo odontobuscado1 = serviceOdontologo.buscar(2);
        // Detalle
        System.out.println("Detallamos a odontoCreado1" + odontobuscado1);
        //ListarTodos
        System.out.println("Vemos la lista: "+ serviceOdontologo.listarTodos());









        //  ---------------  finMain ---------------------
    }
}
