package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Person {
    private String name;
    private Calendar birthdate;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
        int month = birthdate.get(Calendar.MONTH);
        int currentMonth = today.get(Calendar.MONTH);

        if (month > currentMonth) {
            age--;
        } else {
            if (currentMonth == month) {
                int day = birthdate.get(Calendar.DAY_OF_MONTH);
                int currentDay = today.get(Calendar.DAY_OF_MONTH);
                if (currentDay > day) {
                    age--;
                }
            }
        }

        return age;
    }

    public String getZodiacSign() {
        final int day = birthdate.get(Calendar.DAY_OF_MONTH);
        final int month = birthdate.get(Calendar.MONTH) + 1;

        switch (month) {
            case 1 -> { return day >= 20 ? "Acuario" : "Capricornio"; }
            case 2 -> { return day >= 19 ? "Pisces" : "Acuario"; }
            case 3 -> { return day >= 21 ? "Aries" : "Pisces"; }
            case 4 -> { return day >= 20 ? "Taurus" : "Aries"; }
            case 5 -> { return day >= 21 ? "Gemini" : "Taurus"; }
            case 6 -> { return day >= 21 ? "Cancer" : "Gemini"; }
            case 7 -> { return day >= 23 ? "Leo" : "Cancer"; }
            case 8 -> { return day >= 23 ? "Virgo" : "Leo"; }
            case 9 -> { return day >= 23 ? "Libra" : "Virgo"; }
            case 10 -> { return day >= 23 ? "Escorpio" : "Libra"; }
            case 11 -> { return day >= 22 ? "Sagitario" : "Escorpio"; }
            case 12 -> { return day >= 22 ? "Capricornio" : "Sagitario"; }
            default -> { return "ERROR"; }
        }
    }

    public String getSeason() {
        final int day = birthdate.get(Calendar.DAY_OF_MONTH);
        final int month = birthdate.get(Calendar.MONTH);

        String season = "";

        if ((month == 1) || (month == 2)) {
            season = "Verano";
        } else if ((month == 4) || (month == 5)) {
            season = "Otoño";
        } else if ((month == 7) || (month == 8)) {
            season = "Invierno";
        } else if ((month == 10) || (month == 11)) {
            season = "Primavera";
        } else if ((month == 3) && (day <= 19)) {
            season = "Verano";
        } else if (month == 3) {
            season = "Otoño";
        } else if ((month == 6) && (day <= 20)) {
            season = "Otoño";
        } else if (month == 6) {
            season = "Invierno";
        } else if ((month == 9) && (day <= 20)) {
            season = "Invierno";
        } else if (month == 9) {
            season = "Primavera";
        } else if ((month == 12) && (day <= 21)) {
            season = "Primavera";
        } else if (month == 12) {
            season = "Verano";
        }

        return season;
    }

    public void showInformation() {
        final String information;
        final String date = String.format(
                "%d/%d/%d",
                birthdate.get(Calendar.DAY_OF_MONTH),
                birthdate.get(Calendar.MONTH) + 1,
                birthdate.get(Calendar.YEAR)
        );

        information = """
                Información de la persona
                Nombre: %s
                Fecha nacimiento: %s
                Edad: %d años
                Signo del zodiaco: %s
                Estación: %s
                """.formatted(
                        name,
                        date,
                        getAge(),
                        getZodiacSign(),
                        getSeason()
        );
        System.out.println(information);
    }
}
