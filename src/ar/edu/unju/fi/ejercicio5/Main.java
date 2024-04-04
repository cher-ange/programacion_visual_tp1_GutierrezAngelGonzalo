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
        final int numero;

        try (scanner) {
            numero = ingresarNumero(
                "Ingrese un número entero",
                "ERROR: El número entero ingresado debe estar comprendido entre el [1-9]"
            );

            mostrarTablaDeMultiplicar(numero);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int ingresarNumero(final String mensajeEntrada, final String mensajeError) {
        int numeroIngresado;

        while (true) {
            System.out.print(mensajeEntrada + ": ");
            numeroIngresado = scanner.nextInt();

            if (!seEncuentraEnRangoValido(validatedUserInput)) {
                System.out.println(mensajeError);
            } else {
                return numeroIngresado;
            }
        }
    }

    public static boolean seEncuentraEnRangoValido(final int numero) {
        return  !(numero < 1 || numero > 9);
    }

    public static void mostrarTablaDeMultiplicar(final int numero) {
        System.out.println("Tabla de multiplicar del n.º " + numero);

        for(byte i = 0; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + numero*i);
        }
    }
}
