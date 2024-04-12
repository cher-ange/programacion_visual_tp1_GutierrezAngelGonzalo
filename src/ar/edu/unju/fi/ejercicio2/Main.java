package ar.edu.unju.fi.ejercicio2;

/**
 * 2. Uso de variables.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final String countryName = "Argentina";
        final int personAge = 34;
        final double buildingHeight = 24.6d;
        final double productPrice = 18.4d;
        final String phoneNumber = "3881112222";
        final double cosineOf0point5 = Math.cos(0.5f);

        final String answer = """
            El nombre de un país: %s
            La edad de una person: %d
            La altura de un edificio: %.2f
            El precio de un product de supermercado: %.2f
            Número de teléfono: %s
            El cálculo de coseno de 0.5: %.2f""".formatted(
                countryName,
                personAge,
                buildingHeight,
                productPrice,
                phoneNumber,
                cosineOf0point5
            );

        System.out.println(answer);
    }
}
