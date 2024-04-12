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
                pizza.setDiameter(getDiameter());
                pizza.setSpecialIngredients(orderWithSpecialIngredients());
                pizza.calculatePrice();
                pizza.calculateArea();
                showInformation(i, pizza);
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static int getDiameter() {
        int diameter;

        while (true) {
            try {
                System.out.println("""
                        Pizzas disponibles
                        20 - Pizza pequeña
                        30 - Pizza mediana
                        40 - Pizza grande""");
                System.out.print("Ingrese el diámetro de la pizza: ");
                diameter = Integer.parseInt(scanner.nextLine());

                if (isValid(diameter)) {
                    return diameter;
                } else {
                    System.out.println("ERROR: El diámetro de las pizzas solo puede ser 20, 30 o 40.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número");
            }
        }
    }

    public static boolean orderWithSpecialIngredients() {
        String answer;

        while (true) {
            System.out.print("¿Desea su pizza con ingredientes especiales? [true/false]: ");
            answer = scanner.nextLine().toLowerCase();

            if (answer.equals("true") || answer.equals("false")) {
                return Boolean.parseBoolean(answer);
            } else {
                System.out.println("ERROR: Solo se permiten los valores true or false");
            }
        }
    }

    public static boolean isValid(int diameter) {
        return diameter == 20 || diameter == 30 || diameter == 40;
    }

    public static void showInformation(int numeroDeOrden, Pizza pizza) {
        String information;

        information =  """
                ** Pizza %d **
                Diámetro = %d cm
                Ingredientes especiales = %b
                Precio Pizza = $ %d
                Área de la pizza = %.2f cm^2
                """.formatted(
                    numeroDeOrden,
                    pizza.getDiameter(),
                    pizza.getSpecialIngredients(),
                    pizza.getPrice(),
                    pizza.getArea()
                );

        System.out.println(information);
    }
}
