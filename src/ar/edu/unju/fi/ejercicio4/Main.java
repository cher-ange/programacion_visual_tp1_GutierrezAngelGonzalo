package ar.edu.unju.fi.ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 4. Estructura de control iterativa - estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int number;

        try {
            number = getInteger("Ingrese un número entero");

            System.out.println("El factorial de " + number + " es: " + calculateFactorial(number));
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }

    }

    public static int getInteger(final String inputMessage) {
        int integerValue;

        while (true) {
            System.out.print(inputMessage + ": ");
            try {
                integerValue = Integer.parseInt(scanner.nextLine());

                if (!isInRange(integerValue)) {
                    System.out.println("ERROR: El número entero ingresado debe estar comprendido entre el [0-10]");
                } else {
                    return integerValue;
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static boolean isInRange(final int number) {
        return  !(number < 0 || number > 10);
    }

    public static int calculateFactorial(int number) {
        int factorial = 1;

        if (number == 0 || number == 1) {
            return factorial;
        }

        while (number > 0) {
            factorial = factorial * number;
            number--;
        }

        return factorial;
    }
}
