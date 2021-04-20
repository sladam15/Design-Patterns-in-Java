/*
  File:	SER316-Assignment5-sladam15
  Author: Sean Adams
  Date:	4/20/21
  Description: The main sets up objects of trainers, codeamons,
  and battles that are used to display a battle between 2 codeamon
  and 2 trainers. Cycles of up to 3 days/nights are performed.
  User will be asked if they'd like to evolve their codeamon in the
  night. Battles between trainers can only occur during the day.
  Results after battle are displayed through other parts of the
  program.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int cycle = 1;

        Trainer trainer = new Trainer(Trainer.Name.ASH);
        trainer.showMessage();  // singleton design pattern

        Trainer trainer2 = new Trainer(Trainer.Name.MISTY);
        trainer2.showMessage();  // singleton design pattern

        Codeamon codeamon1 = new Codeamon(Codeamon.Name.CUBONE);
        Codeamon codeamon2 = new Codeamon(Codeamon.Name.MACHOP);
        Codeamon codeamon3 = new Codeamon(Codeamon.Name.NINETALES);
        Codeamon codeamon4 = new Codeamon(Codeamon.Name.PSYDUCK);
        Codeamon codeamon5 = new Codeamon(Codeamon.Name.MAROWAK);

        new CodeamonObserver(codeamon1);
        codeamon1.setState(15);
        new CodeamonObserver(codeamon2);
        codeamon2.setState(15);
        new CodeamonObserver(codeamon3);
        codeamon3.setState(15);
        new CodeamonObserver(codeamon4);
        codeamon4.setState(15);

        System.out.println("\nPreparing the World of Codeamon!");

        // Day 1 - All Codeamon
        System.out.println("Day " + cycle);
        Battle fight1 = new Battle(trainer, trainer2, codeamon1, codeamon2);
        fight1.setEnvironment(Environment.Weather.rainy);
        fight1.initiateBattle();
        System.out.println("The battle has ended!");
        System.out.println("------------------------------");
        System.out.println();

        // Night 1 - All Codeamon
        System.out.println("Night " + cycle);
        fight1.setEnvironment(Environment.Weather.neutral);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Would you like to evolve your Codeamon? (Y/N)");
        String input = myObj.nextLine();  // Read user input
        if ((input.equals("Y")) || (input.equals("y"))) {
            System.out.println("You have chosen to evolve your Codeamon");

            new CodeamonObserver(codeamon5);
            codeamon5.setState(15);

            System.out.println("Your CUBONE has evolved into a MAROWAK");

            cycle++;

            // Day 2 - Evolved Codeamon
            System.out.println("Day " + cycle);
            Battle fight2 = new Battle(trainer, trainer2, codeamon5, codeamon4);
            fight2.setEnvironment(Environment.Weather.sunny);
            fight2.initiateBattle();
            System.out.println();
            System.out.println("The battle has ended!");
            System.out.println("------------------------------");
            System.out.println();

            System.out.println("Night " + cycle);
            fight1.setEnvironment(Environment.Weather.rainy);
        } else {

            // Day 2 - Normal Codeamon
            cycle++;
            System.out.println("------------------------------");
            System.out.println("Day " + cycle);
            Battle fight2 = new Battle(trainer, trainer2, codeamon1, codeamon3);
            fight2.setEnvironment(Environment.Weather.sunny);
            fight2.initiateBattle();
            System.out.println();
            System.out.println("The battle has ended!");
            System.out.println("------------------------------");
            System.out.println();

            // Night 2 - Normal Codeamon
            System.out.println("Night " + cycle);
            fight1.setEnvironment(Environment.Weather.rainy);

        }

        cycle++;

        if ((input.equals("Y")) || (input.equals("y"))) {

            System.out.println("Your codeamon has already evolved to its final form!");
            System.out.println("------------------------------");
            System.out.println();

            // Day 3 - Evolved Codeamon
            System.out.println("Day " + cycle);
            Battle fight2 = new Battle(trainer, trainer2, codeamon5, codeamon4);
            fight2.setEnvironment(Environment.Weather.sunny);
            fight2.initiateBattle();
            System.out.println();
            System.out.println("The battle has ended!");
            System.out.println("------------------------------");
            System.out.println();

            System.out.println("Night " + cycle);
            fight1.setEnvironment(Environment.Weather.rainy);
        } else {
            System.out.println("Would you like to evolve your Codeamon? (Y/N)");
            String input2 = myObj.nextLine();  // Read user input

            if ((input2.equals("Y")) || (input2.equals("y"))) {
                System.out.println("You have chosen to evolve your Codeamon");
                new CodeamonObserver(codeamon5);
                codeamon5.setState(15);

                System.out.println("Your CUBONE has evolved into a MAROWAK");

                System.out.println("Day " + cycle);
                Battle fight3 = new Battle(trainer, trainer2, codeamon5, codeamon4);
                fight3.setEnvironment(Environment.Weather.neutral);
                fight3.initiateBattle();
                System.out.println();
                System.out.println("The battle has ended!");
                System.out.println("------------------------------");
                System.out.println();

                System.out.println("Night " + cycle);
                fight1.setEnvironment(Environment.Weather.rainy);

                System.out.println("Your codeamon has already evolved to its final form!");
            } else {

                System.out.println("------------------------------");
                System.out.println("Day " + cycle);
                Battle fight3 = new Battle(trainer, trainer2, codeamon1, codeamon3);
                fight3.setEnvironment(Environment.Weather.sunny);
                fight3.initiateBattle();
                System.out.println();
                System.out.println("The battle has ended!");
                System.out.println("------------------------------");
                System.out.println();

                System.out.println("Night " + cycle);
                fight1.setEnvironment(Environment.Weather.rainy);

                System.out.println("Would you like to evolve your Codeamon? (Y/N)");
                String input3 = myObj.nextLine();  // Read user input

                if ((input3.equals("Y")) || (input3.equals("y"))) {
                    System.out.println("You have chosen to evolve your Codeamon");
                    new CodeamonObserver(codeamon5);
                    codeamon5.setState(15);

                    System.out.println("Your CUBONE has evolved into a MAROWAK");
                }
            }
        }
        System.out.println("A cycle of 3 days has finished");
    }
}