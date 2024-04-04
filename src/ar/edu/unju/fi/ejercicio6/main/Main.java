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
        Persona constructorVacio;
        Persona constructorParametrizado;
        Persona constructorConCampoInicializado;

        try (scanner) {
            mensajeEntrada("Ingrese los datos para el constructor vacío");
            constructorVacio = invocarConstructorVacio();
            mensajeSalida(constructorVacio,"constructor vacío");

            mensajeEntrada("Ingrese los datos para el constructor parametrizado");
            constructorParametrizado = invocarConstructorParametrizado();
            mensajeSalida(constructorParametrizado,"constructor parametrizado");

            mensajeEntrada("Ingrese los datos para el constructor con campo inicializado");
            constructorConCampoInicializado = invocarConstructorConCampoInicializado();
            mensajeSalida(constructorConCampoInicializado, "constructor con campo inicializado");
        } catch (InputMismatchException exception) {
            System.out.println("ERROR: Ocurrió un error durante la ejecución del programa");
        }

    }

    public static void mensajeSalida(Persona persona, final String mensaje) {
        System.out.println("===== Información sobre el " + mensaje + " =====");
        persona.mostrarInformacionPersonal();
    }

    public static Persona invocarConstructorVacio() {
        Persona persona = new Persona();

        persona.setDni(ingresarCadenaDeCaracteres("Introduzca su DNI"));
        persona.setNombre(ingresarCadenaDeCaracteres("Introduza su nombre"));
        persona.setFechaDeNacimiento(ingresarFechaDeNacimiento("Introduzca su fecha de nacimiento"));
        persona.setProvincia(ingresarCadenaDeCaracteres("Introduzca la province en donde nacío"));

        return persona;
    }

    public static Persona invocarConstructorParametrizado() {
        return new Persona(
            ingresarCadenaDeCaracteres("Introduzca su DNI"),
            ingresarCadenaDeCaracteres("Introduza su nombre"),
            ingresarFechaDeNacimiento("Introduzca su fecha de nacimiento"),
            ingresarCadenaDeCaracteres("Introduzca la province en donde nacío")
        );
    }

    public static Persona invocarConstructorConCampoInicializado() {
        return new Persona(
            ingresarCadenaDeCaracteres("Introduzca su DNI"),
            ingresarCadenaDeCaracteres("Introduza su nombre"),
            ingresarFechaDeNacimiento("Introduzca su fecha de nacimiento")
        );
    }

    private static void mensajeEntrada(final String mensaje) {
        System.out.println("===== " + mensaje + " =====");
    }

    public static String ingresarCadenaDeCaracteres(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public static Integer ingresarNumero(String mensaje) {
        final int integerInput;
        System.out.print(mensaje + ": ");

        integerInput = scanner.nextInt();
        scanner.nextLine();

        return integerInput;
    }

    public static LocalDate ingresarFechaDeNacimiento(String mensaje) {
        final int dia, mes, periodo;

        System.out.println(mensaje);

        dia = ingresarNumero("Día");
        mes = ingresarNumero("Mes");
        periodo = ingresarNumero("Año");

        return LocalDate.of(periodo, mes, dia);
    }
}
