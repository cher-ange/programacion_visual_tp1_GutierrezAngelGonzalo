package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

/**
 * 3. Uso de variables - Estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int userInputNumber;

        userInputNumber = getInteger("Ingresa un número", scanner);

        System.out.println("Resultado: " + exerciseAnswer(userInputNumber));

        scanner.close();
    }

    public static int getInteger(String message, Scanner scanner) {
        System.out.print(message + ": ");
        return scanner.nextInt();
    }

    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    public static int exerciseAnswer(final int number) {
        return isEven(number) ? number*3 : number*2;
    }

}
