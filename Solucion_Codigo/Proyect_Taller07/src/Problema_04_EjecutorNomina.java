/**
 * Problema 04: Sistema de nómina para trabajadores de una empresa
 * Existen diferentes tipos de trabajadores: Fijos Mensuales, Comisionistas,
 * Por Horas y Jefes. Todos tienen datos personales y cada uno calcula su sueldo
 * de forma distinta. Cada trabajador tiene un jefe, excepto los jefes.
 * @author Jhosue Armijos
 * @version 1.0
 */

class Trabajador {
    public String nombre;
    public String apellidos;
    public String direccion;
    public String dni;
    public Trabajador jefe;

    public Trabajador(String nombre, String apellidos, String direccion, String dni, Trabajador jefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }

    public double calcularSueldo() {
        return 0.0;
    }

    @Override
    public String toString() {
        String jefeInfo = (jefe != null) ? jefe.nombre + " " + jefe.apellidos : "Sin jefe";
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", jefe=" + jefeInfo +
                '}';
    }
}

class FijoMensual extends Trabajador {
    public double sueldoMensual;

    public FijoMensual(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double sueldoMensual) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return "FijoMensual{" +
                "sueldoMensual=" + sueldoMensual +
                "} " + super.toString();
    }
}

class Comisionista extends Trabajador {
    public double ventasRealizadas;
    public double porcentajeComision;

    public Comisionista(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double porcentajeComision) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.porcentajeComision = porcentajeComision;
        this.ventasRealizadas = 0.0;
    }

    public void registrarVentas(double monto) {
        this.ventasRealizadas += monto;
    }

    @Override
    public double calcularSueldo() {
        return ventasRealizadas * (porcentajeComision / 100);
    }

    @Override
    public String toString() {
        return "Comisionista{" +
                "ventasRealizadas=" + ventasRealizadas +
                ", porcentajeComision=" + porcentajeComision +
                "} " + super.toString();
    }
}

class PorHoras extends Trabajador {
    public int horasTrabajadas;
    public final int LIMITE_HORAS = 40;
    public double precioHoraNormal;
    public double precioHoraExtra;

    public PorHoras(String nombre, String apellidos, String direccion, String dni, Trabajador jefe, double precioHoraNormal, double precioHoraExtra) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.precioHoraNormal = precioHoraNormal;
        this.precioHoraExtra = precioHoraExtra;
        this.horasTrabajadas = 0;
    }

    public void registrarHoras(int cantidad) {
        this.horasTrabajadas += cantidad;
    }

    @Override
    public double calcularSueldo() {
        if (horasTrabajadas <= LIMITE_HORAS) {
            return horasTrabajadas * precioHoraNormal;
        } else {
            int horasExtras = horasTrabajadas - LIMITE_HORAS;
            return (LIMITE_HORAS * precioHoraNormal) + (horasExtras * precioHoraExtra);
        }
    }

    @Override
    public String toString() {
        return "PorHoras{" +
                "horasTrabajadas=" + horasTrabajadas +
                ", precioHoraNormal=" + precioHoraNormal +
                ", precioHoraExtra=" + precioHoraExtra +
                "} " + super.toString();
    }
}

class Jefe extends Trabajador {
    public double sueldoFijo;

    public Jefe(String nombre, String apellidos, String direccion, String dni, double sueldoFijo) {
        super(nombre, apellidos, direccion, dni, null);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularSueldo() {
        return sueldoFijo;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "sueldoFijo=" + sueldoFijo +
                "} " + super.toString();
    }
}

public class Problema_04_EjecutorNomina {
    public static void main(String[] args) {
        Jefe jefeGeneral = new Jefe("Carlos", "Mendoza", "Av. Central 123", "11023456", 1500.00);
        FijoMensual empleadoAdmin = new FijoMensual("Ana", "Ruiz", "Calle Norte 45", "12034567", jefeGeneral, 950.00);
        Comisionista vendedor = new Comisionista("Luis", "Torres", "Calle Sur 78", "13045678", jefeGeneral, 8.0);
        vendedor.registrarVentas(3200.00);
        PorHoras operario = new PorHoras("Pedro", "Jimenez", "Pasaje Los Olivos 10", "14056789", jefeGeneral, 12.0, 18.0);
        operario.registrarHoras(48);
        System.out.println("=== DATOS Y NOMINA DEL MES ===");
        System.out.println(jefeGeneral);
        System.out.printf("Sueldo a pagar: $%.2f%n%n", jefeGeneral.calcularSueldo());

        System.out.println(empleadoAdmin);
        System.out.printf("Sueldo a pagar: $%.2f%n%n", empleadoAdmin.calcularSueldo());

        System.out.println(vendedor);
        System.out.printf("Sueldo a pagar: $%.2f%n%n", vendedor.calcularSueldo());

        System.out.println(operario);
        System.out.printf("Sueldo a pagar: $%.2f%n", operario.calcularSueldo());
    }
}

/*run:
=== DATOS Y NOMINA DEL MES ===
Jefe{sueldoFijo=1500.0} Trabajador{nombre='Carlos', apellidos='Mendoza', dni='11023456', jefe=Sin jefe}
Sueldo a pagar: $1500.00

FijoMensual{sueldoMensual=950.0} Trabajador{nombre='Ana', apellidos='Ruiz', dni='12034567', jefe=Carlos Mendoza}
Sueldo a pagar: $950.00

Comisionista{ventasRealizadas=3200.0, porcentajeComision=8.0} Trabajador{nombre='Luis', apellidos='Torres', dni='13045678', jefe=Carlos Mendoza}
Sueldo a pagar: $256.00

PorHoras{horasTrabajadas=48, precioHoraNormal=12.0, precioHoraExtra=18.0} Trabajador{nombre='Pedro', apellidos='Jimenez', dni='14056789', jefe=Carlos Mendoza}
Sueldo a pagar: $624.00
BUILD SUCCESSFUL (total time: 5 seconds)
*/