package ar.edu.unju.fi.ejercicio18.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class TouristicDestiny {
    private static int nextCode = 0;
    private Integer code;
    private String name;
    private Double price;
    private Country country;
    private Integer amountOfDays;

    public TouristicDestiny() {
        ++nextCode;
        this.code = nextCode;
    }

    public TouristicDestiny(String name, Double price, Country country, Integer amountOfDays) {
        ++nextCode;
        this.code = nextCode;
        this.name = name;
        this.price = price;
        this.country = country;
        this.amountOfDays = amountOfDays;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(Integer amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Destino Turístico").append(":").append("\n")
                .append("Código").append(": ").append(code).append("\n")
                .append("Nombre").append(": ").append(name).append("\n")
                .append("Precio").append(": ").append(price).append("\n")
                .append(country)
                .append("Cantidad de días").append(": ").append(amountOfDays).append("\n")
                .toString();
    }
}
