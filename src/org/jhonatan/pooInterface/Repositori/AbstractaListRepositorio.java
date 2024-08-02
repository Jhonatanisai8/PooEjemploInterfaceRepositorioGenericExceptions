package org.jhonatan.pooInterface.Repositori;

import java.util.ArrayList;
import java.util.List;

import org.jhonatan.pooInterface.Modelo.BaseEntity;
import org.jhonatan.pooInterface.Repositori.exceptions.EscrituraAccesoDatoException;
import org.jhonatan.pooInterface.Repositori.exceptions.LeccturaAccesoDatoException;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrud<T> {

    protected List<T> dataSource;

    // constructor
    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LeccturaAccesoDatoException {

        if (id == null || id <= 0) {
            // llamamos a la exception
            throw new LeccturaAccesoDatoException("Id invalido debe ser mayor que 0");
        }
        T c = null;
        for (T cliente : dataSource) {
            if (cliente.getId() != null && cliente.getId().equals(id)) {
                c = cliente;
                break;
            }
        }
        if (c == null) {
            throw new LeccturaAccesoDatoException("No exite el registro con el id " + id);
        }
        return c;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {

        // si el registro es nulo
        if (t == null) {
            throw new EscrituraAccesoDatoException("error al insertar un objeto de tipo null.");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LeccturaAccesoDatoException {
        // Cliente c = ;this.porId(id)
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return this.dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

}
