package Containers;

public abstract class ToxicContainer extends HeavyContainer {

    public ToxicContainer(String sender, double weightWithoutPackage, String safetySystems, double nettoWeight, double bruttoWeight, String certificates, String location) {
        super(sender, weightWithoutPackage, safetySystems, nettoWeight, bruttoWeight, certificates, location);
    }

    @Override
    public boolean isToxic() {
        return true;
    }
}
