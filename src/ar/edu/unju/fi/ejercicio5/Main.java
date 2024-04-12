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
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int number;

        try (scanner) {
            number = getInteger("Ingrese un número entero");
            showMultiplicationTable(number);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int getInteger(final String inputMessage) {
        int integerValue;

        while (true) {
            try {
                System.out.print(inputMessage + ": ");
                integerValue = Integer.parseInt(scanner.nextLine());

                if (!isInRange(integerValue)) {
                    System.out.println("ERROR: El número entero ingresado debe estar comprendido entre el [1-9]");
                } else {
                    return integerValue;
                }    
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static boolean isInRange(final int number) {
        return !(number < 1 || number > 9);
    }

    public static void showMultiplicationTable(final int number) {
        System.out.println("Tabla de multiplicar del n.º " + number);

        for(byte i = 0; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + number * i);
        }
    }
}
