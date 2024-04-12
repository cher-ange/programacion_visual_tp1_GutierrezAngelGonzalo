package ar.edu.unju.fi.ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 3. Uso de variables - Estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int number;

        try {
            number = getInteger("Ingresa un número");
            System.out.println("Resultado: " + calculateFinalValue(number));
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int getInteger(String message) {
        int integerValue;

        while (true) {
            System.out.println(message + ": ");
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static boolean evenOrNot(final int number) {
        return number % 2 == 0;
    }

    public static int calculateFinalValue(final int number) {
        return evenOrNot(number) ? number * 3 : number * 2;
    }
}
