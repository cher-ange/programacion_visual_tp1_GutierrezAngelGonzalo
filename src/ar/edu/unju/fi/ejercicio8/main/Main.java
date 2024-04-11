package ar.edu.unju.fi.ejercicio8.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

/**
 * 8. Uso de constructor de clase - métodos - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CalculadoraEspecial calculadoraEspecial = new CalculadoraEspecial();

        try (scanner) {
            calculadoraEspecial.setNumero(ingresarLimiteSuperior("Ingrese el límite superior n"));

            System.out.println("Cálculo Sumatoria: " + calculadoraEspecial.calcularSumatoria());
            System.out.println("Cálculo Productoria: " + calculadoraEspecial.calcularProductoria());
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int ingresarLimiteSuperior(final String mensaje) {
        final int limiteSuperior;

        System.out.print(mensaje + ": ");
        limiteSuperior = scanner.nextInt();
        scanner.nextLine();

        return limiteSuperior;
    }
}
