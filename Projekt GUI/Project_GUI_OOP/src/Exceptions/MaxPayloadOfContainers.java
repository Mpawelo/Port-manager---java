package Exceptions;

public class MaxPayloadOfContainers extends Exception{
    String reason;

    public MaxPayloadOfContainers(String reason){
        super(reason);
        this.reason = reason;
    }

    public String toString(){
        return reason;
    }

}
