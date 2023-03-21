import Containers.*;
import Exceptions.MaxPayloadOfContainers;
import Exceptions.ZeroPayloadAchieved;

import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    static LinkedList<Ship> ships = new LinkedList<Ship>();

    LinkedList<ClassicContainer> containers = new LinkedList<>();

    Train train = new Train();
    Warehouse warehouse = new Warehouse(1000);

    public void startMenu() throws MaxPayloadOfContainers, ZeroPayloadAchieved, InterruptedException {
        System.out.println("\n");
        System.out.println("Please chooose the action");
        System.out.println("1. Start the game");

        System.out.print("Your choose: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1: startGameMenu();
            break;
            default:
                System.out.println("Pick the right choose");
                clearConsole();
                startMenu();
            break;
        }
    }

    public void startGameMenu() throws MaxPayloadOfContainers, ZeroPayloadAchieved, InterruptedException {
        clearConsole();
        int option = 1;
        while (option != 0) {
            clearConsole();
            System.out.println("Please choose the action");
            System.out.println("1. Create new ship");
            System.out.println("2. Create new container");
            System.out.println("3. Load container on ship");
            System.out.println("4. Unload container on train or warehouse");
            System.out.println("5. Show port");

            System.out.print("Your choose (0 for exit): ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    ships.add(Ship.createNewShip());
                    break;
                case 2:
                    containers.add(createNewContainerMenu());
                    break;
                case 3:
                    loadContainer();
                    break;
                case 4:
                    unloadContainer();
                    break;
                case 5:
                    System.out.println("Container: ");
                    printAllContainers();
                    System.out.println();
                    System.out.println("Ships");
                    printAllShips();
                default:
                    System.out.println("Pick the right choose");
                    startMenu();
                    break;
            }
        }
    }

    public ClassicContainer createNewContainerMenu(){
        clearConsole();
        System.out.println("Please chooose the action");
        System.out.println("1. Create Classic Container");
        System.out.println("2. Create Heavy Container");
        System.out.println("3. Create Cooling Container");
        System.out.println("4. Create Explosive Container");
        System.out.println("5. Create Liquid Container");
        System.out.println("6. Create Liquid Toxic Container");
        System.out.println("7. Create Powder Toxic Container");

        System.out.print("Your choose: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        ClassicContainer returnContainer = null;

        switch (option){
            case 1: returnContainer = ClassicContainer.createNewContainer();
                break;
            case 2: returnContainer = HeavyContainer.createNewContainer();
                break;
            case 3: returnContainer = CoolingContainer.createNewContainer();
                break;
            case 4: returnContainer = ExplosiveContainer.createNewContainer();
                break;
            case 5: returnContainer = LiquidContainer.createNewContainer();
                break;
            case 6: returnContainer = LiquidToxicContainer.createNewContainer();
                break;
            case 7: returnContainer = PowderToxicContainer.createNewContainer();
                break;
            default:
                System.out.println("Pick the right choose");
                createNewContainerMenu();
                break;
        }
        return returnContainer;
    }

    public void loadContainer()   {
        clearConsole();

        System.out.println("All the ships:");
        printAllShips();
        System.out.println("Pick the ship you want to load container on: ");
        int chosenShip = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n|--------------------------------|\n");

        int chosenContainer = 1;

        if (containers.size() > 0){
            printAllContainers();
            System.out.println("Pick the containers you want to load, press 0 to exit: ");
            chosenContainer = scanner.nextInt();
            scanner.nextLine();

            while(chosenContainer != 0 && chosenShip != 0 && containers.size() > 0) {
                try {
                    ships.get(chosenShip - 1).loadContainer(containers.get(chosenContainer - 1));
                } catch (MaxPayloadOfContainers ex) {
                    ex.toString();
                }
                containers.remove(chosenContainer - 1);

                if (containers.size() == 0)
                    System.out.println("There is no container left");
                else {
                    System.out.println("Containers to load:");
                    printAllContainers();
                }

                System.out.println("Pick the containers you want to load, press 0 to exit: ");
                chosenContainer = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }

    public void unloadContainer() throws ZeroPayloadAchieved, MaxPayloadOfContainers, InterruptedException {
        clearConsole();

        printAllShips();
        System.out.println("Pick the ship you want to unload container from:");
        int chosenShip = scanner.nextInt() - 1;
        scanner.nextLine();

        LinkedList<ClassicContainer> pickedContainers = ships.get(chosenShip).unloadContainer();

        if (pickedContainers.size() == 0) {
            System.out.println("There is no container left on this ship, pick other or go back");
        } else {
            System.out.println("Would you like to load containers from ship into warehouse or on train? (W/T");
            String answer = scanner.nextLine();

            do {
                if (answer.equals("W")) {
                    warehouse.loadContainer(pickedContainers);
                    pickedContainers.clear();
                    System.out.println("Containers load into warehouse successfully");
                } else if (answer.equals("T")) {
                    train.loadContainer(pickedContainers);
                    pickedContainers.clear();
                    System.out.println("Containers load on train successfully");
                } else {
                    System.out.println("Pick the right option");
                }
            }while(!answer.equals("W") && !answer.equals("T"));
        }
    }

    public void printAllShips(){
        for(int i = 1; i <= ships.size(); i++) {
            System.out.print(i + ". " + ships.get(i - 1).getName() + " | ");

            if (i % 3 == 0)
                System.out.println();
        }
        System.out.println("\n");
    }

    public void printAllContainers(){
        for(int i = 1; i <= containers.size(); i++) {
            System.out.print(i + ". id: " + containers.get(i - 1).getId() + " - " + containers.get(i -1).getSender() + " | ");

            if(i%3 == 0)
                System.out.println();
        }
        System.out.println("\n");
    }

    /*
    public void goBack(Method method){
        System.out.println("Would you like to go back? y/n");
        String choose = scanner.nextLine();
        if(choose == "y")
            method.invoke();
    }
     */

private void clearConsole() { //not mine: https://www.delftstack.com/howto/java/java-clear-console/
        System.out.println(System.lineSeparator().repeat(100));
    }

}
