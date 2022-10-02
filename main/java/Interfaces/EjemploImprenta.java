package Interfaces;

import Interfaces.modelo.*;
import static Interfaces.modelo.Imprimible.TEXTO_DEFECTO;
import static Interfaces.modelo.Genero.PROGRAMACION;


public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculo cv = new Curriculo("Resumen laboral...", new Persona("John", "Doe"), "Ing. Sistemas");
        cv.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring framework");

        Informe informe = new Informe("Estudio de microservicios", new Persona("Martin", "Fowler"), "James");

        Libro libro = new Libro(new Persona("Erich", "Gamma"), "Patrones de diseños: Elementos Reusables POO", PROGRAMACION);
        libro.addPagina(new Pagina("Patron singleton"))
                .addPagina(new Pagina("Patron Observer"))
                .addPagina(new Pagina("Patron Factory"));

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

//        imprimirAbstract(cv);
//        imprimirAbstract(informe);
        System.out.println(TEXTO_DEFECTO);
    }

    //tipo más genérico Interface
    public static void imprimir(Imprimible imprimible) {
        System.out.println(imprimible.imprimir());
    }

    public static void imprimirAbstract(Hoja imprimible) {
        System.out.println(imprimible.imprimir());
    }
}
