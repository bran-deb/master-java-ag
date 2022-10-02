package SobrecargaMetodos;

public class Operaciones {
    public static int sumar(int a, int b){
        System.out.println("suma (int, int)");
        return a + b;
    }
    
    public static double sumar(double a, double b){
        System.out.println("suma (double, double)");
        return a + b;
    }
    
    public static double sumar(int a, double b){
        System.out.println("suma(int, double)");
        return a + b;
    }
    
    public static double sumar(double a, int b){
        System.out.println("suma(double, int)");
        return a + b;
    }
}
