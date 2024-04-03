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
        final double cosineOfZeroPointFive = Math.cos(0.5f);

        final String exerciseAnswer = """
            El nombre de un país: %s
            La edad de una persona: %d
            La altura de un edificio: %.2f
            El precio de un producto de supermercado: %.2f
            Número de teléfono: %s
            El cálculo de coseno de 0.5: %.2f""".formatted(
                countryName,
                personAge,
                buildingHeight,
                productPrice,
                phoneNumber,
                cosineOfZeroPointFive
            );

        System.out.println(exerciseAnswer);
    }

}
