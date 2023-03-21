package Containers;

import java.util.Scanner;

public class ExplosiveContainer extends HeavyContainer{

    private String material;

    public ExplosiveContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String location, String material) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location);
        this.material = material;
    }

    public static ExplosiveContainer createNewContainer(){
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

        System.out.println("Please set the material inside of container: ");
        String material = scanner.nextLine();

        return new ExplosiveContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location, material);
    }

    @Override
    public boolean isExplosive() {
        return true;
    }
}
