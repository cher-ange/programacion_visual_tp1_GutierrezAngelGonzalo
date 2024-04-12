package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Person {
    private String id;
    private String name;
    private LocalDate birthdate;
    private String province;

    /**
     * Constructor vacío.
     */
    public Person() {
    }

    /**
     * Constructor parametrizado, todos los campos.
     * @param id Número de DNI de la persona
     * @param name Nombre de la persona
     * @param birthdate Fecha de nacimiento de la persona
     * @param province Provincia donde nació
     */
    public Person(
            String id,
            String name,
            LocalDate birthdate,
            String province) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.province = province;
    }

    /**
     * Constructor parametrizado, inicializa el campo provincia.
     * @param id Número de DNI de la persona
     * @param name Nombre de la persona
     * @param birthdate Fecha de nacimiento de la persona
     */
    public Person(String id,
                  String name,
                  LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.province = "Jujuy";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int calculateAge(LocalDate brithdate) {
        return Period.between(brithdate, LocalDate.now()).getYears();
    }

    public boolean isUnderAge(final int age) {
        return age > 18;
    }

    public void showInformation() {
        final String isUnderageMessage;
        final String information;

        if (isUnderAge(calculateAge(birthdate))) {
            isUnderageMessage = "La persona es mayor de edad";
        } else {
            isUnderageMessage = "La persona no es mayor de edad";
        }

        information = """
            Información Personal
            Nombre: %s
            DNI: %s
            Fecha de nacimiento: %s
            Provincia: %s
            %s""".formatted(
                name,
                id,
                birthdate.toString(),
                province,
                isUnderageMessage);

        System.out.println(information);
    }
}
