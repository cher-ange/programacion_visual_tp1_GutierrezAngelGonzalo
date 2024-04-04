package ar.edu.unju.fi.ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 3. Uso de variables - Estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int numero;

        try {
            numero = ingresarNumero("Ingresa un número");

            System.out.println("Resultado: " + calcularValorFinal(numero));
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int ingresarNumero(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextInt();
    }

    public static boolean parOImpar(final int numero) {
        return numero % 2 == 0;
    }

    public static int calcularValorFinal(final int numero) {
        return parOImpar(numero) ? numero*3 : numero*2;
    }

}
