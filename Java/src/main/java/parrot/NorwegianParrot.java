package parrot;
import static parrot.ParrotTypeEnum.NORWEGIAN_BLUE;

public class NorwegianParrot extends Parrot {
    protected NorwegianParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(NORWEGIAN_BLUE, numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }
}
