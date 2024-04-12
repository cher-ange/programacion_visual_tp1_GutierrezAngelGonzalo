package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Person;

/**
 * 6. Uso de constructores de clase - métodos - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Person emptyConstructor;
        Person parameterizedConstructor;
        Person fieldInitializedConstructor;

        try (scanner) {
            emptyConstructor = callEmptyConstructor();
            emptyConstructor.showInformation();

            parameterizedConstructor = callParameterizedConstructor();
            parameterizedConstructor.showInformation();

            fieldInitializedConstructor = callFieldInitializedConstructor();
            fieldInitializedConstructor.showInformation();
        } catch (InputMismatchException exception) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }
    }

    public static Person callEmptyConstructor() {
        Person person = new Person();

        System.out.println("Introduce los datos para el constructor vacío");

        person.setId(getString("Introduzca su DNI"));
        person.setName(getString("Introduzca su nombre"));
        person.setBirthdate(getBirthdate("Introduzca su fecha de nacimiento"));
        person.setProvince(getString("Introduzca la provincia en donde nacío"));

        return person;
    }

    public static Person callParameterizedConstructor() {
        System.out.println("Introduce los datos para el constructor parametrizado");

        return new Person(
            getString("Introduzca su DNI"),
            getString("Introduzca su nombre"),
            getBirthdate("Introduzca su fecha de nacimiento"),
            getString("Introduzca la province en donde nacío")
        );
    }

    public static Person callFieldInitializedConstructor() {
        System.out.println("Introduce los datos para el constructor con campo inicializado");

        return new Person(
            getString("Introduzca su DNI"),
            getString("Introduzca su nombre"),
            getBirthdate("Introduzca su fecha de nacimiento")
        );
    }

    public static String getString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static Integer getInteger(String message) {
        int integerValue;

        while (true) {
            System.out.print(message + ": ");
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static LocalDate getBirthdate(String message) {
        final int day, month, year;

        System.out.println(message);

        day = getInteger("Día");
        month = getInteger("Mes");
        year = getInteger("Año");

        return LocalDate.of(year, month, day);
    }
}
