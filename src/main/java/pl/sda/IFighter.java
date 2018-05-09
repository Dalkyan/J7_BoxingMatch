package pl.sda;

public interface IFighter {
    String getName();
    int getHp();

    AttackType getAttackAction();
    BlockType getBlockAction();

    void decreaseHp();
    boolean isAlive();

}
