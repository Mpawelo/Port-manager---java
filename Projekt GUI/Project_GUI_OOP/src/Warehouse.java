import Containers.ClassicContainer;
import Exceptions.MaxPayloadOfContainers;

import java.util.LinkedList;

public class Warehouse{
    LinkedList<ClassicContainer> containers = new LinkedList<>();
    private int maxNumOfContainers;
    private int presentNumOfContainers = 0;

    public Warehouse(int maxNumOfContainers){
        this.maxNumOfContainers = maxNumOfContainers;
    }

    public void loadContainer(LinkedList<ClassicContainer> container) throws MaxPayloadOfContainers {
        if(maxNumOfContainers < presentNumOfContainers + container.size())
            throw new MaxPayloadOfContainers("Max number of containers in Warehouse has been achieved");
        else{
            for(ClassicContainer tmpContainer : container) {
                containers.add(tmpContainer);
            }
            presentNumOfContainers += container.size();
        }
    }
}
