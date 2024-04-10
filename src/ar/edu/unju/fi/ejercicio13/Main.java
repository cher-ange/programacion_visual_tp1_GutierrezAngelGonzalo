package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

/**
 * 13. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] listaNumeros = new int[8];

        for (int i = 0; i < listaNumeros.length; i++) {
            System.out.print("Ingrese un número: ");
            listaNumeros[i] = scanner.nextInt();
            System.out.printf("Indíce: [%d] Valor: %d%n", i, listaNumeros[i]);
        }

        scanner.close();
    }
}
