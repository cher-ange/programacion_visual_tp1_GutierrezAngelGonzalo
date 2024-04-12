package ar.edu.unju.fi.ejercicio18.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Country {
    private static int nextCode = 0;
    private Integer code;
    private String name;

    public Country() {
        ++nextCode;
        this.code = nextCode;
    }

    public Country(String name) {
        ++nextCode;
        this.code = nextCode;
        this.name = name;
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

    @Override
    public String toString() {
        return new StringBuilder()
                .append("País").append(":").append("\n")
                .append("Código").append(": ").append(code).append("\n")
                .append("Nombre").append(": ").append(name).append("\n")
                .toString();
    }
}
