/**
 Class:	Battle.java
 Description: The following class puts together the battle of two
 codeamons and two trainers to face off against one another. Attacks
 are performed and calculated from each until one has fainted (health
 is 0 or below). Winner is rewarded with a win and XP.
 */

public class Battle {

    Codeamon mon1;
    Codeamon mon2;
    Stats mon1Stats;
    Stats mon2Stats;
    Environment battleWeather;

    Trainer trainerName;
    Trainer trainerName2;

    int winnerTotal = 0;

    /**
     * Battle constructor which has setter methods for two trainers and two codeamon.
     */
    public Battle(Trainer train1, Trainer train2, Codeamon pMon1, Codeamon pMon2) {
        setTrainer(train1);
        setTrainer2(train2);
        setMon1(pMon1);
        setMon2(pMon2);
    }

    /**
     * Sets environment of the battlefield, and sets buff/debuff modifiers for all Codeamons on the
     * field. If the Mascotmon's type is buffed by the environment,they receive a 25% multiplier to
     * their attack and defense stat. If the Mascotmon's type is debuffed by the environment, they
     * receive a reduction of 25% to their attack and defense stat.
     * @param weather is the weather enum to use from Environment class
     */
    public void setEnvironment(Environment.Weather weather) {
        battleWeather = new Environment(weather);
    }

    /**
     * This void method prepares for a battle. Stats are applied to the two codeamon and weather conditions
     * are announced. The program will display outputs of who is battling, and announce a winner
     * and reward.
     */
    public void initiateBattle() {
        mon1Stats = new Stats(mon1.name);
        mon2Stats = new Stats(mon2.name);

        System.out.println("Weather Conditions: " + battleWeather.WEATHER.toString());
        System.out.println();
        System.out.println("Trainer " + trainerName.name + " has chosen to fight with a " + mon1.name + ".");
        System.out.println("On the opposing side the Trainer " + trainerName2.name + " approaches with a " + mon2.name);

        System.out.println("The battle is about to get underway");
        System.out.println(mon2.name + " prepares for the incoming attack");

        Codeamon winner = fight();

        if ((winner.name.equals("CUBONE")) || (winner.name.equals("MAROWAK"))) {
            winnerTotal++;
        }

        System.out.println(winner.name + " has won with " + winner.stats.health + " health left");
        System.out.println(winner.name + " has been rewarded with 300XP.");
        System.out.println();
    }

    /**
     * This void method starts the battle. Stats are applied to the two codeamon and weather conditions
     * are announced. The program will display details of each attack, and how much health the current
     * codeamon has left. Program will display an output when a codeamon has fainted. This method will
     * also announce a winner and reward.
     */
    public Codeamon fight() {
        int round = 1;
        double damage1;
        double damage2;

        Attack attack1;
        Attack attack2;

        while (true) {
            System.out.println("\n" + mon1.name + " launches an attack against " + mon2.name + "!");
            attack1 = mon1.attack();

            damage1 = calculateDamage(attack1, mon1, mon2);
            System.out.println(damage1 + " damage dealt");

            mon2.stats.health = mon2.stats.health + damage1;
            System.out.println(mon2.name + " has " + mon2.stats.health + " health left");

            if (mon2.stats.health <= 0.0){
                System.out.println(mon2.name + " has fainted in round " + round);
                return mon1;
            }

            System.out.println("\n" + mon2.name  + " launches an attack against " + mon1.name + "!");
            attack2 = mon2.attack();

            damage2 = calculateDamage(attack2, mon2, mon1);
            System.out.println(damage2 + " damage dealt");

            mon1.stats.health = mon1.stats.health - damage2;
            System.out.println(mon1.name + " has " + mon1.stats.health + " health left");

            if (mon1.stats.health <= 0.0){
                System.out.println(mon1.name + " has fainted in round " + round);
                return mon2;
            }
            round++;
        }
    }

    /**
     * Setter method for first codeamon in the battle.
     */
    public void setMon1(Codeamon pMon) {
        mon1 = pMon;
    }

    /**
     * Setter method for second codeamon in the battle.
     */
    public void setMon2(Codeamon pMon) {
        mon2 =  pMon;
    }

    /**
     * Setter method for first trainer in the battle.
     */
    public void setTrainer(Trainer train1) {
        trainerName =  train1;
    }

    /**
     * Setter method for second trainer in the battle.
     */
    public void setTrainer2(Trainer train2) {
        trainerName2 =  train2;
    }

    /**
     * This method implements the calculation of damage for one specific attack.
     * One monster attacks with the given damage, the dealt damage is then calculated through
     * (pAttackDamage * pAttacker.weatherBonus * pAttacker.typeBonus) -
     (pDefender.stats.defense * pDefender.weatherBonus * pDefender.typeBonus)
     * If the initial pAttackDamage is 0, then the damage dealt is 0. If the totalDamage calculated
     * is negative, the totalDamage dealt should be 1. Any positive value is the total damage dealt.
     * Weather bonus: see the Environment which you can assume is correct. You need to check though if the weather bonus is applied
     * correctly, since maybe the method does not use the environment correctly.
     * or debuffed based on the weather. EG. fire monsters have a stat advantage of +25% in sunny weather
     * while they have a stat disadvantage of -25% in the rain.
     * If the attack chosen, matches the monsters type, the attacker will get an extra 20% on its attack.
     * Type bonus: Certain monsters have an attack bonus against others:
     *     Fire against Water: Water gains 25% while Fire looses 25%
     *     Fire against Ground: Fire gains 25% while Ground looses 25%
     *     Ground against Water: Ground gains 25% while Water looses 25%
     *     Normal mon: never gain any type bonus and are weaker during droughts.
     * These bonuses do not stack up, they are just applied for every attack.
     * @param pAttack is the attack value given to the method where that attack value is based on the
     *                 monsters damage value
     * @param pAttacker the attacking monster
     * @param pDefender the defending monster (the defending monster will never get damage)
     * to calculate damage output.
     * @return total damage output
     */
    public double calculateDamage(Attack pAttack, Codeamon pAttacker, Codeamon pDefender) {
        double totalDamage = 0.0;

        if (pAttacker.type.equals("Water") && pDefender.type.equals("Fire")) {
            pAttacker.typeBonus = 1.25;
            pDefender.typeBonus = 0.75;
        } else if (pAttacker.type.equals("Fire") && pDefender.type.equals("Water")) {
            pAttacker.typeBonus = 0.75;
            pDefender.typeBonus = 1.25;
        }

        if (pAttacker.type.equals("Fire") && pDefender.type.equals("Ground")) {
            pAttacker.typeBonus = 1.25;
            pDefender.typeBonus = 0.75;
        } else if (pAttacker.type.equals("Ground") && pDefender.type.equals("Fire")) {
            pAttacker.typeBonus = 0.75;
            pDefender.typeBonus = 1.25;
        }

        if (pAttacker.type.equals("Ground") && pDefender.type.equals("Water")) {
            pAttacker.typeBonus = 0.75;
            pDefender.typeBonus = 1.25;
        } else if (pAttacker.type.equals("Water") && pDefender.type.equals("Ground")) {
            pAttacker.typeBonus = 1.25;
            pDefender.typeBonus = 0.75;
        }

        if (this.battleWeather.GetBuffedType().equals(pAttacker.type)) {
            pAttacker.weatherBonus = this.battleWeather.buffModifier;
        } else if (this.battleWeather.getDebuffedType().equals(pAttacker.type)) {
            pAttacker.weatherBonus = this.battleWeather.debuffModifier;
        }

        if (this.battleWeather.GetBuffedType().equals(pDefender.type)) {
            pDefender.weatherBonus = this.battleWeather.buffModifier;
        } else if (this.battleWeather.getDebuffedType().equals(pAttacker.type)) {
            pDefender.weatherBonus = this.battleWeather.debuffModifier;
        }

        double damage = pAttack.damage;
        if (pAttack.type.equals(pAttacker.type)) {
            damage *= 1.2;
        }

        if (damage == 0.0) {
            totalDamage = 0.0;
        } else if (damage < 0.0) {
            totalDamage = 1.0;
        } else if (damage > 0.0){
            totalDamage = (damage * pAttacker.weatherBonus * pAttacker.typeBonus) -
                    (pDefender.stats.defense * pDefender.weatherBonus * pDefender.typeBonus);
        }

        return (double)Math.round(totalDamage);
    }
}