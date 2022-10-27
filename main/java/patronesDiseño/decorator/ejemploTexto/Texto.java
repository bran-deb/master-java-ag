package patronesDiseño.decorator.ejemploTexto;

public class Texto implements TextoFormateable {

    private final String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String darFormato() {
        return getTexto();
    }
}
