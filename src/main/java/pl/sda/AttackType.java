package pl.sda;

public enum AttackType {
    HOOK(20),
    JAB(10),
    UPPERCUT(30),
    BELOW_THE_BELT(666666666);

    int strentgh;

    AttackType(int strentgh) {
        this.strentgh = strentgh;
    }

    public int getStrentgh() {
        return strentgh;
    }

    public static AttackType randomize(int random) {
        switch (random) {
            case 0: return HOOK;
            case 1: return JAB;
            case 2: return UPPERCUT;
            default:
                System.out.println("Hits below the belt!");
                return BELOW_THE_BELT;
        }
    }
}

