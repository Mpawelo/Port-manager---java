import Containers.ClassicContainer;
import Exceptions.MaxPayloadOfContainers;
import Exceptions.ZeroPayloadAchieved;

import java.util.LinkedList;
import java.util.Scanner;

public class Ship
        implements Comparable<Ship>{
    private String name;
    private String homePort;
    private String startLocation;
    private String destination;
    private int maxPayloadOfShip;

    private static int idOfShips = 1;
    private int id;

    private LinkedList<ClassicContainer> listOfContainers = new LinkedList<>();

    private int maxNumOfContainers;
    private int maxNumOfToxicAndExpContainers;
    private int maxNumOfHeavyContainers;
    private int maxNumOfElectricalContainers;

    private int presentNumOfContainers = 0;
    private int presentNumOfToxicAndExpContainers = 0;
    private int presentNumOfHeavyContainers = 0;
    private int presentNumOfElectricalContainers = 0;
    private int presentPayloadOfShip = 0;


    public Ship(String name, String homePort, String startLocation, String destination, int maxNumOfContainers, int maxNumOfToxicAndExpContainers, int maxNumOfHeavyContainers, int maxNumOfElectricalContainers, int maxPayloadOfShip) {
        this.name = name;
        this.homePort = homePort;
        this.startLocation = startLocation;
        this.destination = destination;
        this.id = idOfShips++;
        this.maxPayloadOfShip = maxPayloadOfShip;

        this.maxNumOfContainers = maxNumOfContainers;
        this.maxNumOfToxicAndExpContainers = maxNumOfToxicAndExpContainers;
        this.maxNumOfHeavyContainers = maxNumOfHeavyContainers;
        this.maxNumOfElectricalContainers = maxNumOfElectricalContainers;
    }

    public void loadContainer(ClassicContainer container) throws MaxPayloadOfContainers {
        if (maxNumOfContainers < presentNumOfContainers + 1)
            throw new MaxPayloadOfContainers("Max number of containers on the ship has been achieved");
        if(maxPayloadOfShip <= presentPayloadOfShip + container.getBruttoWeight())
            throw new MaxPayloadOfContainers("Max payload of the ship has been achieved");
        else {
            if (container.isToxic() || container.isExplosive()) { //doklada toxic kontenery, plyne, sypkie i explosive
                if (maxNumOfToxicAndExpContainers <= presentNumOfToxicAndExpContainers + 1)
                    throw new MaxPayloadOfContainers("Max payload this type of container has been achieved");
                else {
                    listOfContainers.add(container);
                    presentNumOfToxicAndExpContainers++;
                }
            } else if (container.isElectrical()) { //doklada wszystko co elektryczne cooling
                if (maxNumOfElectricalContainers <= presentNumOfElectricalContainers + 1)
                    throw new MaxPayloadOfContainers("Max payload this type of container has been achieved");
                else {
                    listOfContainers.add(container);
                    presentNumOfElectricalContainers++;
                }
            } else if (!(container.isHeavy())) { //doklada wszystkie NIE ciezkie kontenery, takie jak classic i liquid
                listOfContainers.add(container);
            } else if (container.isHeavy()) {
                if (maxNumOfHeavyContainers <= presentNumOfHeavyContainers + 1)
                    throw new MaxPayloadOfContainers("Max payload this type of container has been achieved");
                else {
                    listOfContainers.add(container);
                    presentNumOfHeavyContainers++;
                }
            }
            presentNumOfContainers++; //in all cases we need to increment number of basic containers
            presentPayloadOfShip += container.getBruttoWeight();
        }
    }

    public LinkedList<ClassicContainer> unloadContainer() throws ZeroPayloadAchieved {
        Scanner scanner = new Scanner(System.in);
        LinkedList<ClassicContainer> pickedContainer = new LinkedList<>();

        try {
            if (listOfContainers.size() == 0) {
                throw new ZeroPayloadAchieved("Zero payload of ship has been achived");
            } else {
                System.out.println("Containers:");
                for (int i = 1; i <= listOfContainers.size(); i++) {
                    System.out.print(i + " - " + listOfContainers.get(i-1).getSender() + " | "); //wypisuje wszystkie id konetnerow danego statku i nadawce

                    if (i % 3 == 0)
                        System.out.println();
                }
                System.out.println();

                System.out.println("Pick the containers you want to unload, press 0 to exit:");
                int chosenContainer = scanner.nextInt();
                scanner.nextLine();

                while (chosenContainer != 0) {
                    chosenContainer -= 1; //makes real index of container User put 1 so we convert it to 0

                    if (presentNumOfContainers <= 0)
                        throw new ZeroPayloadAchieved("Zero payload of this container type has been achieved");
                    else {
                        if (listOfContainers.get(chosenContainer).isToxic() || listOfContainers.get(chosenContainer).isExplosive()) {
                            if (presentNumOfToxicAndExpContainers <= 0)
                                throw new ZeroPayloadAchieved("Zero payload of this container type has been achieved");
                            else {
                                pickedContainer.add(listOfContainers.get(chosenContainer));
                                presentPayloadOfShip -= listOfContainers.get(chosenContainer).getBruttoWeight();
                                listOfContainers.remove(chosenContainer);
                                presentNumOfToxicAndExpContainers--;
                            }
                        } else if (listOfContainers.get(chosenContainer).isElectrical()) { // wszystko co elektryczne cooling
                            if (presentNumOfElectricalContainers <= 0)
                                throw new ZeroPayloadAchieved("Zero payload of this container type has been achieved");
                            else {
                                pickedContainer.add(listOfContainers.get(chosenContainer));
                                presentPayloadOfShip -= listOfContainers.get(chosenContainer).getBruttoWeight();
                                listOfContainers.remove(chosenContainer);
                                presentNumOfElectricalContainers--;
                            }
                        } else if (!(listOfContainers.get(chosenContainer).isHeavy())) { //doklada wszystkie NIE ciezkie kontenery, takie jak classic i liquid
                            pickedContainer.add(listOfContainers.get(chosenContainer));
                            presentPayloadOfShip -= listOfContainers.get(chosenContainer).getBruttoWeight();
                            listOfContainers.remove(chosenContainer);
                        } else if (listOfContainers.get(chosenContainer).isHeavy()) {
                            pickedContainer.add(listOfContainers.get(chosenContainer));
                            presentPayloadOfShip -= listOfContainers.get(chosenContainer).getBruttoWeight();
                            listOfContainers.remove(chosenContainer);
                            presentNumOfHeavyContainers--;
                        }
                        presentNumOfContainers--; //in all cases we need to increment number of basic containers

                        if (listOfContainers.size() == 0)
                            throw new ZeroPayloadAchieved("Zero payload of ship has been achived");
                        else {
                            System.out.println("Containers:");
                            for (int i = 1; i <= listOfContainers.size(); i++) {
                                System.out.print(i + " - " + listOfContainers.get(i-1).getSender() + " | "); //wypisuje wszystkie id konetnerow danego statku i nadawce

                                if (i % 3 == 0)
                                    System.out.println();
                            }
                            System.out.println();

                            System.out.println("Pick the containers you want to unload, press 0 to exit:");
                            chosenContainer = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
                }
            }
        }catch (ZeroPayloadAchieved ex) {
            ex.toString();
        }
        return pickedContainer;
    }

    public static Ship createNewShip(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please set the name of the ship: ");
        String name = scanner.nextLine();

        System.out.println("Please set the home port of the ship: ");
        String homePort = scanner.nextLine();

        System.out.println("Please set the start location of the ship: ");
        String startLocation = scanner.nextLine();

        System.out.println("Please set the destination of the ship: ");
        String destination = scanner.nextLine();

        System.out.println("Please set the max payload of the ship: ");
        int maxPayloadOfShip = scanner.nextInt();

        System.out.println("Please set the max number of containers: ");
        int maxNumOfContainers = scanner.nextInt();

        System.out.println("Please set the max number of the toxic and explosive containers: ");
        int maxNumOfToxicAndExpContainers = scanner.nextInt();

        System.out.println("Please set the max number of the heavy containers: ");
        int maxNumOfHeavyContainers = scanner.nextInt();

        System.out.println("Please set the max number of electrical containers: ");
        int maxNumOfElectricalContainers = scanner.nextInt();

        System.out.println("Ship succesfully created! Welcome onboard " + name);
        return new Ship(name, homePort, startLocation, destination, maxNumOfContainers, maxNumOfToxicAndExpContainers, maxNumOfHeavyContainers, maxNumOfElectricalContainers, maxPayloadOfShip);
    }

    public LinkedList<ClassicContainer> getListOfContainers(){
        return listOfContainers;
    }

    public LinkedList<ClassicContainer> setListOfContainers(){
        return listOfContainers;
    }

    public String getName(){
        return name;
   }

    @Override
    public String toString() {
        return "Info of: Ship " + name + '\n' +
                " name='" + name + '\'' + '\n' +
                " homePort='" + homePort + '\'' + '\n' +
                " startLocation='" + startLocation + '\'' + '\n' +
                " destination='" + destination + '\'' + '\n' +
                " maxPayloadOfShip=" + maxPayloadOfShip + '\n' +
                " id=" + id + '\n' + '\n' +
                " maxNumOfContainers=" + maxNumOfContainers + '\n' +
                " maxNumOfToxicAndExpContainers=" + maxNumOfToxicAndExpContainers + '\n' +
                " maxNumOfHeavyContainers=" + maxNumOfHeavyContainers + '\n' +
                " maxNumOfElectricalContainers=" + maxNumOfElectricalContainers + '\n' + '\n' +
                " presentNumOfContainers=" + presentNumOfContainers + '\n' +
                " presentNumOfToxicAndExpContainers=" + presentNumOfToxicAndExpContainers + '\n' +
                " presentNumOfHeavyContainers=" + presentNumOfHeavyContainers + '\n' +
                " presentNumOfElectricalContainers=" + presentNumOfElectricalContainers + '\n' +
                " presentPayloadOfShip=" + presentPayloadOfShip;
    }

    @Override
    public int compareTo(Ship o) {
        return o.getName().charAt(0) - name.charAt(0);
    }
}
