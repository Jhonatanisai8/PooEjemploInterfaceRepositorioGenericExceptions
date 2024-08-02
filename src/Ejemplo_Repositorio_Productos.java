import java.util.List;

import org.jhonatan.pooInterface.Modelo.Producto;
import org.jhonatan.pooInterface.Repositori.Direccion;
import org.jhonatan.pooInterface.Repositori.OrdenablePaginableCrud;
import org.jhonatan.pooInterface.Repositori.Lista.ProductoListRepositorio;

public class Ejemplo_Repositorio_Productos {
    public static void main(String[] args) {
        System.out.println("==================CRUD DE PRODUCTOS==================");
        EjemploRepositorio1();
    }   
     static void EjemploRepositorio1() {

        /* Creamos el repositorio */
        OrdenablePaginableCrud<Producto> repo = new ProductoListRepositorio();

        /* agregamos personas */

        repo.crear(new Producto("Laptop HP", 768.5));
        repo.crear(new Producto("Mesa", 34.6));
        repo.crear(new Producto("Silla", 12.6));
        repo.crear(new Producto("Mueble", 56.7));
        repo.crear(new Producto("PC", 120.32));
        repo.crear(new Producto("Televisor", 800.23));
        repo.crear(new Producto("Radio", 67.4));
        repo.crear(new Producto("Antena", 12.0));
        repo.crear(new Producto("Bicicleta", 120.45));
        repo.crear(new Producto("Mochila",50.9 ));
        System.out.println();

        /* Listamos */
        System.out.println("=============LISTAMOS LOS PRODUCTOS=============\n");
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        int desde = 0, hasta = 5;
        System.out.println("=============PAGINABLE DESDE EL " + desde + " HASTA EL " + hasta + "============= \n");
        List<Producto> paginable = repo.listar(desde, hasta);
        paginable.forEach(System.out::println);
        System.out.println();

        /* Ordenamos */
        String campo = "precio";
        Direccion direcion = Direccion.ASC;
        System.out.println("=============ORDENANADO POR " + campo + " en forma " + direcion + " =============\n");
        List<Producto> productos2ordenable = repo.listar(campo, direcion);
        for (Producto cliente : productos2ordenable) {
            System.out.println(cliente);
        }

        System.out.println();

        /* Editando */
        System.out.println("=============EDITANDO=============\n");
        int idEditar = 3;
        Producto productoMuebleActualizar = new Producto("Muele de cuero", 80.6);
        System.out.println("Editando el producto con id: " + idEditar);
        productoMuebleActualizar.setId(idEditar);
        repo.editar(productoMuebleActualizar);
        System.out.println();

        /* Mostramos de nuevo la lista */
        System.out.println("=============MOSTRANDO LA LISTA ACTUALIZADA=============\n");
        repo.listar("id", Direccion.ASC).forEach(System.out::println);

        System.out.println();
        System.out.println("=============BUSCANDO UN REGISTRO=============\n");
        int id = 5;
        System.out.println("Buscando el producto con id: " + id);
        Producto productoBuscar = repo.porId(id);
        if (productoBuscar != null) {
            System.out.println(productoBuscar);

        } else {
            System.out.println("Registro con id no encontrado.");
        }
        System.out.println();

        /* Eliminando */
        System.out.println("=============ELIMINAR=============");
        int idEliminar = 2;
        System.out.println("Eliminando el producto con id: " + idEliminar);
        repo.eliminar(idEliminar);
        System.out.println();

        System.out.println("============= LISTANDO =============\n");
        repo.listar().forEach(System.out::println);
        System.out.println();

        System.out.println("=============TOTAL DE REGISTROS=============");
        System.out.println(repo.total());

    } 
}
