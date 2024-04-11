package ar.edu.unju.fi.ejercicio8.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class CalculadoraEspecial {
    private Integer numero;

    /**
     * Constructor vacío.
     */
    public CalculadoraEspecial() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Realiza la sumatoria con límite inferior <code>k = 1</code> hasta <code>n</code>.
     * @return El cálculo de la sumatoria
     */
    public int calcularSumatoria() {
        int sumatoria = 0, numerador;
        final int denominador = 2;

        for (int k = 1; k <= this.numero; k++) {
            numerador = k * (k+1);
            sumatoria += (int) Math.pow(((double) numerador / denominador), 2);
        }

        return sumatoria;
    }

    /**
     * Realiza la productoria con límite inferior <code>k = 1</code> hasta <code>n</code>.
     * @return El cálculo de la productoria
     */
    public int calcularProductoria() {
        int productoria = 1;

        for (int k = 1; k <= this.numero; k++) {
            productoria *= k * (k+4);
        }

        return productoria;
    }
}
