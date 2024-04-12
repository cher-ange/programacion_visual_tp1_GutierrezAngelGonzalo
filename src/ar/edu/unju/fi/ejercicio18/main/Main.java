package ar.edu.unju.fi.ejercicio18.main;

import ar.edu.unju.fi.ejercicio18.model.Country;
import ar.edu.unju.fi.ejercicio18.model.TouristicDestiny;

import java.util.*;

/**
 * 18. Interfaz <code>List</code> - Manejo de Excepciones.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    //region Static Objects
    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Country> countries = new ArrayList<>();

    /* List of countries initialization */
    static {
        countries.add(new Country("Argentina"));
        countries.add(new Country("Bolivia"));
        countries.add(new Country("Brasil"));
        countries.add(new Country("Chile"));
        countries.add(new Country("Colombia"));
        countries.add(new Country("Ecuador"));
        countries.add(new Country("Paraguay"));
        countries.add(new Country("Perú"));
        countries.add(new Country("Uruguay"));
        countries.add(new Country("Venezuela"));
    }
    //endregion

    public static void main(String[] args) {
        //region Main
        ArrayList<TouristicDestiny> touristicDestinies = new ArrayList<>();
        byte selectedOption;

        try(scanner) {
            do {
                showMenu();
                selectedOption = enterOption();
                switch (selectedOption) {
                    case 1 -> addTouristicDestiny(touristicDestinies);
                    case 2 -> showAllTouristicDestinies(touristicDestinies);
                    case 3 -> editCountryOfTouristicDestiny(touristicDestinies);
                    case 4 -> cleanListOfTouristicDestinies(touristicDestinies);
                    case 5 -> deleteTouristicDestinyByCode(
                            touristicDestinies,
                            getInteger("Ingrese el código del destino turístico a eliminar")
                    );
                    case 6 -> showTouristicDestiniesByName(touristicDestinies);
                    case 7 -> getListOfCountries();
                    case 8 -> showTouristicDestiniesByCountryCode(touristicDestinies);
                    case 9 -> System.out.println("Salir del menú");
                }
            } while (selectedOption != 9);


        } catch (InputMismatchException e) {
            errorMessage("Ocurrió un error durante la ejecución del programa");
        } finally {
            System.out.println("Fin del programa");
        }
        //endregion
    }

    //region Menu options

    /**
     * Agrega un destino turístico a la lista de destinos turísticos.
     * @param touristicDestinies Lista de destinos turísticos
     */
    public static void addTouristicDestiny(ArrayList<TouristicDestiny> touristicDestinies) {
        TouristicDestiny touristicDestiny = new TouristicDestiny();

        System.out.println("Ingrese los datos del nuevo destino turístico");
        inputTouristicDestinyData(touristicDestiny);
        touristicDestinies.add(touristicDestiny);
    }

    /**
     * Modifica los datos del país de un destino turístico solicitado por el usuario.
     * @param touristicDestinies Lista de destinos turísticos
     */
    public static void editCountryOfTouristicDestiny(ArrayList<TouristicDestiny> touristicDestinies) {
        if (touristicDestinies.isEmpty()) {
            emptyListErrorMessage();
        } else {
            TouristicDestiny touristicDestiny = getTouristicDestinyByCode(touristicDestinies);
            Country country = touristicDestiny.getCountry();
            System.out.println("Modifica el nombre del país del destino del turístico seleccionado");
            inputCountryData(country);
            System.out.println("El país ha sido modificado");
        }
    }

    /**
     * Muestra todos los destinos turísticos registrados.
     * @param touristicDestinies Lista de destinos turísticos
     */
    public static void showAllTouristicDestinies(ArrayList<TouristicDestiny> touristicDestinies) {
        if (touristicDestinies.isEmpty()) {
            emptyListErrorMessage();
        } else {
            for (TouristicDestiny touristicDestiny : touristicDestinies) {
                showTouristicDestinyInformation(touristicDestiny);
            }
        }
    }

    /**
     * Borra todos los destinos turísticos registrados.
     * @param touristicDestinies Lista de destinos turísticos
     */
    public static void cleanListOfTouristicDestinies(ArrayList<TouristicDestiny> touristicDestinies) {
        touristicDestinies.clear();
    }

    /**
     * Elimina un destino turístico según código ingresado por el usuario.
     * @param touristicDestinies Lista de destinos turísticos
     * @param code  Código ingresado por el usuario
     */
    public static void deleteTouristicDestinyByCode(ArrayList<TouristicDestiny> touristicDestinies, int code) {
        if (touristicDestinies.isEmpty()) {
            emptyListErrorMessage();
        } else {
            Iterator<TouristicDestiny> iterator = touristicDestinies.iterator();
            TouristicDestiny touristicDestiny;
            boolean touristicDestinyFound = false;

            while (iterator.hasNext()) {
                touristicDestiny = iterator.next();
                if (touristicDestiny.getCode() == code) {
                    iterator.remove();
                    touristicDestinyFound = true;
                }
            }

            if (!touristicDestinyFound) {
                touristicDestinyNotFoundErrorMessage(code);
            } else {
                deletedTouristicDestinyMessage(code);
            }
        }
    }

    /**
     * Muestra los destinos turísticos por nombre.
     * @param touristicDestinies Lista de destinos turísticos
     */
    public static void showTouristicDestiniesByName(ArrayList<TouristicDestiny> touristicDestinies) {
        if (touristicDestinies.isEmpty()) {
            emptyListErrorMessage();
        } else {
            touristicDestinies.sort(Comparator.comparing(TouristicDestiny::getName));
            for (TouristicDestiny touristicDestiny : touristicDestinies) {
                showTouristicDestinyInformation(touristicDestiny);
            }
        }
    }

    /**
     * Muestra los destinos turísticos por país.
     * @param touristicDestinies Lista de destinos turísticos
     */
    public static void showTouristicDestiniesByCountryCode(ArrayList<TouristicDestiny> touristicDestinies) {
        if (touristicDestinies.isEmpty()) {
            emptyListErrorMessage();
        } else {
            Country countryFound = getCountryByCode("Ingrese el código del país");
            int counter = 0;
            for (TouristicDestiny touristicDestiny : touristicDestinies) {
                if (touristicDestiny.getCountry().equals(countryFound)) {
                    showTouristicDestinyInformation(touristicDestiny);
                    ++counter;
                }
            }

            if (counter == 0) {
                System.out.printf("No se encontraron destinos turísticos asociados al pais %s%n", countryFound.getName());
            }
        }
    }
    //endregion

    //region Helpers

    /**
     * Permite el ingreso de los datos de un destino turístico.
     * @param touristicDestiny Destino turístico
     */
    public static void inputTouristicDestinyData(TouristicDestiny touristicDestiny) {
//        touristicDestiny.setCode(getInteger("Introduce el código"));
        touristicDestiny.setName(getString("Introduce el nombre"));
        touristicDestiny.setPrice(getDouble("Introduce el precio"));
        touristicDestiny.setAmountOfDays(getInteger("Introduce la cantidad de días"));
        touristicDestiny.setCountry(getCountryByCode("Ingrese el código del país"));
    }

    public static void inputCountryData(Country country) {
//        country.setCode(getInteger("Introduce el código"));
        country.setName(getString("Introduce el nombre"));
    }

    /**
     * Encuentra un destino turístico según su código.
     * @param touristicDestinies Lista de destinos turísticos
     * @return Un destino turístico
     */
    public static TouristicDestiny getTouristicDestinyByCode(ArrayList<TouristicDestiny> touristicDestinies) {
        int touristicDestinyCode;

        while (true) {
//            showAllTouristicDestinies(touristicDestinies);
            touristicDestinyCode = getInteger("Ingresar código del destino turístico");

            if (findTouristicDestinyByCode(touristicDestinies, touristicDestinyCode)) {
                return touristicDestinies.get(touristicDestinyCode - 1);
            } else {
                errorMessage("El código ingresado no corresponde a ningún destino turístico registrado, intente una vez más");
            }
        }
    }

    public static boolean findTouristicDestinyByCode(ArrayList<TouristicDestiny> touristicDestinies, int code) {
        for (TouristicDestiny touristicDestiny : touristicDestinies) {
            if (touristicDestiny.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * Encuentra un país según su código.
     * @param message Mensaje de búsqueda
     * @return Un país
     */
    public static Country getCountryByCode(String message) {
        int countryCode;

        while (true) {
            getListOfCountries();
            countryCode = getInteger(message);

            if (findCountryByCode(countryCode)) {
                return countries.get(countryCode - 1);
            } else {
                errorMessage("El código ingresado no corresponde a ningún país registrado");
            }
        }
    }

    public static boolean findCountryByCode(int code) {
        for (Country country : countries) {
            if (country.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra una lista de los países almacenados.
     */
    public static void getListOfCountries() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Lista de países").append("\n");
        for (Country country : countries) {
            stringBuilder
                    .append(country.getCode())
                    .append(" - ")
                    .append(country.getName())
                    .append("\n");
        }

        System.out.print(stringBuilder);
    }

    public static void showMenu() {
        System.out.print("""
                ----- MENU -----
                1 - Alta de destino turístico
                2 - Mostrar todos los destinos turísticos
                3 - Modificar el país de un destino turístico
                4 - Borrar todos los destinos turísticos
                5 - Eliminar un destino turístico
                6 - Mostrar los destinos turísticos ordenados por nombre
                7 - Mostrar todos los países
                8 - Mostrar los destinos turísticos que pertenecen a un país
                9 - Salir
                """);
    }

    /**
     * Muestra información acerca de un destino turístico.
     * @param touristicDestiny Destino turístico
     */
    public static void showTouristicDestinyInformation(TouristicDestiny touristicDestiny) {
        System.out.print(touristicDestiny.toString());
    }

    public static String getString(String message) {
        inputMessage(message);
        return scanner.nextLine();
    }

    public static int getInteger(String message) {
        int integerValue;

        while (true) {
            inputMessage(message);
            try {
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static double getDouble(String message) {
        double doubleValue;

        while (true) {
            inputMessage(message);
            try {
                doubleValue = Double.parseDouble(scanner.nextLine());
                return doubleValue;
            } catch (NumberFormatException e) {
                errorMessage("El valor ingresado debe ser un número");
            }
        }
    }

    /**
     * Permite ingresar una opción del menú.
     * @return  <code>byte</code> que corresponde con la opción seleccionada
     */
    public static byte enterOption() {
        byte selectedOption;

        while (true) {
            try {
                inputMessage("Seleccione una opción");
                selectedOption = Byte.parseByte(scanner.nextLine());
                return selectedOption;
            } catch (NumberFormatException e) {
                errorMessage("Solo se permite el ingreso de números");
            }
        }
    }
    //endregion

    //region Messages
    public static void inputMessage(String message) {
        System.out.print(message + ": ");
    }

    private static void errorMessage(String message) {
        System.out.println("ERROR: " + message);
    }

    public static void emptyListErrorMessage() {
        System.out.println("ERROR: La lista de destinos turísticos se encuentra vacía");
    }

    public static void deletedTouristicDestinyMessage(int code) {
        System.out.printf("Se elimino el destino turístico con el código n.º %d de la lista de destinos turísticos%n", code);
    }

    public static void touristicDestinyNotFoundErrorMessage(int code) {
        System.out.printf("ERROR: El destino turístico con el código n.º %d no se encuentra en la lista de destinos turísticos%n", code);
    }
    //endregion
}
