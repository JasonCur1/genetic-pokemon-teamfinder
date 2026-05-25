package model;

public class Move {
    private final String name;
    private final Type type;
    private final int basePower;
    private final int maxPp;
    private int currentPp;

    public Move(String name, Type type, int basePower, int maxPp) {
        this.name = name;
        this.type = type;
        this.basePower = basePower;
        this.maxPp = maxPp;
        this.currentPp = maxPp;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getBasePower() {
        return basePower;
    }

    public int getMaxPp() {
        return maxPp;
    }

    public int getCurrentPp() {
        return currentPp;
    }

    public void setCurrentPp(int currentPp) {
        this.currentPp = currentPp;
    }

    public Move clone() {
        Move copy = new Move(this.name, this.type, this.basePower, this.maxPp);
        copy.currentPp = this.currentPp;
        return copy;
    }
}
