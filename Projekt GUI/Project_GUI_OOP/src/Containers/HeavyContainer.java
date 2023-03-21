package Containers;

import java.util.Scanner;

public class HeavyContainer extends ClassicContainer{

    protected String location; //additional

    public HeavyContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String location) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates);
        this.location = location;
    }

    public static HeavyContainer createNewContainer(){
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

        System.out.println("Please set the  certificates of container: ");
        String certificates = scanner.nextLine();

        System.out.println("Please set the location of container: ");
        String location = scanner.nextLine();

        return new HeavyContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location);
    }

    @Override
    public boolean isHeavy() {
        return true;
    }
}
