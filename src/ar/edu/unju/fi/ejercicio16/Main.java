package ar.edu.unju.fi.ejercicio16;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 16. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] personNames = new String[5];

        try (scanner) {
            for (int i = 0; i < personNames.length; i++) {
                personNames[i] = getString("Ingrese un nombre de persona");
            }

            showArrayValues(personNames);
            System.out.println("Tamaño del arreglo: " + personNames.length);

            deleteValueFromArray(personNames);
            showArrayValues(personNames);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static void deleteValueFromArray(String[] array) {
        byte index;
        String temporal;
        index = getByte("Ingrese índice de un elemento");

        if (array.length - 1 == index) {
            array[index] = "";
        } else {
            while (index < array.length-1) {
                temporal = array[index + 1];
                array[index] = temporal;
                array[index + 1] = "";
                index++;
            }
        }
    }

    public static byte getByte(String message) {
        byte byteValue = 0;

        do {
            System.out.print(message + ": ");
            try {
                byteValue = Byte.parseByte(scanner.nextLine());
                if (byteValue < 1 || byteValue > 5) {
                    System.out.println("ERROR: Indicé fuera de rango");
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        } while (byteValue < 1 || byteValue > 5);

        return (byte) (byteValue - 1);
    }

    public static void showArrayValues(String[] array) {
        int i = 0;
        System.out.println("Mostrando los nombres de persona almacenados en el arreglo");
        while (i < array.length) {
            System.out.printf("[%d]: %s%n", i + 1, array[i]);
            i++;
        }
    }

    public static String getString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }
}
