package parrot;

public class AfricanParrot extends Parrot {
    protected AfricanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.AFRICAN, numberOfCoconuts, voltage, isNailed);
    }
}
