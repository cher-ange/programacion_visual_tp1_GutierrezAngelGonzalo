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
        final int numberOne = 8,
            numberTwo = 5,
            numberThree = 1,
            numberFour = 20,
            numberFive = 9;
        final double average;

        int[] integers = {
            numberOne,
            numberTwo,
            numberThree,
            numberFour,
            numberFive
        };

        average = calculateAverage(integers);

        System.out.println("El promedio es: " + average);
    }

    public static double calculateAverage(int[] arrayOfIntegers) {
        return (double) Arrays.stream(arrayOfIntegers).sum() / arrayOfIntegers.length;
    }

}
