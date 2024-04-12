package ar.edu.unju.fi.ejercicio8.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.SpecialCalculator;

/**
 * 8. Uso de constructor de clase - métodos - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpecialCalculator specialCalculator = new SpecialCalculator();

        try (scanner) {
            specialCalculator.setNumber(getInteger("Ingrese el límite superior n"));
            System.out.println("Cálculo Sumatoria: " + specialCalculator.calculateSummation());
            System.out.println("Cálculo Productoria: " + specialCalculator.calculateProduct());
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int getInteger(final String message) {
        int integerValue;

        while (true) {
            System.out.print(message + ": ");
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        }
    }
}
