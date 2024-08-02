package org.jhonatan.pooInterface.Repositori;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion direccion);

    /*
     * default int ordenar(String campo, Cliente a, Cliente b) {
     * int result = 0;
     * switch (campo) {
     * case "id":
     * result = a.getId().compareTo(b.getId());
     * break;
     * case "nombre":
     * result = a.getNombre().compareTo(b.getNombre());
     * break;
     * case "apellido":
     * result = a.getApellido().compareTo(b.getApellido());
     * break;
     * }
     * return result;
     * }
     */
}
