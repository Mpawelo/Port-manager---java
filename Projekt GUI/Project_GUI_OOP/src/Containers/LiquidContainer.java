package Containers;
import Interfaces.Liquidable;

import java.util.Scanner;

public class LiquidContainer
        extends ClassicContainer
            implements Liquidable{

    private String liquidInside;

    public LiquidContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String liquidInside) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates);
        this.liquidInside = liquidInside;
    }

    public static LiquidContainer createNewContainer(){
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

        System.out.println("Please set the certificates of container: ");
        String certificates = scanner.nextLine();

        System.out.println("Please set the liquid inside of container: ");
        String liquidInside = scanner.nextLine();

        return new LiquidContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, liquidInside);
    }

    @Override
    public boolean isLiquid() {
        return true;
    }
}
