package ar.edu.unju.fi.ejercicio9.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Product {
    private String name;
    private Integer code;
    private Double price;
    private Byte discount;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getDiscount() {
        return discount;
    }

    public void setDiscount(Byte discount) {
        this.discount = discount;
    }

    /**
     * Cálcula el precio final de un producto con descuento (si lo tuviere).
     */
    public double calculateProductWithDiscount() {
        return this.price - (this.price * ((double) this.discount / 100));
    }

    /**
     * Muestra los datos del producto.
     */
    public void showInformation() {
        String information;

        information = """
                Información del product
                Nombre del product: %s
                Código: %d
                Precio: %.2f
                Descuento: %d %%
                """.formatted(
                        name,
                        code,
                        price,
                        discount
                );

        System.out.println(information);
    }
}
