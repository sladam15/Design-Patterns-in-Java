public class Battle {

    Codeamon mon1;
    Codeamon mon2;
    Stats mon1Stats;
    Stats mon2Stats;
    Environment battleWeather;

    Trainer trainerName;
    Trainer trainerName2;

    int winnerTotal = 0;

    public Battle(Trainer train1, Trainer train2, Codeamon pMon1, Codeamon pMon2) {
        setTrainer(train1);
        setTrainer2(train2);
        setMon1(pMon1);
        setMon2(pMon2);
    } 

    public void setEnvironment(Environment.Weather pWeather) {
        battleWeather = new Environment(pWeather);
    }

    public void initiateBattle() {
        mon1Stats = new Stats(mon1.name);
        mon2Stats = new Stats(mon2.name);

        System.out.println("Weather Conditions: " + battleWeather.WEATHER.toString());
        System.out.println();
        System.out.println("Trainer " + trainerName.name + " has chosen to fight with a " + mon1.name + ".");
        System.out.println("On the opposing side the trainer " + trainerName2.name + " approaches with a " + mon2.name);

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


    public void setMon1(Codeamon pMon) {
        mon1 = pMon;
    }


    public void setMon2(Codeamon pMon) {
        mon2 =  pMon;
    }

    public void setTrainer(Trainer train1) {
        trainerName =  train1;
    }

    public void setTrainer2(Trainer train2) {
        trainerName2 =  train2;
    }

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