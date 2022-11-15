package com.dh.reservaTurnoOdontologico.repository;

import com.dh.reservaTurnoOdontologico.model.Odontologo;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryAdministrarDatos<T> {
    void crearTabla();
    T guardar(T t) throws SQLException;
    T buscar(Integer numeroMatricula);
    List<T> listarTodos();


}
