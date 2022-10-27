package patronesDiseño.decorator.ejemploTexto;

import patronesDiseño.decorator.ejemploTexto.decorators.MajusculeDecorador;
import patronesDiseño.decorator.ejemploTexto.decorators.MinusculeDecorador;
import patronesDiseño.decorator.ejemploTexto.decorators.ReversaDecorador;

public class DecoradorTest {
    public static void main(String[] args) {
        //PATRON ESTRUCTURAL
        //AGREGA FUNCIONALIDAD DINÁMICA AL OBJETO
        //Texto texto = new Texto("Hola que tal Andres");
        TextoFormateable texto = new Texto("Hola que tal Andres");
        System.out.println("texto = " + texto.darFormato());

        //MajusculeDecorador textoMajuscule = new MajusculeDecorador(texto);
        TextoFormateable textoMajuscule = new MajusculeDecorador(texto);
        System.out.println("textoMajuscule = " + textoMajuscule.darFormato());

        //ReversaDecorador textoReversa = new ReversaDecorador(textoMajuscule);
        TextoFormateable textoReversa = new ReversaDecorador(textoMajuscule);
        System.out.println("textoReversa = " + textoReversa.darFormato());

        //MinusculeDecorador textoMinuscule = new MinusculeDecorador(textoReversa);
        TextoFormateable textoMinuscule = new MinusculeDecorador(textoReversa);
        System.out.println("textoMinuscule = " + textoMinuscule.darFormato());
    }
}
