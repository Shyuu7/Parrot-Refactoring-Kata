package parrot;

public abstract class Parrot {
    protected static final double BASE_SPEED = 12.0;

    protected Parrot() {
    }
    public abstract double getSpeed();

    public abstract String getCry();
}
