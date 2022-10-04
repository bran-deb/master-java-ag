package excepciones;

import javax.swing.*;

public class testExceptions {
    public static void main(String[] args) throws DivisionPorZeroException {

        Calculadora calculadora = new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese un numerador");
        String denominador = JOptionPane.showInputDialog("Ingrese un denominador");

        try {
            double division2 = calculadora.dividir(numerador, denominador);
            System.out.println("division2 = " + division2);
        } catch (FormatoNumeroException | DivisionPorZeroException e) {
            e.printStackTrace();
            //throw new DivisionPorZeroException("No se puede dividir entre cero",e);
        } finally {
            System.out.println("se ejecuta siempre ejem: para cerrar la DB");
        }

        System.out.println("continuamos con el programa");
    }
}
