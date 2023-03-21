package Exceptions;

public class ZeroPayloadAchieved extends Exception {
    String reason;

    public ZeroPayloadAchieved(String reason) {
        super(reason);
        this.reason = reason;
    }

    public String toString() {
        return reason;
    }
}