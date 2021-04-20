/**
 Class:	Attack.java
 Description: The following class sets up the constructor
 of an attack object which features details like a damage
 statistic, as well as a type of Codeamon. These are linked
 to certain Codeamon, which are used later in the battle
 part of the program.
 */

public class Attack {

    public String type;
    public double damage;

    /**
     * Constructor sets up damage and type variables to
     * be calculated when an attack object is performed.
     */
    public Attack(double damage, String type) {
    	this.type = type;
    	this.damage = damage;
    }
}