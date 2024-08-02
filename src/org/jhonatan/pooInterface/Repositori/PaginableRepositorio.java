package org.jhonatan.pooInterface.Repositori;

import java.util.List;


public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
