package com.dh.reservaTurnoOdontologico.service;

import com.dh.reservaTurnoOdontologico.model.Odontologo;
import com.dh.reservaTurnoOdontologico.repository.RepositoryAdministrarDatos;

public class ServiceOdontologo {

    private final RepositoryAdministrarDatos<Odontologo> odontologoDao;

    public ServiceOdontologo(RepositoryAdministrarDatos<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;
    }
    public Odontologo guardar(Odontologo odontologo){
        return odontologoDao.guardar(odontologo);

    }

    public  Odontologo buscar(Integer numeroMatricula){
        return odontologoDao.buscar(numeroMatricula);
    }

}
