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
        String[] nombresDePersona = new String[5];

        try (scanner) {
            for (int i = 0; i < nombresDePersona.length; i++) {
                nombresDePersona[i] = ingresarNombreDePersona();
            }

            mostrarValoresArreglo(nombresDePersona);
            System.out.println("Tamaño del arreglo: " + nombresDePersona.length);

            eliminarValorArreglo(nombresDePersona);
            mostrarValoresArreglo(nombresDePersona);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static void eliminarValorArreglo(String[] arreglo) {
        byte indice;
        String auxiliar;
        indice = ingresarIndice();

        if (arreglo.length - 1 == indice) {
            arreglo[indice] = "";
        } else {
            while (indice < arreglo.length-1) {
                auxiliar = arreglo[indice + 1];
                arreglo[indice] = auxiliar;
                arreglo[indice + 1] = "";
                indice++;
            }
        }
    }

    public static byte ingresarIndice() {
        byte indice;

        System.out.print("Ingrese índice de un elemento: ");
        indice = scanner.nextByte();
        scanner.nextLine();

        return (byte) (indice - 1);
    }

    public static void mostrarValoresArreglo(String[] arreglo) {
        int i = 0;
        System.out.println(
                "Mostrando los nombres de persona almacenados en el arreglo"
        );
        while (i < arreglo.length) {
            System.out.printf("[%d]: %s%n", i+1, arreglo[i]);
            i++;
        }
    }

    public static String ingresarNombreDePersona() {
        System.out.print("Ingrese un nombre de persona: ");
        return scanner.nextLine();
    }
}
