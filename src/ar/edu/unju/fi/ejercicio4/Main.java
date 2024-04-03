package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

/**
 * 4. Estructura de control iterativa - estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int userInputNumber;

        userInputNumber = getInteger("Ingresa un número", scanner);

        System.out.println(
            "El factorial de " + userInputNumber + " es: " + calculateFactorial(userInputNumber)
        );

        scanner.close();
    }

    public static int getInteger(String message, Scanner scanner) {
        System.out.print(message + ": ");
        return scanner.nextInt();
    }

    public static boolean validateInput(final int number) {
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
