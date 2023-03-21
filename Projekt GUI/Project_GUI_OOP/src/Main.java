import Exceptions.MaxPayloadOfContainers;
import Exceptions.ZeroPayloadAchieved;

public class Main {
    public static void main(String[] args) throws ZeroPayloadAchieved, MaxPayloadOfContainers, InterruptedException {

        Ship ship1 = new Ship("Alicja", "Gdansk", "Warszawa", "Gdansk", 22, 22, 222, 22, 22);
        Ship ship2 = new Ship("Anjelica", "Gdansk", "Warszawa", "Gdansk", 22, 22, 222, 22, 22);
        Ship ship3 = new Ship("Victoria", "Gdansk", "Warszawa", "Gdansk", 22, 22, 222, 22, 22);
        Ship ship4 = new Ship("Jagoda", "Gdansk", "Warszawa", "Gdansk", 22, 22, 222, 22, 22);
        Ship ship5 = new Ship("Bratoslawa", "Gdansk", "Warszawa", "Gdansk", 22, 22, 222, 22, 22);

        Menu.ships.add(ship1);
        Menu.ships.add(ship2);
        Menu.ships.add(ship3);
        Menu.ships.add(ship4);
        Menu.ships.add(ship5);

        Menu menu = new Menu();

        menu.startMenu();


    }
}
