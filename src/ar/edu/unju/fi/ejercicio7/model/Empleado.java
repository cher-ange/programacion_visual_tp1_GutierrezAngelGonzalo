package ar.edu.unju.fi.ejercicio7.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Empleado {

    private final Double salarioMinimo = 210000d;
    private final Double aumentoPorMeritos = 20000d;

    private String nombre;
    private Integer legajo;
    private Double salario;

    /**
     * Constructor parametrizado, inicializa el campo salario.
     * @param nombre Nombre del empleado
     * @param legajo Legajo del empleado
     */
    public Empleado(
        String nombre,
        Integer legajo,
        Double salario) {

        this.nombre = nombre;
        this.legajo = legajo;
        this.salario = inicializarSalario(salario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * Actualiza el salario del empleado.
     * @param salario Salario actual
     * @return El salario actualizado del empleado
     */
    private Double inicializarSalario(Double salario) {
        int compare = salario.compareTo(this.salarioMinimo);
        return (compare == 1 || compare == 0) ? salario : this.salarioMinimo;
    }

    /**
     * Muestra los datos del empleado.
     */
    public void mostrarInformacionDelEmpleado() {
        String informacionDelEmpleado;

        informacionDelEmpleado = """
                ===== Información del empleado =====
                Nombre del empleado: %s
                Legajo: %d
                Salario $: %.2f
                """.formatted(
                    nombre,
                    legajo,
                    salario
                );

        System.out.println(informacionDelEmpleado);
    }

    /**
     * Incrementa el salario del empleado sumándole el aumento por méritos.
     */
    public void incrementarSalario() {
        this.salario = this.salario + this.aumentoPorMeritos;
    }
}
