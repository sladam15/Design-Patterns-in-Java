/**
 Class:	Trainer.java
 Description: The following class sets up the constructor
 of a trainer object of a certain name. This class also features
 details for my choice of a Singleton Design Pattern.
 */

public class Trainer {

    public Name name;

    /**
     * Constructor sets up a name for a trainer.
     */
    public Trainer(Name name) {
        this.name = name;
    }

    /**
     * I only featured 2 trainers in this program for
     * simplicity.
     */
    public enum Name {
        ASH, MISTY
    }

    /**
     * The following 4 methods help set up a Singleton Design Pattern
     * to be used whenever a Trainer object is created. The
     * TrainerSingleton.java class will be notified displaying the
     * appropriate message.
     * @return trainer
     */
    private static Trainer trainer = new Trainer();

    private Trainer() {
    }

    public static Trainer getTrainer() {
        return trainer;
    }

    public void showMessage() {
        System.out.println("New trainer announced!");
    }
}