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
        return Math.max(0, BASE_SPEED - LOAD_FACTOR * numberOfCoconuts);
    }

    @Override
    public String getCry() {
        return "Sqaark!";
    }
}
