package ar.edu.unju.fi.ejercicio9.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

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
            construirProductos();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static void construirProductos() {
        Producto producto;

        for (int i = 0; i < 3; i++) {
            producto = new Producto();
            producto.setNombre(ingresarNombre("Ingrese el nombre"));
            producto.setCodigo(ingresarCodigo("Ingrese el código"));
            producto.setPrecio(ingresarPrecio("Ingrese el precio"));
            producto.setDescuento(ingresarDescuento("Ingrese el descuento", "El descuento esta comprendido entre [0-50]"));
            producto.mostrarInformacionDelProducto();

            System.out.println("Producto con descuento: " + producto.calcularDescuento());
        }
    }

    public static String ingresarNombre(final String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public static int ingresarCodigo(final String mensaje) {
        int codigo;

        System.out.print(mensaje + ": ");
        codigo = scanner.nextInt();
        scanner.nextLine();

        return codigo;
    }

    public static double ingresarPrecio(final String mensaje) {
        double precio;

        System.out.print(mensaje + ": ");
        precio = scanner.nextDouble();
        scanner.nextLine();

        return precio;
    }

    public static byte ingresarDescuento(final String mensajeEntrada, final String mensajeError) {
        byte descuento;

        while(true) {
            System.out.print(mensajeEntrada + ": ");
            descuento = scanner.nextByte();

            if (!seEncuentraEnRangoValido(descuento)) {
                System.out.println("ERROR: " + mensajeError);
            } else {
                scanner.nextLine();
                return descuento;
            }
        }
    }

    public static boolean seEncuentraEnRangoValido(final byte descuento) {
        return !(descuento < 0 || descuento > 50);
    }
}
