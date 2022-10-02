package SobrecargaMetodos;

public class SobrecargaMetodos {
    public static void main(String[] args) {
        System.out.println("resultado 1 = " + Operaciones.sumar(3, 4));
    
        System.out.println("resultado 2 = " + Operaciones.sumar(2.0, 4));
    
        System.out.println("resultado 3 = " + Operaciones.sumar(2.0, 5.0));
        
        System.out.println("resultado 4 = " + Operaciones.sumar(4, 2.0));
        
        System.out.println("resultado 5 = " + Operaciones.sumar(3F, 'A'));
    }
}
