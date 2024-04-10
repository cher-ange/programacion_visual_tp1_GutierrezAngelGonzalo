package ar.edu.unju.fi.ejercicio15;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 15. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(scanner) {
            String[] nombresDePersona = new String[ingresarLongitudArreglo()];

            for (int i = 0; i < nombresDePersona.length; i++) {
                nombresDePersona[i] = ingresarNombreDePersona();
                System.out.printf("Indice [%d] - Valor: %s%n", i, nombresDePersona[i]);
            }

            mostrarContenidoArregloInvertido(nombresDePersona);

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static void mostrarContenidoArregloInvertido(String[] arreglo) {
        System.out.println("Mostrando arreglo de forma inversa");
        for (int i = arreglo.length; i > 0; i--) {
            System.out.printf("Indice [%d] - Valor: %s%n", i-1, arreglo[i-1]);
        }
    }


    public static String ingresarNombreDePersona() {
        System.out.print("Ingrese un nombre de persona: ");
        return scanner.nextLine();
    }

    public static int ingresarLongitudArreglo() {
        int numero;

        do {
            System.out.print("Ingrese la longitud del arreglo: ");
            numero = scanner.nextInt();

            if (numero < 5 || numero > 10) {
                System.out.println("ERROR: El número debe encontrarse en el rango [5,10]");
            } else {
                System.out.println("Longitud del arreglo: " + numero);
            }
        } while (numero < 5 || numero > 10);

        scanner.nextLine();

        return numero;
    }
}
