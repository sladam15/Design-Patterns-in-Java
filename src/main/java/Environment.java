/**
 Class:	Environment.java
 Description: The following class determines a particular
 weather environment to account for when a battle occurs.
 If a particular weather environment is present, it may
 give certain buffs or debuffs to certain attacks and health,
 depending on the codeamon type and other situations.
 */

public class Environment {

    Weather WEATHER;
    String buffedType;
    String debuffedType;
    double buffModifier;
    double debuffModifier;

    public Environment() {
        this(Weather.neutral);
    }

    public Environment(Weather weather) {
        this.WEATHER = weather;
        this.buffModifier = 1.25;
        this.debuffModifier = 0.75;
        switch (weather) {
            case sunny:
               this.buffedType = "Fire";
               this.debuffedType = "Water";
               break;
            case rainy:
                this.buffedType = "Water";
                this.debuffedType = "Fire";
                break;
            case neutral:
                this.buffedType = "";
                this.debuffedType = "";
                break;
        }
    }

    /**
     * Getter method for the buffed type of Codeamon.
     */
    public String GetBuffedType() {
        return buffedType;
    }

    /**
     * Getter method for the debuffed type of Codeamon.
     */
    public String getDebuffedType() {
        return debuffedType;
    }

    public enum Weather {
        sunny, rainy, neutral
    }
}
