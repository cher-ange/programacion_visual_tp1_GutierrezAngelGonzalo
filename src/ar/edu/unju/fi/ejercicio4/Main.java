package ar.edu.unju.fi.ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 4. Estructura de control iterativa - estructura de control condicional.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int numero;

        try {
            numero = ingresarNumero(
                "Ingrese un número entero",
                "El número entero ingresado debe estar comprendido entre el [0-10]"
            );

            System.out.println("El factorial de " + numero + " es: " + calcularFactorial(numero));
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }

    }

    public static int ingresarNumero(final String mensajeEntrada, final String mensajeError) {
        int numeroIngresado;

        while (true) {
            System.out.print(mensajeEntrada + ": ");
            numeroIngresado = scanner.nextInt();

            if (!seEncuentraEnRangoValido(numeroIngresado)) {
                System.out.println(mensajeError);
            } else {
                return numeroIngresado;
            }
        }
    }

    public static boolean seEncuentraEnRangoValido(final int numero) {
        return  !(numero < 0 || numero > 10);
    }

    public static int calcularFactorial(int numero) {
        int factorial = 1;

        if (numero == 0 || numero == 1) {
            return factorial;
        }

        while (numero > 0) {
            factorial = factorial * numero;
            numero--;
        }

        return factorial;
    }

}
