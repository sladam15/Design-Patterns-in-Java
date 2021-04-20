public class Trainer {

    public Name name;

    public Trainer(Name name) {
        this.name = name;
    }

    public enum Name {
        ASH, MISTY
    }

    //singleton
    //create an object of SingleObject
    private static Trainer trainer = new Trainer();

    //make the constructor private so that this class cannot be
    //instantiated
    private Trainer(){
    }

    //Get the only object available
    public static Trainer getTrainer(){
        return trainer;
    }

    public void showMessage(){
        System.out.println("New trainer announced!");
    }
}