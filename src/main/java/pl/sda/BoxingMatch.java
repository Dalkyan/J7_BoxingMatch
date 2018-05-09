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
            Clash clash = new Clash(first, second, winner).invoke();
            winner = clash.getWinner();
            if (clash.isFightOver()) {
                break;}

            Clash clash2 = new Clash(second, first, winner).invoke();
            winner = clash2.getWinner();
            if (clash2.isFightOver()){
                break;
            }


//
//            AttackType attack_f2 = second.getAttackAction();
//            BlockType blockType_f1 = first.getBlockAction();
//            hitOutcome = isHitSuccessfull(attack_f2, blockType_f1);
//            checkDamage(second, first, hitOutcome);
//
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(second.getName() + " zadaje cios " + attack_f2);
//            System.out.println(hitOutcome.message);
//            if (!first.isAlive()) {
//                winner = second;
//                isFightOver=true;
//                break;
//            }
//            System.out.println(first.getName() + " ma wciąż " + first.getHp() + " HP");
//            System.out.println();
        }
        System.out.println("Zwycięzcą jest " + winner.getName());
    }

    private HitOutcome isHitSuccessfull(AttackType attack_f1, BlockType block_f2) {
        Random random = new Random();
        return HitOutcome.randomize(random.nextInt(3));
    }

    private void checkDamage(IFighter first, IFighter second, HitOutcome hitOutcome) {
        second.decreaseHp(first.getStrength() * hitOutcome.strength);
    }

    private class Clash {
        private boolean isFightOver;
        private IFighter first;
        private IFighter second;
        private IFighter winner;

        public Clash(IFighter first, IFighter second, IFighter winner) {
            this.first = first;
            this.second = second;
            this.winner = winner;
        }

        boolean isFightOver() {
            return isFightOver;
        }

        public IFighter getWinner() {
            return winner;
        }

        public Clash invoke() {
            AttackType attack_f1 = first.getAttackAction();
            BlockType block_f2 = second.getBlockAction();
            HitOutcome hitOutcome = isHitSuccessfull(attack_f1, block_f2);
            checkDamage(first, second, hitOutcome);


            System.out.println(first.getName() + " zadaje cios " + attack_f1);
            System.out.println(hitOutcome.message);
            if (!second.isAlive()) {
                winner = first;
                isFightOver = true;
                return this;
            }
            System.out.println(second.getName() + " ma wciąż " + second.getHp() + " HP");
            isFightOver = false;
            return this;
        }
    }
}
