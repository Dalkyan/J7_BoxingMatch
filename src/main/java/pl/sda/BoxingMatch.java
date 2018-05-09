package pl.sda;

import java.util.Random;

public class BoxingMatch implements IFight {
    private IFighter boxer1;
    private IFighter boxer2;

    public BoxingMatch(IFighter boxer1, IFighter boxer2) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
    }

    @Override
    public void fight() {
        IFighter first;
        IFighter second;

        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            first = boxer1;
            second = boxer2;
        } else {
            first = boxer2;
            second = boxer1;
        }

        boolean isFightOver = false;
        IFighter winner = null;
        while (!isFightOver) {
            AttackType attack_f1 = first.getAttackAction();
            BlockType block_f2 = second.getBlockAction();
            HitOutcome hitOutcome = isHitSuccessfull(attack_f1, block_f2);
            checkDamage(first, second, hitOutcome);
            if (!second.isAlive()) {
                winner = first;
                break;
            }

            System.out.println(first.getName() + " zadaje cios " + attack_f1);
            System.out.println(second.getName() + " ma wciąż " + second.getHp() + " HP");

            AttackType attack_f2 = second.getAttackAction();
            BlockType blockType_f1 = first.getBlockAction();
            hitOutcome = isHitSuccessfull(attack_f2, blockType_f1);
            checkDamage(second, first, hitOutcome);
            if (!first.isAlive()) {
                winner = second;
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(second.getName() + " zadaje cios " + attack_f2);
            System.out.println(first.getName() + " ma wciąż " + first.getHp() + " HP");
        }
        System.out.println("Zwycięzcą jest " + winner.getName());
    }

    private void checkDamage(IFighter first, IFighter second, HitOutcome hitOutcome) {
        if (HitOutcome.FULL.equals(hitOutcome)) {
            second.decreaseHp();
        }
    }

    private HitOutcome isHitSuccessfull(AttackType attack_f1, BlockType block_f2) {
        return HitOutcome.FULL;
    }
}
