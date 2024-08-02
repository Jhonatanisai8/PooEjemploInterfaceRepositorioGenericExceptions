package org.jhonatan.pooInterface.Repositori.Lista;

import java.util.ArrayList;
import java.util.List;

import org.jhonatan.pooInterface.Modelo.Cliente;
import org.jhonatan.pooInterface.Repositori.AbstractaListRepositorio;
import org.jhonatan.pooInterface.Repositori.Direccion;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion direccion) {
        List<Cliente> listOOrdenada = new ArrayList<>(this.dataSource);
        listOOrdenada.sort((a, b) -> {
            int result = 0;
            if (direccion == Direccion.ASC) {
                result = ordenar(campo, a, b);
            } else if (direccion == Direccion.DESD) {
                result = ordenar(campo, b, a);
            }
            return result;

        });
        return listOOrdenada;
    }

    static int ordenar(String campo, Cliente a, Cliente b) {

        int result = 0;
        switch (campo) {
            case "id":
                result = a.getId().compareTo(b.getId());
                break;
            case "nombre":
                result = a.getNombre().compareTo(b.getNombre());
                break;
            case "apellido":
                result = a.getApellido().compareTo(b.getApellido());
                break;
        }
        return result;
    }

}
