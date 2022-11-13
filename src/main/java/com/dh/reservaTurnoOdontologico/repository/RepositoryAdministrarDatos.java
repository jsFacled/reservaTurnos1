package com.dh.reservaTurnoOdontologico.repository;

public interface RepositoryAdministrarDatos<T> {
    T guardar(T t);
    T buscar(Integer numeroMatricula);

}
