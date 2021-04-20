/**
 Class:	CodeamonObserver.java
 Description: The following class is a concrete observer class which
 extends Observer.java. This class will update when a new Codeamon
 has been detected and assist in notifying all observers.
 */

public class CodeamonObserver extends Observer {

    public CodeamonObserver(Codeamon codeamon) {
        this.codeamon = codeamon;
        this.codeamon.attach(this);
    }

    /**
     * The following method updates with a display line when called.
     */
    @Override
    public void update() {
        System.out.println("Observer has detected a new Codeamon");
    }
}