/**
 Class:	Stats.java
 Description: The following class determines attributes of
 attack, defense, and health given to particular codeamons.
 */

public class Stats {

    double attack;
    double defense;
    double health;

    /**
     * Default constructor (though not used for the current program)
     * is set up with defaults for attack, defense, and health attributes.
     */
    public Stats() {
        attack = 50;
        defense = 50;
        health = 100;
    }

    /**
     * Constructor is set up with defaults for attack, defense, and health attributes
     * for Codeamon of a certain name.
     */
    public Stats(Codeamon.Name name) {
        switch (name) {
            case CUBONE:
            case MAROWAK:
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
