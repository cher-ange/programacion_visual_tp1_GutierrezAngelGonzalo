package ar.edu.unju.fi.ejercicio2;

/**
 * 2. Uso de variables.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final String nombreDeUnPais = "Argentina";
        final int edadDeUnaPersona = 34;
        final double alturaDeUnEdificio = 24.6d;
        final double precioDeUnProducto = 18.4d;
        final String numeroDeTelefono = "3881112222";
        final double cocenoDeCeroPuntoCinco = Math.cos(0.5f);

        final String respuesta = """
            El nombre de un país: %s
            La edad de una persona: %d
            La altura de un edificio: %.2f
            El precio de un producto de supermercado: %.2f
            Número de teléfono: %s
            El cálculo de coseno de 0.5: %.2f""".formatted(
                nombreDeUnPais,
                edadDeUnaPersona,
                alturaDeUnEdificio,
                precioDeUnProducto,
                numeroDeTelefono,
                cocenoDeCeroPuntoCinco
            );

        System.out.println(respuesta);
    }
}
