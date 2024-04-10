package ar.edu.unju.fi.ejercicio13;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 13. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] listaNumeros = new int[8];

        try(Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < listaNumeros.length; i++) {
                System.out.print("Ingrese un número: ");
                listaNumeros[i] = scanner.nextInt();
                System.out.printf("Indíce: [%d] - Valor: %d%n", i, listaNumeros[i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }
}
