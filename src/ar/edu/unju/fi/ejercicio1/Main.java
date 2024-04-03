package ar.edu.unju.fi.ejercicio1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int numberOne = 8,
        numberTwo = 5,
        numberThree = 1,
        numberFour = 20,
        numberFive = 9;

        int[] integers = {
            numberOne,
            numberTwo,
            numberThree,
            numberFour,
            numberFive
        };
        double average = calculateAverage(integers);

        System.out.println("El promedio es: " + average);
    }

    public static double calculateAverage(int[] arrayOfIntegers) {
        return (double) Arrays.stream(arrayOfIntegers).sum() / arrayOfIntegers.length;
    }

}
