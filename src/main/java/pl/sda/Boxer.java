package pl.sda;

import java.util.Random;

public class Boxer implements IFighter {

    private String name;
    private int hp;
    private int strength;

    public Boxer(String name, int hp, int strength) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
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

        Random random = new Random();

        return AttackType.randomize(random.nextInt(3));
    }

    @Override
    public BlockType getBlockAction() {
        return BlockType.DODGE;
    }

    @Override
    public void decreaseHp(double v) {
        hp = hp - (int) v;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}
