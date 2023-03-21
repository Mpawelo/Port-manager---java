package Containers;

import java.util.Scanner;

public class PowderToxicContainer extends ToxicContainer{

    private String typeOfPowder;

    public PowderToxicContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String location, String typeOfPowder) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location);
        this.typeOfPowder = typeOfPowder;
    }

    public static PowderToxicContainer createNewContainer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please set the name of sender: ");
        String sender = scanner.nextLine();

        System.out.println("Please set the weight without package: ");
        double weightWithoutPackage = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Please set the safetySystems: ");
        String safetySystems = scanner.nextLine();

        System.out.println("Please set the nettoWeight: ");
        double nettoWeight = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Please set the bruttoWeight: ");
        double bruttoWeight = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Please set the  certificates of the container: ");
        String certificates = scanner.nextLine();

        System.out.println("Please set the location of the container: ");
        String location = scanner.nextLine();

        System.out.println("Please set the powder type of the container: ");
        String typeOfPowder = scanner.nextLine();

        return new PowderToxicContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location, typeOfPowder);
    }

}
