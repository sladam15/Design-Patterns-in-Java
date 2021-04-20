/**
 Class:	Observer.java
 Description: The following Observer class is used for my choice of
 an Observer Design Pattern. This class is set up to call the update
 method in case an observer is notified from the Codeamon class.
 */

public abstract class Observer {
    protected Codeamon codeamon;

    public abstract void update();
}