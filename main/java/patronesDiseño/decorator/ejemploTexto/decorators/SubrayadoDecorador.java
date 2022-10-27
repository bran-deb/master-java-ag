package patronesDiseño.decorator.ejemploTexto.decorators;

import patronesDiseño.decorator.ejemploTexto.TextoFormateable;

public class SubrayadoDecorador extends TextoDecorador {

    public SubrayadoDecorador(TextoFormateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        int largo = texto.darFormato().length();
        StringBuilder sb = new StringBuilder(texto.darFormato());
        sb.append("\n");
        sb.append("_".repeat(largo));
//        for (int i = 0; i < largo; i++) {
//            sb.append("_");
//        }
        return sb.toString();
    }
}
