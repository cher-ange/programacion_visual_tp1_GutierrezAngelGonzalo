package ar.edu.unju.fi.ejercicio8.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class SpecialCalculator {
    private Integer number;

    /**
     * Constructor vacío.
     */
    public SpecialCalculator() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * Realiza la sumatoria con límite inferior <code>k = 1</code> hasta <code>n</code>.
     * @return El cálculo de la sumatoria
     */
    public int calculateSummation() {
        int summation = 0, numerator;
        final int denominator = 2;

        for (int k = 1; k <= this.number; k++) {
            numerator = k * (k+1);
            summation += (int) Math.pow(((double) numerator / denominator), 2);
        }

        return summation;
    }

    /**
     * Realiza la productoria con límite inferior <code>k = 1</code> hasta <code>n</code>.
     * @return El cálculo de la productoria
     */
    public int calculateProduct() {
        int product = 1;

        for (int k = 1; k <= this.number; k++) {
            product *= k * (k+4);
        }

        return product;
    }
}
