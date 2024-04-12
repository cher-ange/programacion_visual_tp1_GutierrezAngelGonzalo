package ar.edu.unju.fi.ejercicio14;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 14. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(scanner) {
            int[] numbers = new int[getArrayLength()];
            int sumOfNumbers = 0;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getInteger("Ingrese un número");
                sumOfNumbers += numbers[i];
                System.out.printf("Indíce: [%d] - Valor: %d%n", i, numbers[i]);
            }

            System.out.println("La suma de los valores del arreglo es: " + sumOfNumbers);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int getInteger(String message) {
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

    public static int getArrayLength() {
        int length;

        while (true) {
            length = getInteger("Ingrese la longitud del arreglo");

            if (length < 3 || length > 10) {
                System.out.println("ERROR: El número debe encontrarse en el rango [3,10]");
            } else {
                System.out.println("Longitud del arreglo: " + length);
                return length;
            }
        }
    }
}