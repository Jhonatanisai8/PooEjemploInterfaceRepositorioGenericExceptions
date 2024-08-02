package org.jhonatan.GenericsClass;

public class EjemploClases {
    public static void main(String[] args) {
        System.out.println("=================EJEMPLOS CON CLASES GENERICAS=================");
        ejemploCamionAnimales();
        ejemploCamionMaquinaria();
        ejemploCamnionAuto();
    }

    public static void ejemploCamionAnimales() {
        System.out.println("=========TRANSPORTE DE ANIMALES=========");
        Camion<Animal> transporteCaballos = new Camion<>(5);
        // agregamos objetos
        transporteCaballos.add(new Animal("Perigrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("TopoCalma", "Caballo"));
        transporteCaballos.add(new Animal("LongoToma", "Caballo"));
        imprimirCamion(transporteCaballos);

    }

    public static void ejemploCamionMaquinaria() {

        System.out.println("=========TRASPORTE DE CAMIONES=========");
        Camion<Maquinaria> trasporteMaquinaria = new Camion<>(3);

        trasporteMaquinaria.add(new Maquinaria("Buldozer"));
        trasporteMaquinaria.add(new Maquinaria("Grua Orquilla"));
        trasporteMaquinaria.add(new Maquinaria("Perfovadora"));
        imprimirCamion(trasporteMaquinaria);
    }

    public static void ejemploCamnionAuto() {
        System.out.println("========TRASPORTE DE AUTOMOVILES========");
        Camion<Auto> transporteAutoMoviles = new Camion<>(5);

        transporteAutoMoviles.add(new Auto("Ferrari"));
        transporteAutoMoviles.add(new Auto("Lamborguine"));
        transporteAutoMoviles.add(new Auto("Maclaren"));
        transporteAutoMoviles.add(new Auto("Pagani"));
        transporteAutoMoviles.add(new Auto("Audi"));

        imprimirCamion(transporteAutoMoviles);
    }

    // metodo generico
    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T t : camion) {
            if (t instanceof Animal) {
                System.out.println("- " + ((Animal) t).getNombre() + ", Tipo: " + ((Animal) t).getTipo());
            } else if (t instanceof Maquinaria) {
                System.out.println("- " + ((Maquinaria) t).getTipo());
            } else if (t instanceof Auto) {
                System.out.println("- " + ((Auto) t).getMarca());
            }
        }
    }
}
