package ar.edu.unju.fi.ejercicio7.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

/**
 * 7. Uso de constructor de clase - métodos - constantes - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Empleado empleado;
        final String nombre;
        final int legajo;
        final double salario;

        try (scanner) {
            System.out.println("Ingreso de datos del empleado");

            nombre = ingresarNombre("Ingrese el nombre");
            legajo = ingresarLegajo("Ingrese el número de legajo");
            salario = ingresarSalario("Ingrese el salario a percibir");

            empleado = new Empleado(nombre, legajo, salario);

            empleado.mostrarInformacionDelEmpleado();
            empleado.incrementarSalario();
            empleado.mostrarInformacionDelEmpleado();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static String ingresarNombre(final String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public static int ingresarLegajo(final String mensaje) {
        final int legajo;

        System.out.print(mensaje + ": ");
        legajo = scanner.nextInt();
        scanner.nextLine();

        return legajo;
    }

    public static double ingresarSalario(final String mensaje) {
        final double salario;

        System.out.print(mensaje + ": ");
        salario = scanner.nextDouble();
        scanner.nextLine();

        return salario;
    }
}
