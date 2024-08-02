package org.jhonatan.pooInterface.Repositori;

import java.util.ArrayList;
import java.util.List;

import org.jhonatan.pooInterface.Modelo.BaseEntity;

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
    public T porId(Integer id) {
        T c = null;
        for (T cliente : dataSource) {
            if (cliente.getId() != null && cliente.getId().equals(id)) {
                c = cliente;
                break;
            }
        }
        return c;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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
