package genericsClass;

public class TestGenericClass {
    public static void main(String[] args) {
        //No es list ni array, pero se puede iterar porque extiende de ITERABLE
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "caballo"));
        transporteCaballos.add(new Animal("Grillo", "caballo"));
        transporteCaballos.add(new Animal("Tuque", "caballo"));
        imprimirCamion(transporteCaballos);
//        for (Animal animal : transporteCaballos) {
//            System.out.println(animal.getNombre());
//        }

        System.out.println("===============");

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));
        imprimirCamion(transMaquinas);
//        for (Maquinaria maquinaria : transMaquinas) {
//            System.out.println(maquinaria.getTipo());
//        }
        System.out.println("===============");

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Chevi"));
        transAuto.add(new Automovil("Nissan"));
        imprimirCamion(transAuto);
//        for (Automovil automovil : transAuto) {
//            System.out.println(automovil.getMarca());
//        }
    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T carga : camion) {
            if (carga instanceof Animal) {
                System.out.println(((Animal) carga).getNombre());
            } else if (carga instanceof Maquinaria) {
                System.out.println(((Maquinaria) carga).getTipo());
            } else if (carga instanceof Automovil) {
                System.out.println(((Automovil) carga).getMarca());
            }
        }
    }
}
