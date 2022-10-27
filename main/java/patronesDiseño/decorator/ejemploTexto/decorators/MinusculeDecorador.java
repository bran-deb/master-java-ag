package patronesDiseño.decorator.ejemploTexto.decorators;

import patronesDiseño.decorator.ejemploTexto.TextoFormateable;

public class MinusculeDecorador extends TextoDecorador {

    public MinusculeDecorador(TextoFormateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toLowerCase();
    }
}
