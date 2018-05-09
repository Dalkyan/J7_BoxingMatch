package pl.sda;

public enum HitOutcome {
    DODGED(0, "Chybia!" ), PARTIAL(0.5, "Częściowe obrażenia"), FULL(1, "Wali z całej epy!");
double strength;
String message;

    HitOutcome(double strength, String message) {
        this.strength = strength;
        this.message = message;
    }

    public static HitOutcome randomize(int random) {
        switch (random) {
            case 0:
                return DODGED;
            case 1:
                return PARTIAL;
            case 2:
                return FULL;
            default:
                return FULL;
        }
    }
}
