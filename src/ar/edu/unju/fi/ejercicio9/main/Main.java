package ar.edu.unju.fi.ejercicio9.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Product;

/**
 * 9. Uso de constructor de clase – métodos - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            buildProducts();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static void buildProducts() {
        Product product;

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese datos del producto");
            product = new Product();
            product.setName(getString("Ingrese el nombre"));
            product.setCode(getInteger("Ingrese el código"));
            product.setPrice(getDouble("Ingrese el precio"));
            product.setDiscount(getByte(
                    "Ingrese el descuento",
                    "El descuento esta comprendido entre [0-50]")
            );
            product.showInformation();

            System.out.println("Producto con descuento: " + product.calculateProductWithDiscount());
        }
    }

    public static String getString(final String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static int getInteger(final String message) {
        int integerValue;

        while (true) {
            inputMessage(message);
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static double getDouble(final String message) {
        double doubleValue;

        while (true) {
            inputMessage(message);
            try {
                doubleValue = Double.parseDouble(scanner.nextLine());
                return doubleValue;
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número");
            }
        }
    }

    public static byte getByte(final String inputMessage, final String errorMessage) {
        byte byteValue;

        while (true) {
            inputMessage(inputMessage);
            try {
                byteValue= Byte.parseByte(scanner.nextLine());

                if (isInRange(byteValue)) {
                    return byteValue;
                } else {
                    errorMessage(errorMessage);
                }
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número");
            }
        }
    }

    public static boolean isInRange(final byte discount) {
        return !(discount < 0 || discount > 50);
    }

    public static void inputMessage(String message) {
        System.out.print(message + ": ");
    }

    public static void errorMessage(String message) {
        System.out.println("ERROR: " + message);
    }
}
