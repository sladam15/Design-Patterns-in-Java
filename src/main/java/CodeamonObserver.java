public class CodeamonObserver extends Observer{

    public CodeamonObserver(Codeamon codeamon){
        this.codeamon = codeamon;
        this.codeamon.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Observer has detected a new Codeamon");
    }
}