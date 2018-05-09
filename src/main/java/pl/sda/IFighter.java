package pl.sda;

public interface IFighter {
    String getName();
    int getHp();
    int getStrength();

    AttackType getAttackAction();
    BlockType getBlockAction();

    void decreaseHp(double v);
    boolean isAlive();

}
