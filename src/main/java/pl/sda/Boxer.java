package pl.sda;

public class Boxer implements IFighter {

    private String name;
    private int hp;

    public Boxer(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public AttackType getAttackAction() {
        return AttackType.HOOK;
    }

    @Override
    public BlockType getBlockAction() {
        return BlockType.DODGE;
    }

    @Override
    public void decreaseHp() {
        hp--;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}
