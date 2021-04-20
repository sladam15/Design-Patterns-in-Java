public class Stats {

    double attack;
    double defense;
    double health;

    public Stats() {
        attack = 50;
        defense = 50;
        health = 100;
    }

    public Stats(Codeamon.Name name) {
        switch (name) {
            case CUBONE:
                attack = 45;
                defense = 35;
                health = 100;
                break;
            case MACHOP:
                attack = 50;
                defense = 50;
                health = 85;
                break;
            case NINETALES:
                attack = 70;
                defense = 30;
                health = 85;
                break;
            case PSYDUCK:
                attack = 40;
                defense = 60;
                health = 110;
                break;
        }

    }
}
