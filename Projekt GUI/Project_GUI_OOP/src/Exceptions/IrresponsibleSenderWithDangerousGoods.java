package Exceptions;

import Containers.ClassicContainer;

public class IrresponsibleSenderWithDangerousGoods extends Exception{
    private ClassicContainer container;

    public IrresponsibleSenderWithDangerousGoods(ClassicContainer container){
        this.container = container;
    }

    public String toString(){
        return container.getId() + " ";
    }
}
