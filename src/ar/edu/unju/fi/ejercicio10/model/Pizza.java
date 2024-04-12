package ar.edu.unju.fi.ejercicio10.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Pizza {
    private final Integer additionalSpecialIngredients20 = 500;
    private final Integer additionalSpecialIngredients30 = 750;
    private final Integer additionalSpecialIngredients40 = 1000;

    private Integer diameter;
    private Integer price;
    private Double area;
    private Boolean specialIngredients;

    public Integer getDiameter() {
        return diameter;
    }
    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    public Boolean getSpecialIngredients() {
        return specialIngredients;
    }
    public void setSpecialIngredients(Boolean specialIngredients) {
        this.specialIngredients = specialIngredients;
    }

    public void calculatePrice() {
        int price;

        switch (diameter) {
            case 20:
                if (!specialIngredients) {
                    price = this.price = 4500;
                } else {
                    price = this.price = 4500 + additionalSpecialIngredients20;
                }
                break;
            case 30:
                if (!specialIngredients) {
                    price = this.price = 4800;
                } else {
                    price = this.price = 4800 + additionalSpecialIngredients30;
                }
                break;
            case 40:
                if (!specialIngredients) {
                    price = this.price = 5500;
                } else {
                    price = this.price = 5500 + additionalSpecialIngredients40;
                }
                break;
            default:
                price = this.price;
                break;
        }
    }

    public void calculateArea() {
        this.area = Math.PI * Math.pow((double) this.diameter / 2, 2);
    }
}
