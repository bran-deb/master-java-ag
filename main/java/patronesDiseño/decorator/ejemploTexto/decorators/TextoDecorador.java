package patronesDiseño.decorator.ejemploTexto.decorators;

import patronesDiseño.decorator.ejemploTexto.TextoFormateable;
//DECORADOR
public abstract class TextoDecorador implements TextoFormateable {

    protected TextoFormateable texto;

    public TextoDecorador(TextoFormateable texto) {
        this.texto = texto;
    }
}
