package patronesDiseño.decorator.ejemploTexto.decorators;

import patronesDiseño.decorator.ejemploTexto.TextoFormateable;

public class MajusculeDecorador extends TextoDecorador {

    public MajusculeDecorador(TextoFormateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}
