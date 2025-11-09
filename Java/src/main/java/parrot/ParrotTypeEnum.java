package parrot;

public enum ParrotTypeEnum {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE;

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        Parrot parrot;
        parrot = switch (type) {
            case EUROPEAN -> new EuropeanParrot();
            case AFRICAN -> new AfricanParrot(numberOfCoconuts);
            case NORWEGIAN_BLUE -> new NorwegianParrot(voltage, isNailed);
        };
        return parrot;
    }
}
