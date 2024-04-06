package ar.edu.unju.fi.ejercicio9.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Producto {
    private String nombre;
    private Integer codigo;
    private Double precio;
    private Byte descuento;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Byte getDescuento() {
        return descuento;
    }
    public void setDescuento(Byte descuento) {
        this.descuento = descuento;
    }

    /**
     * Cálcula el precio final de un producto con descuento (si lo tuviere).
     */
    public double calcularDescuento() {
        return this.precio - (this.precio * ((double) this.descuento / 100));
    }

    /**
     * Muestra los datos del producto.
     */
    public void mostrarInformacionDelProducto() {
        String informacionDelProducto;

        informacionDelProducto = """
                Información del producto
                Nombre del producto: %s
                Código: %d
                Precio: %.2f
                Descuento: %d %%
                """.formatted(
                    nombre,
                    codigo,
                    precio,
                    descuento
                );

        System.out.println(informacionDelProducto);
    }
}
