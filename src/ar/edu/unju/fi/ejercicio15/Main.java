package ar.edu.unju.fi.ejercicio15;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 15. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(scanner) {
            String[] personNames = new String[getArrayLength()];

            for (int i = 0; i < personNames.length; i++) {
                personNames[i] = getString("Ingrese un nombre de persona");
                System.out.printf("Indice [%d] - Valor: %s%n", i, personNames[i]);
            }

            showReversedArrayContent(personNames);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static void showReversedArrayContent(String[] arreglo) {
        System.out.println("Mostrando arreglo de forma inversa");
        for (int i = arreglo.length; i > 0; i--) {
            System.out.printf(
                    "Indice [%d] - Valor: %s%n",
                    i - 1,
                    arreglo[i - 1]
            );
        }
    }

    public static String getString(final String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
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

            if (length < 5 || length > 10) {
                System.out.println("ERROR: El número debe encontrarse en el rango [5,10]");
            } else {
                System.out.println("Longitud del arreglo: " + length);
                return length;
            }
        }
    }
}
