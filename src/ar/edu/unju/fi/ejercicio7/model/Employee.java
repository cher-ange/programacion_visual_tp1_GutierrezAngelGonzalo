package ar.edu.unju.fi.ejercicio7.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Employee {
    private final Double MINIMUM_SALARY = 210000d;
    private final Double INCREASE_BY_MERIT = 20000d;

    private String name;
    private Integer personalFile;
    private Double salary;

    public Employee() {
    }

    /**
     * Constructor parametrizado, inicializa el campo salario.
     * @param name Nombre del empleado
     * @param personalFile Legajo del empleado
     */
    public Employee(String name,
                    Integer personalFile,
                    Double salary) {
        this.name = name;
        this.personalFile = personalFile;
        this.salary = initializeSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonalFile() {
        return personalFile;
    }

    public void setPersonalFile(Integer personalFile) {
        this.personalFile = personalFile;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Actualiza el salario del empleado.
     * @param salary Salario actual
     * @return El salario actualizado del empleado
     */
    private Double initializeSalary(Double salary) {
        return Math.max(salary, MINIMUM_SALARY);
    }

    /**
     * Muestra los datos del empleado.
     */
    public void showInformation() {
        String information;

        information = """
                Información del employee
                Nombre del employee: %s
                Legajo: %d
                Salario $: %.2f
                """.formatted(
                        name,
                        personalFile,
                        salary
                );

        System.out.println(information);
    }

    /**
     * Incrementa el salario del employee sumándole el aumento por méritos.
     */
    public void increaseSalary() {
        this.salary = this.salary + this.INCREASE_BY_MERIT;
    }
}
