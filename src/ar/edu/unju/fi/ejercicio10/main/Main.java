package ar.edu.unju.fi.ejercicio10.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

/**
 * 10. Uso de constructor de clase – métodos - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Pizza pizza;

        try (scanner) {

            for (int i = 1; i <= 3; i++) {
                pizza = new Pizza();
                pizza.setDiametro(ingresarDiametro());
                pizza.setIngredientesEspeciales(ordenarConIngredientesEspeciales());
                pizza.calcularPrecio();
                pizza.calcularArea();
                mostrarPizza(i, pizza);
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int ingresarDiametro() {
        int diametro;

        while (true) {
            System.out.print("""
                Pizzas disponibles
                20 - Pizza pequeña
                30 - Pizza mediana
                40 - Pizza grande
                Ingrese el diámetro de la pizza:\s""");
            diametro = scanner.nextInt();

            if (validarDiametro(diametro)) {
                scanner.nextLine();
                return diametro;
            } else {
                System.out.println("ERROR: El diámetro de las pizzas solo puede ser 20, 30 o 40.");
            }
        }
    }

    public static boolean ordenarConIngredientesEspeciales() {
        String respuesta;

        while (true) {
            System.out.print("¿Desea su pizza con ingredientes especiales? [true/false]: ");
            respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("true") || respuesta.equals("false")) {
                return Boolean.parseBoolean(respuesta);
            } else {
                System.out.println("ERROR: Solo se permiten los valores true or false");
            }
        }
    }

    public static boolean validarDiametro(int diametro) {
        return diametro == 20 || diametro == 30 || diametro == 40;
    }

    public static void mostrarPizza(int numeroDeOrden, Pizza pizza) {
        String informacionPizza;

        informacionPizza =  """
                ** Pizza %d **
                Diámetro = %d
                Ingredientes especiales = %b
                Precio Pizza = %d$
                Área de la pizza = %f
                """.formatted(
                    numeroDeOrden,
                    pizza.getDiametro(),
                    pizza.getIngredientesEspeciales(),
                    pizza.getPrecio(),
                    pizza.getArea()
                );

        System.out.println(informacionPizza);
    }
}
