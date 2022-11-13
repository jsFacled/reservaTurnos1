package com.dh.reservaTurnoOdontologico.repository.impl;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.repository.RepositoryAdministrarDatos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;


public class RepositoryOdontologoH2 implements RepositoryAdministrarDatos<Odontologo> {
    private static final Logger logger = LogManager.getLogger(RepositoryOdontologoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/db_farmacia2;";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.debug("Registrando un nuevo medicamento : "+ odontologo.toString());

        Connection connection = null;
        PreparedStatement psInsert = null;

        try {

            Class.forName ("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            psInsert = connection.prepareStatement("INSERT INTO odontologos(numeroMatricula, apellido, nombre) VALUES(?,?,?)");

            psInsert.setInt(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.setString(3, odontologo.getNombre());


            psInsert.executeUpdate();
            psInsert.close();

        } catch (SQLException  e) {
            logger.error("!! Ha ocurrido un error en RepositoryOdontologoH2 guardar");
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }
    @Override
    public Odontologo buscar(Integer numeroMatricula) {
        logger.debug("Buscando medicamento con numeroMatricula : "+numeroMatricula);

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
}



