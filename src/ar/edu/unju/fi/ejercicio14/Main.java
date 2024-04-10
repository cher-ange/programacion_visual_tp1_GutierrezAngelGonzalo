package ar.edu.unju.fi.ejercicio14;

import java.util.Arrays;
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
            int[] listaNumeros = new int[ingresarLongitudArreglo()];
            int sumaValores = 0;
            for (int i = 0; i < listaNumeros.length; i++) {
                listaNumeros[i] = ingresarNumero();
                sumaValores += listaNumeros[i];
                System.out.printf("Indíce: [%d] - Valor: %d%n", i, listaNumeros[i]);
            }
            System.out.println("La suma de los valores del arreglo es: " + sumaValores);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int ingresarNumero() {
        System.out.print("Ingrese un número: ");
        return scanner.nextInt();
    }

    public static int ingresarLongitudArreglo() {
        int numero;

        while (true) {
            System.out.print("Ingrese la longitud del arreglo: ");
            numero = scanner.nextInt();

            if (numero < 3 || numero > 10) {
                System.out.println("ERROR: El número debe encontrarse en el rango [3,10]");
            } else {
                System.out.println("Longitud del arreglo: " + numero);
                return numero;
            }
        }
    }
}
