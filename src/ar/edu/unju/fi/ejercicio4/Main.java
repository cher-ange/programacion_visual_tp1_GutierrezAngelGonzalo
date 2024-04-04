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

    public static void main(String[] args) {
        final int userInputNumber;

        userInputNumber = getUserInput(
            "Ingrese un número entero",
            "El número entero ingresado debe estar comprendido entre el [0-10]"
        );

        System.out.println(
            "El factorial de " + userInputNumber + " es: " + calculateFactorial(userInputNumber)
        );
    }

    public static int getUserInput(final String inputMessage, final String errorMessage) {
        int validatedUserInput;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print(inputMessage + ": ");
                    validatedUserInput = scanner.nextInt();
                    if (!isInRange(validatedUserInput)) {
                        System.out.println(errorMessage);
                    } else {
                        return validatedUserInput;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: El valor introducido no es un número entero");
                    scanner.nextLine();
                }
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
