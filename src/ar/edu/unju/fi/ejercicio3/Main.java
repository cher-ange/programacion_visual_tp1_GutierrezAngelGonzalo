package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número: ");
        int userInputNumber = scanner.nextInt();

        System.out.println("Número ingresado: " + userInputNumber);
        System.out.println(answer(userInputNumber));

        scanner.close();
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int answer(int number) {
        return isEven(number) ? number*3 : number*2;
    }

}
