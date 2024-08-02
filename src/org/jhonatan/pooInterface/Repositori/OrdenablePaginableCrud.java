package org.jhonatan.pooInterface.Repositori;

public interface OrdenablePaginableCrud<T> extends OrdenableRepositorio<T>,
        PaginableRepositorio<T>, CrudRepositorio<T>, Contable {

            
}
