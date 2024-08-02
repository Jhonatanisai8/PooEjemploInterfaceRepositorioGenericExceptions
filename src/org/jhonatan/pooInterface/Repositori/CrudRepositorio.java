package org.jhonatan.pooInterface.Repositori;

import java.util.List;

import org.jhonatan.pooInterface.Repositori.exceptions.AccesoDatoException;

// clase generica <T>
public interface CrudRepositorio<T> {
    List<T> listar();

    T porId(Integer id) throws AccesoDatoException;

    void crear(T t) throws AccesoDatoException;

    void editar(T t) throws AccesoDatoException;

    void eliminar(Integer id) throws AccesoDatoException;

}
