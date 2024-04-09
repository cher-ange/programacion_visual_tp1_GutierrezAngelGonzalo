package ar.edu.unju.fi.ejercicio12.main;

import ar.edu.unju.fi.ejercicio12.model.Persona;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 12. Uso de <code>Calendar</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Persona persona = new Persona();

        persona.setNombre(ingresarNombre());
        persona.setFechaDeNacimiento(ingresarFechaDeNacimiento());

        persona.mostrarInformacion();
    }

    public static String ingresarNombre() {
        System.out.print("Ingresar nombre: ");
        return scanner.nextLine();
    }

    public static Calendar ingresarFechaDeNacimiento() {
        Calendar fechaDeNacimiento = Calendar.getInstance();

        System.out.println("Ingresar fecha de nacimiento");
        fechaDeNacimiento.set(
                ingresarPeriodo(),
                ingresarMes(),
                ingresarDia()
        );

        return fechaDeNacimiento;
    }

    public static int ingresarDia() {
        final int dia;

        System.out.print("Día: ");
        dia = scanner.nextInt();
        scanner.nextLine();

        return dia;
    }

    public static int ingresarMes() {
        int mes;
        System.out.print("Mes Nº: ");
        mes = scanner.nextInt();

        switch (mes) {
            case 1 -> mes = Calendar.JANUARY;
            case 2 -> mes = Calendar.FEBRUARY;
            case 3 -> mes = Calendar.MARCH;
            case 4 -> mes = Calendar.APRIL;
            case 5 -> mes = Calendar.MAY;
            case 6 -> mes = Calendar.JUNE;
            case 7 -> mes = Calendar.JULY;
            case 8 -> mes = Calendar.AUGUST;
            case 9 -> mes = Calendar.SEPTEMBER;
            case 10 -> mes = Calendar.OCTOBER;
            case 11 -> mes = Calendar.NOVEMBER;
            case 12 -> mes = Calendar.DECEMBER;
        }

        return mes;
    }

    public static int ingresarPeriodo() {
        final int periodo;

        System.out.print("Año: ");
        periodo = scanner.nextInt();
        scanner.nextLine();

        return periodo;
    }
}
