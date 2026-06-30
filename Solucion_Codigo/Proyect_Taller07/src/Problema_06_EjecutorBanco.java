/**
 * Problema 06: Sistema Un Banco
 * El banco administra diferentes tipos de cuentas: Cuenta de Cheques,
 * Cuenta de Ahorros y Cuenta Platino. Cada una tiene reglas distintas para
 * retiros, depósitos y cálculo de intereses.
 * @author Jhosue Armijos
 * @version 1.0
 */

class CuentaBancaria {
    public String numeroCuenta;
    public String nombreCliente;
    public double balance;

    public CuentaBancaria(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
        }
    }

    public boolean retirar(double cantidad) {
        return false;
    }

    public double obtenerBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", balance=$" + String.format("%.2f", balance) +
                '}';
    }
}

class CuentaCheques extends CuentaBancaria {

    public CuentaCheques(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0) {
            balance -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CuentaCheques{} " + super.toString();
    }
}

class CuentaAhorros extends CuentaBancaria {
    public double tasaInteres;

    public CuentaAhorros(String numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= balance) {
            balance -= cantidad;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        if (balance > 0) {
            double interes = balance * (tasaInteres / 100);
            balance += interes;
        }
    }

    @Override
    public String toString() {
        return "CuentaAhorros{tasaInteres=" + tasaInteres + "%} " + super.toString();
    }
}

class CuentaPlatino extends CuentaBancaria {
    public final double TASA_INTERES = 10.0;

    public CuentaPlatino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0) {
            balance -= cantidad;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        if (balance > 0) {
            double interes = balance * (TASA_INTERES / 100);
            balance += interes;
        }
    }

    @Override
    public String toString() {
        return "CuentaPlatino{tasaInteres=" + TASA_INTERES + "%} " + super.toString();
    }
}

public class Problema_06_EjecutorBanco {
    public static void main(String[] args) {
        CuentaBancaria[] cuentas = new CuentaBancaria[3];

        cuentas[0] = new CuentaCheques("CH-001", "Alexi Yauri");
        cuentas[0].depositar(800.00);
        cuentas[0].retirar(950.00);

        cuentas[1] = new CuentaAhorros("AH-002", "Jhosue Armijos", 4.5);
        cuentas[1].depositar(1200.00);
        cuentas[1].retirar(300.00);
        ((CuentaAhorros) cuentas[1]).calcularInteres();

        cuentas[2] = new CuentaPlatino("PL-003", "Jhonathan Alvarez");
        cuentas[2].depositar(2500.00);
        cuentas[2].retirar(3000.00);
        ((CuentaPlatino) cuentas[2]).calcularInteres();

        System.out.println("=== ESTADO DE CUENTAS - UN BANCO ===");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(cuenta);
            System.out.println("------------------------------------");
        }
    }
}

/*run: 
=== ESTADO DE CUENTAS - UN BANCO ===
CuentaCheques{} CuentaBancaria{numeroCuenta='CH-001', nombreCliente='Alexi Yauri', balance=$-150.00}
------------------------------------
CuentaAhorros{tasaInteres=4.5%} CuentaBancaria{numeroCuenta='AH-002', nombreCliente='Jhosue Armijos', balance=$940.50}
------------------------------------
CuentaPlatino{tasaInteres=10.0%} CuentaBancaria{numeroCuenta='PL-003', nombreCliente='Jhonathan Alvarez', balance=$-500.00}
------------------------------------
BUILD SUCCESSFUL (total time: 5 seconds)
*/