import java.util.List;

import org.jhonatan.pooInterface.Modelo.Cliente;
import org.jhonatan.pooInterface.Repositori.Direccion;
import org.jhonatan.pooInterface.Repositori.OrdenablePaginableCrud;
import org.jhonatan.pooInterface.Repositori.Lista.ClienteListRepositorio;
import org.jhonatan.pooInterface.Repositori.exceptions.AccesoDatoException;
import org.jhonatan.pooInterface.Repositori.exceptions.EscrituraAccesoDatoException;
import org.jhonatan.pooInterface.Repositori.exceptions.LeccturaAccesoDatoException;

public class EjemploRepositorio {
    public static void main(String[] args) throws Exception {
        EjemploRepositorio.EjemploRepositorio1();
    }

    static void EjemploRepositorio1() {

        try {
            /* Creamos el repositorio */
            OrdenablePaginableCrud<Cliente> repo = new ClienteListRepositorio();

            /* agregamos personas */

            repo.crear(new Cliente("María", "Garcia"));
            repo.crear(new Cliente("Juan", "Martinez"));
            repo.crear(new Cliente("Ana", "Rodrigues"));
            repo.crear(new Cliente("Luis", "Fernández"));
            repo.crear(new Cliente("Carmen", "Lopez"));
            repo.crear(new Cliente("Jose", "Perez"));
            repo.crear(new Cliente("Laura", "Gonzales"));
            repo.crear(new Cliente("Antonio", "Sanchez"));
            repo.crear(new Cliente("Martha", "Gomez"));
            repo.crear(new Cliente("David", "Diaz"));

            repo.crear(null);

            System.out.println();

            /* Listamos */
            System.out.println("=============LISTAMOS LOS CLLIENTES=============\n");
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);

            int desde = 0, hasta = 5;
            System.out.println("=============PAGINABLE DESDE EL " + desde + " HASTA EL " + hasta + "============= \n");
            List<Cliente> paginable = repo.listar(desde, hasta);
            paginable.forEach(System.out::println);
            System.out.println();

            /* Ordenamos */
            String campo = "apellido";
            Direccion direcion = Direccion.ASC;
            System.out.println("=============ORDENANADO POR " + campo + " en forma " + direcion + " =============\n");
            List<Cliente> clientesOrdenable = repo.listar(campo, direcion);
            for (Cliente cliente : clientesOrdenable) {
                System.out.println(cliente);
            }

            System.out.println();

            /* Editando */
            System.out.println("=============EDITANDO=============\n");
            int idEditar = 3;
            Cliente anaActualizar = new Cliente("Ana", "Marquez");
            System.out.println("Editando el cliente con id: " + idEditar);
            anaActualizar.setId(idEditar);
            repo.editar(anaActualizar);
            System.out.println();

            /* Mostramos de nuevo la lista */
            System.out.println("=============MOSTRANDO LA LISTA ACTUALIZADA=============\n");
            repo.listar("id", Direccion.ASC).forEach(System.out::println);

            System.out.println();
            System.out.println("=============BUSCANDO UN REGISTRO=============\n");
            int id = 34;
            System.out.println("Buscando el cliente con id: " + id);
            Cliente cienteBuscar = repo.porId(id);
            System.out.println(cienteBuscar);
            System.out.println();

            /* Eliminando */
            System.out.println("=============ELIMINAR=============");
            int idEliminar = 2;
            repo.eliminar(idEliminar);
            System.out.println("Eliminando el cliente con id: " + idEliminar);
            System.out.println();

            System.out.println("============= LISTANDO =============\n");
            repo.listar().forEach(System.out::println);
            System.out.println();

            System.out.println("=============TOTAL DE REGISTROS=============");
            System.out.println(repo.total());

        } catch (LeccturaAccesoDatoException e) {
            System.out.println("Error  de lectura: " + e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException ex) {
            System.out.println("Error de generica: " + ex.getMessage());
            ex.printStackTrace();
        } catch (AccesoDatoException ex1) {
            System.out.println("Error de generica: " + ex1.getMessage());
            ex1.printStackTrace();
        }
    }
}
