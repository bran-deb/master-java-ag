package patronesDiseño.decorator.ejemploTexto.decorators;

import patronesDiseño.decorator.ejemploTexto.TextoFormateable;

public class ReversaDecorador extends TextoDecorador {

    public ReversaDecorador(TextoFormateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder sb = new StringBuilder(texto.darFormato());
        return sb.reverse().toString();
    }
}
