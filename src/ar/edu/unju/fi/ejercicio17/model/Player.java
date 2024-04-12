package ar.edu.unju.fi.ejercicio17.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Player {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private Double height;
    private Double weight;
    private String position;

    public Player() {
    }

    public Player(String name,
                  String lastName,
                  LocalDate birthDate,
                  String nationality,
                  Double height,
                  Double weight,
                  String position) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        LocalDate hoy = LocalDate.now();

        int age = Period.between(birthDate, hoy).getYears(); ;
        int month = birthDate.getMonthValue();
        int currentMonth = hoy.getMonthValue();

        if (month > currentMonth) {
            age--;
        } else {
            if (currentMonth == month) {
                int day = birthDate.getDayOfMonth();
                int currentDay = hoy.getDayOfMonth();
                if (currentDay > day) {
                    age--;
                }
            }
        }

        return age;
    }

    public void showInformation() {
        String information;

        information = """
                ----- Información del jugador -----
                Nombre: %s
                Apellido: %s
                Fecha de nacimiento: %s
                Nacionalidad: %s
                Estatura: %.2f cm
                Peso: %.2f Kg
                Posición: %s
                """.formatted(
                        name,
                        lastName,
                        birthDate.toString(),
                        nationality,
                        height,
                        weight,
                        position
        );

        System.out.println(information);
    }
}
