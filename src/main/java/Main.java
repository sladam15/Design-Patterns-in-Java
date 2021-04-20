import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int cycle = 1;

        Trainer trainer = new Trainer(Trainer.Name.ASH);
        Trainer trainer2 = new Trainer(Trainer.Name.MISTY);

        Codeamon codeamon1 = new Codeamon(Codeamon.Name.CUBONE);
        Codeamon codeamon2 = new Codeamon(Codeamon.Name.MACHOP);
        Codeamon codeamon3 = new Codeamon(Codeamon.Name.NINETALES);
        Codeamon codeamon4 = new Codeamon(Codeamon.Name.PSYDUCK);
        Codeamon codeamon5 = new Codeamon(Codeamon.Name.MAROWAK);


        System.out.println("\nPreparing the World of Codeamon!");
        System.out.println("Day " + cycle);
        Battle fight1 = new Battle(trainer, trainer2, codeamon1, codeamon2);
        fight1.setEnvironment(Environment.Weather.rainy);
        fight1.initiateBattle();
        System.out.println("The battle has ended!");
        System.out.println("------------------------------");
        System.out.println();


        System.out.println("Night " + cycle);
        fight1.setEnvironment(Environment.Weather.neutral);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Would you like to evolve your Codeamon? (Y/N)");
        String input = myObj.nextLine();  // Read user input
        if ((input.equals("Y")) || (input.equals("y"))) {
            System.out.println("You have chosen to evolve your Codeamon");

            cycle++;

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
            System.out.println(input);

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

            System.out.println("Night " + cycle);
            fight1.setEnvironment(Environment.Weather.rainy);

            cycle++;
        }

        if ((input.equals("Y")) || (input.equals("y"))) {
            System.out.println("Your codeamon has already evolved to its final form!");

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
                System.out.println("Your CUBONE has evolved into a MAROWAK");

                System.out.println("Day " + cycle);
                Battle fight3 = new Battle(trainer, trainer2, codeamon5, codeamon4);
                fight3.setEnvironment(Environment.Weather.sunny);
                fight3.initiateBattle();
                System.out.println();
                System.out.println("The battle has ended!");
                System.out.println("------------------------------");
                System.out.println();

                System.out.println("Night " + cycle);
                fight1.setEnvironment(Environment.Weather.rainy);
            } else {

                cycle++;
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

            }
            System.out.println("A cycle of 3 days has finished");
        }

    }
}