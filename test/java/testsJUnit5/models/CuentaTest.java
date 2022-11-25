package testsJUnit5.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testsJUnit5.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMethodTest() {
        System.out.println("Iniciando el método");
        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando método de prueba");
    }

    @Test
    @DisplayName("Test el nombre de la cuenta corriente")
    void testCuentaPersona() {
        cuenta = new Cuenta();
        cuenta.setPersona("Andres");
        String expected = "Andres";
        String current = cuenta.getPersona();
        assertEquals(expected, current, () -> "El nombre de la cuenta no es la esperada");
    }

    @Test
    @DisplayName("Test nombre de la cuenta corriente con parametros")
    void testCuentaPersonaConstructor() {
        String expected = "Andres";
        String current = cuenta.getPersona();
        assertEquals(expected, current, () -> "El nombre de la cuenta no es la esperada");
        assertTrue(current.equals(expected), () -> "El nombre de la cuenta no es la esperada");
    }

    @Test
    @DisplayName("Test saldo de la cuenta no null y mayor a cero")
    void testSaldoCuenta() {
        Double expected = 1000.123;
        BigDecimal current = cuenta.getSaldo();
        assertNotNull(current, () -> "La cuenta no puede ser nula");
        assertEquals(expected, current.doubleValue(), () -> "El saldo de la cuenta no es el esperado");
        assertFalse(current.compareTo(BigDecimal.ZERO) < 0);
        assertTrue(current.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Test igualdad de dos cuentas")
    void testReferenciaCuenta() {
        cuenta = new Cuenta("Jon Doe", new BigDecimal("1000.123"));
        Cuenta cuenta2 = new Cuenta("Jon Doe", new BigDecimal("1000.123"));
//        assertNotEquals(cuenta, cuenta2);     //sin implementar el método equals compara la direccion de memoria
        assertEquals(cuenta, cuenta2, () -> "las cuentas no son iguales");
    }

    @Test
    @DisplayName("Test transferencia negativa de saldo entre cuentas")
    void testDebitoCuenta() {
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo(), () -> "La cuenta no puede ser nula");
        assertEquals(900, cuenta.getSaldo().intValue(), () -> "El saldo de la cuenta no es el esperado");
        assertEquals("900.123", cuenta.getSaldo().toPlainString(), () -> "El saldo de la cuenta no es el esperado");
    }

    @Test
    @DisplayName("Test tranferencia positiva de saldo entre cuentas")
    void testCreditCuenta() {
        cuenta.credit(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue(), () -> "El saldo de la cuenta no es el esperado");
        assertEquals("1100.123", cuenta.getSaldo().toPlainString(), () -> "El saldo de la cuenta no es el esperado");
    }

    // TEST EXCEPTIONS
    @Test
    @DisplayName("Test de las excepciones NumberFormatException")
    void testNullPointerException() {
        Exception exception = assertThrows(NumberFormatException.class, () -> cuenta.debito(new BigDecimal("")));
        String current = exception.getMessage();
        assertEquals(null, current, () -> "No es a Exception esperada");
        assertNull(current, () -> "No es la Exception esperada");
    }

    @Test
    @DisplayName("Test de las excepciones personalizadas DineroInsuficienteException")
    void testDineroInsuficienteException() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> { //lanza el exception
            cuenta.debito(new BigDecimal(1500));
        });
        String current = exception.getMessage();
        String expected = "Dinero insuficiente";
        assertEquals(expected, current);
    }

    @Test
    @DisplayName("Test method Banco, transferencia entre cuentas")
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
//    @Disabled
    @DisplayName("Test relation de Banco y Cuentas con assertAll")
    void testRelacionBancoCuentas() {
//        fail(); //Falla el test
        Cuenta cuenta1 = new Cuenta("Jon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Joana Doe", new BigDecimal("1500.123"));
        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("BancoSol");
        banco.transferir(cuenta1, cuenta2, new BigDecimal(500));
        assertAll(
                () -> assertEquals("2000", cuenta1.getSaldo().toPlainString(), () -> "El saldo no es el esperado"),
                () -> assertEquals("2000.123", cuenta2.getSaldo().toPlainString(), () -> "El saldo no es el esperado"),
                () -> assertEquals(2, banco.getCuentas().size(), () -> "El numero de cuentas no es el esperado"),
                () -> assertEquals("BancoSol", cuenta1.getBanco().getNombre(), () -> "El nombre del banco no es el esperado"),
                () -> {
                    assertEquals("Jon Doe", banco.getCuentas().stream()
                            .filter(cuenta -> cuenta.getPersona().equals("Jon Doe"))
                            .findFirst()
                            .get().getPersona(), () -> "El nombre de la lista de cuentas no es el esperado");
                },
                () -> {
                    assertTrue(banco.getCuentas().stream()
                            .anyMatch(cuenta -> cuenta.getPersona()
                                    .equals("Jon Doe")), () -> "El nombre de la lista de cuentas no es el esperado");
                }
        );
    }
}