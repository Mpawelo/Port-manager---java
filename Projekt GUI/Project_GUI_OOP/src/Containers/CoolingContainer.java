package Containers;

import java.util.Scanner;

public class CoolingContainer extends HeavyContainer{

    protected String packageInside;         //additional feature

    public CoolingContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String location, String packageInside) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location);
        this.packageInside = packageInside;
    }

    public static CoolingContainer createNewContainer(){
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

        System.out.println("Please set the bruttoWeight: ");
        double bruttoWeight = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Please set the  certificates of container: ");
        String certificates = scanner.nextLine();

        System.out.println("Please set the location of container: ");
        String location = scanner.nextLine();

        System.out.println("Please set the package inside: ");
        String packageInside = scanner.nextLine();

        return new CoolingContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location, packageInside);
    }

    @Override
    public boolean isElectrical() {
        return true;
    }
}
