package patronesDiseño.composite;

public class TestComposite {
    public static void main(String[] args) {

        Directorio dirJava = new Directorio("Java");
        dirJava.addComponente(new Archivo("patron-composite.docx"));

        Directorio dirStream = new Directorio("Stream");
        dirStream.addComponente(new Archivo("stream-map.docx"));
        dirJava.addComponente(dirStream);

        Directorio dirDocs = new Directorio("Documentos");
        dirDocs.addComponente(new Archivo("cv.docx"));
        dirDocs.addComponente(new Archivo("logo.jpeg"));
        dirDocs.addComponente(dirJava);
        System.out.println("=====Mostrar directorio:=====\n" + dirDocs.mostrar(0));

        System.out.println("=====Eliminar directorio:=====\n" + dirStream.mostrar());
        dirJava.removeComponente(dirStream);
        System.out.println("=====Mostrar directorio:=====\n" + dirDocs.mostrar(0));

        boolean encontrado = dirDocs.buscar("patron-composite.docx");
        System.out.println("encontrado = " + encontrado);

    }
}
