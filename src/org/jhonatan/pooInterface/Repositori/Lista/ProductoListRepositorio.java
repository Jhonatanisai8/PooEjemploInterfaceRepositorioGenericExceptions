package org.jhonatan.pooInterface.Repositori.Lista;

import java.util.ArrayList;
import java.util.List;

import org.jhonatan.pooInterface.Modelo.Producto;
import org.jhonatan.pooInterface.Repositori.AbstractaListRepositorio;
import org.jhonatan.pooInterface.Repositori.Direccion;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {

    @Override
    public List<Producto> listar(String campo, Direccion direccion) {
           List<Producto> listOOrdenada = new ArrayList<>(this.dataSource);
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

    @Override
    public void editar(Producto p) {
        Producto prod = porId(p.getId());
        prod.setDescripcion(p.getDescripcion());
        prod.setPrecio(p.getPrecio());
    }

     static int ordenar(String campo, Producto a, Producto b) {

        int result = 0;
        switch (campo) {
            case "id":
                result = a.getId().compareTo(b.getId());
                break;
            case "descripcion":
                result = a.getDescripcion().compareTo(b.getDescripcion());
                break;
            case "precio":
                result = a.getPrecio().compareTo(b.getPrecio());
                break;
        }
        return result;
    }

}
