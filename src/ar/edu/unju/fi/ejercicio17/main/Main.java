package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 17. <code>Array</code>.
 *
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Main {
    //region Static Objects
    static final Scanner scanner = new Scanner(System.in);
    //endregion

    //region Main
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        byte selectedOption;

        try(scanner) {
            do {
                showMenu();
                selectedOption = enterOption();

                switch (selectedOption) {
                    case 1 -> addPlayer(players);
                    case 2 -> showPlayerData(
                            players,
                            getString("Ingresar nombre"),
                            getString("Ingresar apellido")
                    );
                    case 3 -> showPlayersByLastName(players);
                    case 4 -> editPlayer(
                            players,
                            getString("Ingresar nombre"),
                            getString("Ingresar apellido")
                    );
                    case 5 -> deletePlayer(
                            players,
                            getString("Ingresar nombre"),
                            getString("Ingresar apellido")
                    );
                    case 6 -> System.out.println("La cantidad de jugadores registrados es: " + players.size());
                    case 7 -> showPlayersByNationality(
                            players,
                            getString("Ingresar nacionalidad")
                    );
                    case 8 -> System.out.println("Salir del menú");
                    default -> errorMessage("Opción incorrecta, intente una vez más");

                }
            } while (selectedOption != 8);

        } catch (InputMismatchException e) {
            errorMessage("Ocurrió un error durante la ejecución del programa");
        } finally {
            System.out.println("Fin del programa");
        }
    }
    //endregion

    //region Menu options

    /**
     * Agrega un jugador a la lista de jugadores.
     * @param players   Una lista
     */
    public static void addPlayer(ArrayList<Player> players) {
        Player player = new Player();
        System.out.println("Ingrese los datos del nuevo jugador");
        inputPlayerData(player);
        players.add(player);
    }

    /**
     * Muestra información acerca de un jugador solicitado por el usuario.
     * @param players   Lista de jugadores
     * @param name      Nombre del jugador
     * @param lastName  Apellido del jugador
     */
    public static void showPlayerData(ArrayList<Player> players, String name, String lastName) {
        if (players.isEmpty()) {
            emptyListErrorMessage();
        } else {
            boolean playerFound = false;

            for (Player player : players) {
                if (player.getName().equals(name) && player.getLastName().equals(lastName)) {
                    player.showInformation();
                    playerFound = true;
                    break;
                }
            }

            if (!playerFound) {
                playerNotFoundErrorMessage(name, lastName);
            }
        }
    }

    /**
     * Muestra a los jugadores ordenados (orden ascendente) por su apellido.
     * @param players   Lista de jugadores
     */
    public static void showPlayersByLastName(ArrayList<Player> players) {
        if (players.isEmpty()) {
            emptyListErrorMessage();
        } else {
            players.sort(Comparator.comparing(Player::getLastName));
            for (Player player : players) {
                player.showInformation();
            }
        }
    }

    /**
     * Modifica los datos de un jugador solicitado por el usuario.
     * @param players   Lista de jugadores
     * @param name      Nombre del jugador
     * @param lastName  Apellido del jugador
     */
    public static void editPlayer(ArrayList<Player> players, String name, String lastName) {
        if (players.isEmpty()) {
            emptyListErrorMessage();
        } else {
            boolean playerFound = false;

            for (Player player : players) {
                if (player.getName().equals(name) && player.getLastName().equals(lastName)) {
                    inputPlayerData(player);
                    playerFound = true;
                    break;
                }
            }

            if (!playerFound) {
                playerNotFoundErrorMessage(name, lastName);
            } else {
                modifiedPlayerMessage(name, lastName);
            }
        }
    }

    /**
     * Elimina a un jugador solicitado por el usuario de la lista de jugadores.
     * @param players   Lista de jugadores
     * @param name      Nombre del jugador
     * @param lastName  Apellido del jugador
     */
    public static void deletePlayer(ArrayList<Player> players, String name, String lastName) {
        if (players.isEmpty()) {
            emptyListErrorMessage();
        } else {
            Iterator<Player> iterator = players.iterator();
            Player player;
            boolean playerFound = false;

            while (iterator.hasNext()) {
                player = iterator.next();
                if (player.getName().equals(name) && player.getLastName().equals(lastName)) {
                    iterator.remove();
                    playerFound = true;
                }
            }

            if (!playerFound) {
                playerNotFoundErrorMessage(name, lastName);
            } else {
                deletedPlayerMessage(name, lastName);
            }
        }
    }

    /**
     * Muestra a los jugadores según nacionalidad solicitada por el usuario.
     * @param players       Lista de jugadores
     * @param nationality   Nacionalidad
     */
    public static void showPlayersByNationality(ArrayList<Player> players, String nationality) {
        if (players.isEmpty()) {
            emptyListErrorMessage();
        } else {
            int counter = 0;
            for (Player player : players) {
                if (player.getNationality().equals(nationality)) {
                    counter++;
                }
            }
            playersByNationalityFoundMessage(nationality, counter);
        }
    }
    //endregion

    //region Helpers

    /**
     * Permite el ingreso de los datos de un jugador.
     * @param player    Un jugador con sus datos completos
     */
    public static void inputPlayerData(Player player) {
        player.setName(getString("Ingresar nombre"));
        player.setLastName(getString("Ingresar apellido"));
        player.setBirthDate(getBirthdate());
        player.setNationality(getString("Ingresar nacionalidad"));
        player.setHeight(getDouble("Ingresar estatura"));
        player.setWeight(getDouble("Ingresar peso"));
        player.setPosition(getPosition());
    }

    public static String getString(String message) {
        inputMessage(message);
        return scanner.nextLine();
    }

    /**
     * Ingresa la posición del jugador
     * @return  <code>String</code> de la posición del jugador escogida
     */
    public static String getPosition() {
        String[] positions = {
                "Delantero",
                "Medio",
                "Defensa",
                "Arquero"
        };
        byte position;

        while (true) {
            try {
                System.out.print("""
                        Ingresar posición
                        1 - Delantero
                        2 - Medio
                        3 - Defensa
                        4 - Arquero
                        """);
                inputMessage("Seleccione una opción");
                position = Byte.parseByte(scanner.nextLine());

                if (position < 1 || position > 4) {
                    errorMessage("Seleccione una opción validá");
                } else {
                    return positions[position - 1];
                }
            } catch (NumberFormatException e) {
                errorMessage("Solo se permiten el ingreso de números enteros");
            }
        }
    }

    public static LocalDate getBirthdate() {
        final int day, month, year;

        System.out.println("Ingresar fecha de nacimiento");
        day = getInteger("Día");
        month = getInteger("Mes");
        year = getInteger("Año");

        return LocalDate.of(year, month, day);
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

    public static void showMenu() {
        System.out.print("""
                ----- MENU -----
                1 - Alta del jugador
                2 - Mostrar los datos del jugador
                3 - Mostrar todos los players ordenados por apellido
                4 - Modificar los datos de un jugador
                5 - Eliminar un jugador
                6 - Mostrar la cantidad total de jugadores
                7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad
                8 - Salir
                """);
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

    public static void errorMessage(String message) {
        System.out.println("ERROR: " + message);
    }

    public static void emptyListErrorMessage() {
        System.out.println("ERROR: La lista de jugadores se encuentra vacía");
    }

    public static void deletedPlayerMessage(String name, String lastName) {
        System.out.printf("Se elimino al jugador %s %s de la lista de jugadores%n", name, lastName);
    }

    public static void modifiedPlayerMessage(String name, String lastName) {
        System.out.printf("El jugador %s %s ha sido modificado%n", name, lastName);
    }

    public static void playerNotFoundErrorMessage(String name, String lastName) {
        System.out.printf("ERROR: El jugador %s %s no se encuentra en la lista de jugadores%n", name, lastName);
    }

    public static void playersByNationalityFoundMessage(String nationality, int quantity) {
        System.out.printf("Cantidad de jugadores %ss: %d%n", nationality, quantity);
    }
    //endregion
}
