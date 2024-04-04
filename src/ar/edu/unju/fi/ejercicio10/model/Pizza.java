package ar.edu.unju.fi.ejercicio10.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Pizza {
    private final Integer adicionalIngredientesEspeciales20 = 500;
    private final Integer adicionalIngredientesEspeciales30 = 750;
    private final Integer adicionalIngredientesEspeciales40 = 1000;

    private Integer diametro;
    private Integer precio;
    private Double area;
    private Boolean ingredientesEspeciales;

    public Integer getDiametro() {
        return diametro;
    }
    public void setDiametro(Integer diametro) {
        this.diametro = diametro;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    public Boolean getIngredientesEspeciales() {
        return ingredientesEspeciales;
    }
    public void setIngredientesEspeciales(Boolean ingredientesEspeciales) {
        this.ingredientesEspeciales = ingredientesEspeciales;
    }

    public int calcularPrecio() {
        int precio;

        switch (diametro) {
            case 20:
                if (!ingredientesEspeciales) {
                    precio = this.precio = 4500;
                } else {
                    precio = this.precio = 4500 + adicionalIngredientesEspeciales20;
                }
                break;
            case 30:
                if (!ingredientesEspeciales) {
                    precio = this.precio = 4800;
                } else {
                    precio = this.precio = 4800 + adicionalIngredientesEspeciales30;
                }
                break;
            case 40:
                if (!ingredientesEspeciales) {
                    precio = this.precio = 5500;
                } else {
                    precio = this.precio = 5500 + adicionalIngredientesEspeciales40;
                }
                break;
            default:
                precio = this.precio;
                break;
        }

        return precio;
    }

    public void calcularArea() {
        this.area = Math.PI * Math.pow(this.diametro/2, 2);
    }
}
