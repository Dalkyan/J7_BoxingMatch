package pl.sda;


public class App {
    public static void main( String[] args ) {


        IFighter fighter1 = new Boxer("Andrzej Gołota", 200, 10);
        IFighter fighter2 = new Boxer("Mike Tyson", 2000,100);

        IFight fight = new BoxingMatch(fighter1, fighter2);
        fight.fight();

    }
}
