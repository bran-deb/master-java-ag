package ejemploPalabraFinal.palabraFinal;



public final class ClaseFinal {
    
    //final en variables se debe declarar
    public final int varNumero = 10;
    
    //constante en java
    public static final int VAR_PRIMITIVO = 15;
    
    //final en Objetos
    public static final Persona VAR_PERSONA = new Persona();
    
    //final en un metodo
    //no es posible modificar o sobreescribir el metodo
    public final void metodoFinal(){
        
    }
    
}
//no se pueden crear clases hijas de final
//class ClaseHija extends ClaseFinal{}
