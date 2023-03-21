package Containers;

import java.util.Scanner;

public class ClassicContainer extends Container
                                implements Comparable<ClassicContainer>{
    private static int idOfContainers = 1;

    protected int id;
    protected String sender;
    protected double weightWithoutPackage;
    protected String safetySystems;
    protected double nettoWeight;
    protected double bruttoWeight;
    protected String certificates;

    public ClassicContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates){
        this.id = idOfContainers++;
        this.sender = sender;
        this.weightWithoutPackage = weightWithoutPackage;
        this.safetySystems = safetySystems;
        this.nettoWeight = nettoWeight;
        this.bruttoWeight = bruttoWeight;
        this.certificates = certificates;
    }

    public static ClassicContainer createNewContainer(){
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

        System.out.println("Please set the certificates of container: ");
        String certificates = scanner.nextLine();

        return new ClassicContainer(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates);
    }


    public double getBruttoWeight() {
        return bruttoWeight;
    }

    public int getId() {
        return id;
    }

    public String getSender(){
        return sender;
    }

    @Override
    public boolean isHeavy() {
        return false;
    }

    @Override
    public boolean isElectrical() {
        return false;
    }

    @Override
    public boolean isExplosive() {
        return false;
    }

    @Override
    public boolean isToxic() {
        return false;
    }

    @Override
    public int compareTo(ClassicContainer o) {
        return o.getId() - id;
    }
}
