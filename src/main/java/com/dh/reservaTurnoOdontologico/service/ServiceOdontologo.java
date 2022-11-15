package com.dh.reservaTurnoOdontologico.service;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.repository.RepositoryAdministrarDatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceOdontologo {

    private final RepositoryAdministrarDatos<Odontologo> odontologoDao;

    public ServiceOdontologo(RepositoryAdministrarDatos<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;
    }

    public void crearTabla(){
        odontologoDao.crearTabla();
    }
    public Odontologo guardar(Odontologo odontologo) throws SQLException {
        return odontologoDao.guardar(odontologo);

    }

    public  Odontologo buscar(Integer numeroMatricula){

        return odontologoDao.buscar(numeroMatricula);
    }

    public List<Odontologo> listarTodos (){
        List<Odontologo> odontologosDao =new ArrayList<>();
        return  odontologosDao;
    }

}
