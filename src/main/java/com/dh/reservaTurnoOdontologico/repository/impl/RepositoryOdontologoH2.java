package com.dh.reservaTurnoOdontologico.repository.impl;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.repository.RepositoryAdministrarDatos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositoryOdontologoH2 implements RepositoryAdministrarDatos<Odontologo> {
    private static final Logger logger = LogManager.getLogger(RepositoryOdontologoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";


    @Override
    public void crearTabla() {
        Connection connection = null;
        PreparedStatement psInsert = null;

        try {
            Class.forName ("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement sInsert = connection.createStatement();
            sInsert.execute("create table if not exists odontologos (id int auto_increment primary key,numeroMatricula int,apellido varchar(255) not null, nombre varchar(255) not null);");
            sInsert.close();

        } catch (SQLException  e) {
            logger.error("!! logger Error : Ha ocurrido un error en RepositoryOdontologoH2 crearTabla");
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Odontologo guardar(Odontologo odontologo) throws SQLException {
        logger.info("Iniciando registro log info en guardar odontologo");
        logger.debug("Registrando un nuevo odontologo : "+ odontologo.toString());

        Connection connection = null;
        PreparedStatement psInsert = null;



        try {

            Class.forName ("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //psInsert = connection.prepareStatement("INSERT INTO odontologos(id,numeroMatricula, apellido, nombre) VALUES(?,?,?,?)");
            psInsert = connection.prepareStatement("INSERT INTO odontologos(numeroMatricula, apellido, nombre) VALUES(?,?,?)");

            ResultSet rs = psInsert.getGeneratedKeys();

            //psInsert.setLong(1, odontologo.getId_Odontologo());
            psInsert.setInt(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.setString(3, odontologo.getNombre());
            if (rs.next()){
                odontologo.setId_Odontologo(rs.getLong(1));

            }else {
                throw new Exception("No se puede asignar el id a este odontologo");
            }




            psInsert.executeUpdate();
            psInsert.close();

        } catch (SQLException  e) {
            logger.error("!! logger Error : Ha ocurrido un error en RepositoryOdontologoH2 guardar");
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }
    @Override
    public Odontologo buscar(Integer numeroMatricula) {
        logger.debug("Buscando odontologo con numeroMatricula : "+numeroMatricula);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT numeroMatricula, apellido, nombre  FROM odontologos where numeroMatricula= ?");
            preparedStatement.setInt(1,numeroMatricula);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                // Forma 1
                int numerMatricula = result.getInt("numeroMatricula");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");

                odontologo = new Odontologo(numeroMatricula,apellido,nombre);
            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("!! Ha ocurrido un error en RepositoryOdontologoH2 buscar");
            logger.error(e.getMessage());
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos=new ArrayList<>();

        logger.debug("Listamos todos los odontologos: "+odontologos);

        Connection connection = null;
        Statement stmt = null;
        Odontologo odontologo = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            stmt = connection.prepareStatement("SELECT * FROM odontologos");

            ResultSet result = stmt.getResultSet();

            while (result.next()) {
                // Forma 1
                Integer numeroMatricula = result.getInt("numeroMatricula");
                String apellido = result.getString("apellido");
                String nombre = result.getString("nombre");

                odontologo = new Odontologo(numeroMatricula,apellido,nombre);
                odontologos.add(odontologo);
            }


        } catch (SQLException | ClassNotFoundException e) {
            logger.error("!! Ha ocurrido un error en RepositoryOdontologoH2 listarTodos");
            logger.error(e.getMessage());
        }

        return odontologos;

    }
}



