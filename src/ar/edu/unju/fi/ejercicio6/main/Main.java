package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

/**
 * 6. Uso de constructores de clase - métodos - creación de objetos.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Persona emptyConstructorPerson;
        Persona parameterizedConstructorPerson;
        Persona fieldInitializedConstructorPerson;

        try (scanner) {
            showInputMessage("Ingrese los datos para el constructor vacío");
            emptyConstructorPerson = getEmptyConstructorPerson();
            displayPersonInformation(
            emptyConstructorPerson,
                "constructor vacío"
            );

            showInputMessage("Ingrese los datos para el constructor parametrizado");
            parameterizedConstructorPerson = getParameterizedConstructorPerson();
            displayPersonInformation(
                parameterizedConstructorPerson,
                "constructor parametrizado"
            );

            showInputMessage("Ingrese los datos para el constructor con campo inicializado");
            fieldInitializedConstructorPerson = getFieldInitializedConstructorPerson();
            displayPersonInformation(
                fieldInitializedConstructorPerson,
                "constructor con campo inicializado"
            );
        } catch (InputMismatchException exception) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }

    }

    public static void displayPersonInformation(Persona person, final String message) {
        System.out.println("===== Información sobre el " + message + " =====");
        person.showPersonalInformation();
    }

    public static Persona getEmptyConstructorPerson() {
        Persona persona = new Persona();

        persona.setDni(getString("Introduzca su DNI"));
        persona.setNombre(getString("Introduza su nombre"));
        persona.setFechaDeNacimiento(getBirthdate("Introduzca su fecha de nacimiento"));
        persona.setProvincia(getString("Introduzca la province en donde nacío"));

        return persona;
    }

    public static Persona getParameterizedConstructorPerson() {
        return new Persona(
            getString("Introduzca su DNI"),
            getString("Introduza su nombre"),
            getBirthdate("Introduzca su fecha de nacimiento"),
            getString("Introduzca la province en donde nacío")
        );
    }

    public static Persona getFieldInitializedConstructorPerson() {
        return new Persona(
            getString("Introduzca su DNI"),
            getString("Introduza su nombre"),
            getBirthdate("Introduzca su fecha de nacimiento")
        );
    }

    private static void showInputMessage(final String message) {
        System.out.println("===== " + message + " =====");
    }

    public static String getString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static Integer getInteger(String message) {
        final int integerInput;
        System.out.print(message + ": ");

        integerInput = scanner.nextInt();
        scanner.nextLine();

        return integerInput;
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
