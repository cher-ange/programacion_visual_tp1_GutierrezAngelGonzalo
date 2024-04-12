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
        final int number1= 8,
            number2 = 5,
            number3 = 1,
            number4 = 20,
            number5 = 9;
        final double average;

        int[] numbers= {
            number1,
            number2,
            number3,
            number4,
            number5
        };

        average = calculateAverage(numbers);

        System.out.println("El promedio es: " + average);
    }

    public static double calculateAverage(int[] numbers) {
        return (double) Arrays.stream(numbers).sum() / numbers.length;
    }
}
