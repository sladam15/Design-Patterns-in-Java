/**
 Class:	Codeamon.java
 Description: The following class begins a battle and displays
 more results of a given battle between two monsters. Class
 also determines if a monster has fainted and the program can
 end. Class accounts for buff, debuffs, and weather environments.
 */

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class Codeamon implements CodeamonInterface {

    public String type;
    public Name name;
    public Stats stats;
    public double weatherBonus = 1.0; 
    public double typeBonus = 1.0;
    public int buf_counter = 0;

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    /**
     * Constructor sets up a name attached to a Codeamon. Also
     * features getter methods for type and stats which will be
     * used in a battle for calculations.
     */
    public Codeamon(Name name) {
        this.name = name;
        getType();
        getStats();
    }

    /**
     * The following 4 methods set up an Observer Design Pattern
     * to be used whenever a Codeamon object is created. An observer
     * class will be notified and an observer will be added to an array
     * list.
     * @return state
     */
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * The following method assembles a Codeamon component
     * implementation to be used for an evolution if the user
     * decides to evolve their Codeamon. This will be used for
     * the CodemonInterface and Codeamon Evolution classes. This
     * is my choice for a Decorator Design Pattern.
     */
    @Override
    public void assemble() {
        System.out.print("Basic Codeamon.");
    }

    /**
     * Getter method retrieves the type of Codeamon to be used
     * in battle if there are any buffs or debuffs in
     * regards to the weather or the Codeamon type they are up
     * against.
     */
    private void getType() {
        Type t = new Type(name);
        this.type = t.type;
    }

    /**
     * Getter method retrieves the stats of a certain Codeamon
     * name used in battle.
     */
    private void getStats() {
        stats = new Stats(name);
    }

    /**
     * Method randomly determines an attack a Codeamon will use in battle. Each codeamon
     * has one buff to power up themselves instead of choosing to attack with damage.
     * @return attack damage
     */
    public Attack attack() {
        int attackNumber;

        while (true) {
            attackNumber = ThreadLocalRandom.current().nextInt(0, 4);
            if (attackNumber == 0 && buf_counter <= 2) {
                buf_counter++;
                break;
            }
            else if (attackNumber != 0){
                break;
            }
        }

        String moveName= "";
        Attack attack = null;

        switch (name) {
            case CUBONE:
            case MAROWAK:
                if (attackNumber == 0) {
                    moveName = " uses Tail Whip, increasing its defense by 10%";
                    stats.defense *= 1.10;
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    moveName = " uses Bone Rush";
                    attack = new Attack(stats.attack, "Ground");
                } else if (attackNumber == 2) {
                    moveName = " uses Headbutt";
                    attack = new Attack(stats.attack, "Normal");
                } else {
                    moveName = " uses Mud Slap";
                    attack = new Attack(stats.attack, "Ground");
                }
                break;
            case MACHOP:
                if (attackNumber == 0) {
                    moveName = " uses Leer, increasing its defense by 10%";
                    stats.defense *= 1.10;
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    moveName = " uses Low Kick";
                    attack = new Attack(stats.attack, "Fighting");
                } else if (attackNumber == 2) {
                    moveName = " uses Seismic Toss";
                    attack = new Attack(stats.attack, "Fighting");
                } else {
                    moveName = " uses Strength";
                    attack = new Attack(stats.attack, "Normal");
                }
                break;
            case NINETALES:
                if (attackNumber == 0) {
                    moveName = " uses Inferno, increasing attack stat by 10%";
                    stats.attack *= 1.10;
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    moveName = " uses Ember";
                    attack = new Attack(stats.attack, "Fire");
                } else if (attackNumber == 2) {
                    moveName = " uses Fire Spin";
                    attack = new Attack(stats.attack, "Fire");
                } else {
                    moveName = " uses Quick Attack";
                    attack = new Attack(stats.attack, "Normal");
                }
                break;
            case PSYDUCK:
                if (attackNumber == 0) {
                    moveName = " uses Health Boost, increasing health stat by 10%";
                    double health = stats.health * 1.10;
                    stats.health = Math.round(health);
                    attack = new Attack(0, "None");
                } else if (attackNumber == 1) {
                    moveName = " uses Whirlpool";
                    attack = new Attack(stats.attack, "Water");
                } else if (attackNumber == 2) {
                    moveName = " uses Rain Dance";
                    attack = new Attack(stats.attack, "Water");
                } else {
                    moveName = " uses Mega Punch";
                    attack = new Attack(stats.attack, "Normal");
                }
        }
        System.out.println(name + moveName);
        return attack;
    }

    public enum Name {
        CUBONE, MACHOP, NINETALES, PSYDUCK, MAROWAK
    }
}
