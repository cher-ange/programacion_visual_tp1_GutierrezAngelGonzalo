package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Persona {
    private String nombre;
    private Calendar fechaDeNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int calcularEdad() {
        Calendar hoy = Calendar.getInstance();

        int edad = hoy.get(Calendar.YEAR) - fechaDeNacimiento.get(Calendar.YEAR);
        int mesPersona = fechaDeNacimiento.get(Calendar.MONTH);
        int mesHoy = hoy.get(Calendar.MONTH);

        if (mesPersona > mesHoy) {
            edad--;
        } else {
            if (mesHoy == mesPersona) {
                int diaPersona = fechaDeNacimiento.get(Calendar.DAY_OF_MONTH);
                int diaHoy = hoy.get(Calendar.DAY_OF_MONTH);
                if (diaHoy > diaPersona) {
                    edad--;
                }
            }
        }

        return edad;
    }

    public String determinarSignoZodiacal() {
        final int dia = fechaDeNacimiento.get(Calendar.DAY_OF_MONTH);
        final int mes = fechaDeNacimiento.get(Calendar.MONTH) + 1;

        switch (mes) {
            case 1 -> {
                return dia >= 20 ? "Acuario" : "Capricornio";
            }
            case 2 -> {
                return dia >= 19 ? "Pisces" : "Acuario";
            }
            case 3 -> {
                return dia >= 21 ? "Aries" : "Pisces";
            }
            case 4 -> {
                return dia >= 20 ? "Taurus" : "Aries";
            }
            case 5 -> {
                return dia >= 21 ? "Gemini" : "Taurus";
            }
            case 6 -> {
                return dia >= 21 ? "Cancer" : "Gemini";
            }
            case 7 -> {
                return dia >= 23 ? "Leo" : "Cancer";
            }
            case 8 -> {
                return dia >= 23 ? "Virgo" : "Leo";
            }
            case 9 -> {
                return dia >= 23 ? "Libra" : "Virgo";
            }
            case 10 -> {
                return dia >= 23 ? "Escorpio" : "Libra";
            }
            case 11 -> {
                return dia >= 22 ? "Sagitario" : "Escorpio";
            }
            case 12 -> {
                return dia >= 22 ? "Capricornio" : "Sagitario";
            }
            default -> {
                return "ERROR";
            }
        }
    }

    public String determinarEstacionSegunFechaDeNacimiento() {
        String[] estaciones = {
                "Invierno", "Invierno", "Primavera", "Primavera", "Verano", "Verano",
                "Verano", "Verano", "Otoño", "Otoño", "Invierno", "Invierno"
        };
        return estaciones[fechaDeNacimiento.get(Calendar.MONTH) + 1];
    }

    public void mostrarInformacion() {
        String informacionPersonal;

        informacionPersonal = """
                        Nombre: %s
                        Fecha nacimiento: %d/%d/%d
                        Edad: %d años
                        Signo del zodiaco: %s
                        Estación: %s""".formatted(
                                nombre,
                fechaDeNacimiento.get(Calendar.DAY_OF_MONTH),
                fechaDeNacimiento.get(Calendar.MONTH) + 1,
                fechaDeNacimiento.get(Calendar.YEAR),
                calcularEdad(),
                determinarSignoZodiacal(),
                determinarEstacionSegunFechaDeNacimiento()
        );

        System.out.println(informacionPersonal);
    }
}
