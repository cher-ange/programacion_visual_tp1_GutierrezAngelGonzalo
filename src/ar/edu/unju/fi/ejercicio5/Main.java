package ar.edu.unju.fi.ejercicio5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 5. Estructura de control iterativa - estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final int userInputNumber;

        userInputNumber = getUserInput(
        "Ingrese un número entero",
        "ERROR: El número entero ingresado debe estar comprendido entre el [1-9]"
        );

        showMultiplicationTable(userInputNumber);
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
        return  !(number < 1 || number > 9);
    }

    public static void showMultiplicationTable(final int number) {
        System.out.println("Tabla de multiplicar del " + number);
        for(byte i = 0; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + number*i);
        }
    }

}
