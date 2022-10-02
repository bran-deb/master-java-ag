package Interfaces.modelo;

public interface Imprimible {
    //NO OBLIGA A IMPLEMENTARLO (FINAL Y STATIC)
    String TEXTO_DEFECTO = "Imprimir un valor por defecto";

    String imprimir();
    //NO OBLIGA A IMPLEMENTARLO
//    default String imprimirDefault(){
//        return TEXTTO_DEFECTO;
//    }

//    static void imprimir(Imprimible imprimible) {
//        System.out.println(imprimible.imprimir());
//    }
}
