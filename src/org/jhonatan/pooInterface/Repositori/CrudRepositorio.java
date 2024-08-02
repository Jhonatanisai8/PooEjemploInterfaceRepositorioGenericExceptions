package org.jhonatan.pooInterface.Repositori;

import java.util.List;

import org.jhonatan.pooInterface.Repositori.exceptions.AccesoDatoException;
import org.jhonatan.pooInterface.Repositori.exceptions.LeccturaAccesoDatoException;

// clase generica <T>
public interface CrudRepositorio<T> {
    List<T> listar();

    T porId(Integer id) throws AccesoDatoException;

    void crear(T t);

    void editar(T t) throws LeccturaAccesoDatoException;

    void eliminar(Integer id) throws AccesoDatoException;

}
