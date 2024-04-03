package ar.edu.unju.fi.ejercicio2;

public class Main {

    public static void main(String[] args) {
        String countryName = "Argentina";
        int personAge = 34;
        double buildingHeight = 24.6d;
        double productPrice = 18.4d;
        String phoneNumber = "3881112222";
        double cosineOfZeroPointFive = Math.cos(0.5f);

        String outputMessage = """
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

        System.out.println(outputMessage);
    }

}
