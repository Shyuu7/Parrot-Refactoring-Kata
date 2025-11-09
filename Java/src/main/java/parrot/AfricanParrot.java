package parrot;

public class AfricanParrot extends Parrot {
    protected int numberOfCoconuts;
    private static final double LOAD_FACTOR = 9.0;

    protected AfricanParrot(int numberOfCoconuts) {
        super();
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - LOAD_FACTOR * numberOfCoconuts);
    }

    @Override
    public String getCry() {
        return "Sqaark!";
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }
}
