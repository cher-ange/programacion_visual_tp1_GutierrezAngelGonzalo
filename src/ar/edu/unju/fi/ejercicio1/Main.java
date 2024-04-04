package ar.edu.unju.fi.ejercicio1;

import java.util.Arrays;

/**
 * 1. Uso de variables.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final int numeroUno = 8,
            numeroDos = 5,
            numeroTres = 1,
            numeroCuatro = 20,
            numeroCinco = 9;
        final double promedio;

        int[] numeros = {
            numeroUno,
            numeroDos,
            numeroTres,
            numeroCuatro,
            numeroCinco
        };

        promedio = calcularPromedio(numeros);

        System.out.println("El promedio es: " + promedio);
    }

    public static double calcularPromedio(int[] numeros) {
        return (double) Arrays.stream(numeros).sum() / numeros.length;
    }
}
