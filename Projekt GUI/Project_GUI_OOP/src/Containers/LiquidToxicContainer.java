package Containers;

import Interfaces.Liquidable;

import java.util.Scanner;

public class LiquidToxicContainer
            extends ToxicContainer
                implements Liquidable{

    private String toxicity;

    public LiquidToxicContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String location, String toxicity) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location);
        this.toxicity = toxicity;
    }

    public static LiquidToxicContainer createNewContainer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please set the name of sender: ");
        String sender = scanner.nextLine();

        System.out.println("Please set the weight without package: ");
        double weightWithoutPackage = scanner.nextDouble();

        System.out.println("Please set the safetySystems: ");
        String safetySystems = scanner.nextLine();
        scanner.nextLine();

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

        System.out.println("Please set the toxicity of the container: ");
        String toxicity = scanner.nextLine();

        return new LiquidToxicContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location, toxicity);
    }

    @Override
    public boolean isLiquid() {
        return true;
    }
}
