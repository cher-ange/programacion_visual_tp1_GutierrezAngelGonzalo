package ar.edu.unju.fi.ejercicio7.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Employee;

/**
 * 7. Uso de constructor de clase - métodos - constantes - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Employee employee;
        final String name;
        final int personalFile;
        final double salary;

        try (scanner) {
            System.out.println("Ingreso de datos del empleado");

            name = getString("Ingrese el nombre");
            personalFile = getInteger("Ingrese el número de legajo");
            salary = getDouble("Ingrese el salario a percibir");

            employee = new Employee(name, personalFile, salary);

            employee.showInformation();
            employee.increaseSalary();
            employee.showInformation();
        } catch (InputMismatchException e) {
            errorMessage("Ocurrió un error durante la ejecución del programa");
        }
    }

    public static String getString(final String message) {
        inputMessage(message);
        return scanner.nextLine();
    }

    public static int getInteger(final String message) {
        int integerValue;

        while (true) {
            inputMessage(message);
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static double getDouble(final String message) {
        double doubleValue;

        while (true) {
            inputMessage(message);
            try {
                doubleValue = Double.parseDouble(scanner.nextLine());
                return doubleValue;
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número");
            }
        }
    }

    public static void inputMessage(String message) {
        System.out.print(message + ": ");
    }

    public static void errorMessage(String message) {
        System.out.println("ERROR: " + message);
    }
}
