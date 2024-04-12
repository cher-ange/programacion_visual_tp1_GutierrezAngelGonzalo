package ar.edu.unju.fi.ejercicio13;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 13. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = new int[8];

        try(scanner) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getInteger("Ingrese un número: ");
                System.out.printf("Indíce: [%d] - Valor: %d%n", i, numbers[i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int getInteger(String message) {
        int integerValue;

        while (true) {
            System.out.print(message);
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        }
    }

}
