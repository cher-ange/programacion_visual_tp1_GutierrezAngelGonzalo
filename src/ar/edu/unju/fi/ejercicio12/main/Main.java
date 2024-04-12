package ar.edu.unju.fi.ejercicio12.main;

import ar.edu.unju.fi.ejercicio12.model.Person;

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
        Person person = new Person();

        person.setName(getString());
        person.setBirthdate(getBirthdate());
        person.showInformation();
    }

    public static String getString() {
        System.out.print("Ingresar nombre: ");
        return scanner.nextLine();
    }

    public static Calendar getBirthdate() {
        Calendar birthdate = Calendar.getInstance();

        System.out.println("Ingresar fecha de nacimiento");
        birthdate.set(getYear(), getMonth(), getDay());

        return birthdate;
    }

    public static int getDay() {
        return getInteger("Día");
    }

    public static int getMonth() {
        int month;
        month = getInteger("Mes n.º");

        switch (month) {
            case 1 -> month = Calendar.JANUARY;
            case 2 -> month = Calendar.FEBRUARY;
            case 3 -> month = Calendar.MARCH;
            case 4 -> month = Calendar.APRIL;
            case 5 -> month = Calendar.MAY;
            case 6 -> month = Calendar.JUNE;
            case 7 -> month = Calendar.JULY;
            case 8 -> month = Calendar.AUGUST;
            case 9 -> month = Calendar.SEPTEMBER;
            case 10 -> month = Calendar.OCTOBER;
            case 11 -> month = Calendar.NOVEMBER;
            case 12 -> month = Calendar.DECEMBER;
        }

        return month;
    }

    public static int getYear() {
        return getInteger("Año");
    }

    public static int getInteger(String message) {
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
}
