package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Persona {

    private String dni;
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String provincia;

    /**
     * Constructor vacío.
     */
    public Persona() {
    }

    /**
     * Constructor parametrizado, todos los campos.
     * @param dni Número de DNI de la persona
     * @param nombre Nombre de la persona
     * @param fechaDeNacimiento Fecha de nacimiento de la persona
     * @param provincia Provincia donde nació
     */
    public Persona(
            String dni,
            String nombre,
            LocalDate fechaDeNacimiento,
            String provincia) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.provincia = provincia;
    }

    /**
     * Constructor parametrizado, inicializa el campo provincia.
     * @param dni Número de DNI de la persona
     * @param nombre Nombre de la persona
     * @param fechaDeNacimiento Fecha de nacimiento de la persona
     */
    public Persona(String dni,
            String nombre,
            LocalDate fechaDeNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.provincia = "Jujuy";
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int calculateAge(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public boolean isUnderage(final int age) {
        return (age > 18) ? true : false;
    }

    public void showPersonalInformation() {
        final String underageMessage;
        final String personalInformation;

        if (isUnderage(calculateAge(fechaDeNacimiento))) {
            underageMessage = "La persona es mayor de edad";
        } else {
            underageMessage = "La persona no es mayor de edad";
        }

        personalInformation = """
            Información Personal
            Nombre: %s
            DNI: %s
            Fecha de nacimiento: %s
            Provincia: %s
            %s""".formatted(
                nombre,
                dni,
                fechaDeNacimiento.toString(),
                provincia,
                underageMessage);

        System.out.println(personalInformation);
    }






}
