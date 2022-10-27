package patronesDiseño.decorator.ejemploTexto.decorators;

import patronesDiseño.decorator.ejemploTexto.TextoFormateable;

public class RemplazarEspaciosDecorador extends TextoDecorador {

    public RemplazarEspaciosDecorador(TextoFormateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace("", "_");
    }
}
