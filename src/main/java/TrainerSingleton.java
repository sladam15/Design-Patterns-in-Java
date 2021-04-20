public class TrainerSingleton {
    public static void main(String[] args) {

        //Get the only object available
        Trainer trainer = Trainer.getTrainer();

        //show the message
        trainer.showMessage();
    }
}