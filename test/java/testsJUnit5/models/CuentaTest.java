package testsJUnit5.models;

import org.junit.jupiter.api.Test;
import testsJUnit5.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testCuentaPersona() {
        Cuenta cuenta = new Cuenta();
        cuenta.setPersona("Andres");
        String expected = "Andres";
        String current = cuenta.getPersona();
        assertEquals(expected, current);
    }

    @Test
    void testCuentaPersonaConstructor() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        String expected = "Andres";
        String current = cuenta.getPersona();
        assertEquals(expected, current);
        assertTrue(current.equals(expected));
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        Double expected = 1000.12345;
        BigDecimal current = cuenta.getSaldo();
        assertNotNull(current);
        assertEquals(expected, current.doubleValue());
        assertFalse(current.compareTo(BigDecimal.ZERO) < 0);
        assertTrue(current.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("Jon Doe", new BigDecimal("1000.123"));
        Cuenta cuenta2 = new Cuenta("Jon Doe", new BigDecimal("1000.123"));
//        assertNotEquals(cuenta, cuenta2);     //sin implementar el método equals compara la direccion de memoria
        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.123", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        cuenta.credit(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.123", cuenta.getSaldo().toPlainString());
    }

    // TEST EXCEPTIONS
    @Test
    void testNullPointerExceptionTest() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        Exception exception = assertThrows(NumberFormatException.class, () -> cuenta.debito(new BigDecimal("")));
        String current = exception.getMessage();
        String expected = null;
        assertEquals(expected, current);
    }

    @Test
    void testDineroInsuficienteException() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> { //lanza el exception
            cuenta.debito(new BigDecimal(1500));
        });
        String current = exception.getMessage();
        String expected = "Dinero insuficiente";
        assertEquals(expected, current);
    }

    @Test
    void testTransferencia() {
        Cuenta cuenta1 = new Cuenta("Jon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Joana Doe", new BigDecimal("1500.123"));
        Banco banco = new Banco();
        banco.setNombre("BancoSol");
        banco.transferir(cuenta1, cuenta2, new BigDecimal(500));
        assertEquals("2000", cuenta1.getSaldo().toPlainString());
        assertEquals("2000.123", cuenta2.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Jon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Joana Doe", new BigDecimal("1500.123"));
        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("BancoSol");
        banco.transferir(cuenta1, cuenta2, new BigDecimal(500));
        assertEquals("2000", cuenta1.getSaldo().toPlainString());
        assertEquals("2000.123", cuenta2.getSaldo().toPlainString());

        assertEquals(2, banco.getCuentas().size());
        assertEquals("BancoSol", cuenta1.getBanco().getNombre());

        assertEquals("Jon Doe", banco.getCuentas().stream()
                .filter(cuenta -> cuenta.getPersona().equals("Jon Doe"))
                .findFirst()
                .get().getPersona());

        assertTrue(banco.getCuentas().stream()
                .anyMatch(cuenta -> cuenta.getPersona().equals("Jon Doe")));
    }
}