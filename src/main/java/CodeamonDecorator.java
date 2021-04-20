/**
 Class:	CodeamonDecorator.java
 Description: The following class implements a Decorator Design
 Pattern which is used for creating an evolved Codemon.
 */

public class CodeamonDecorator implements CodeamonInterface {
    protected CodeamonInterface codeamon;

    /**
     * Constructor for codeamon.
     */
    public CodeamonDecorator(CodeamonInterface c) {
        this.codeamon=codeamon;
    }

    /**
     * The following method assembles a Codeamon variable
     * to be used for a special version (evolved Codemon).
     */
    @Override
    public void assemble() {
        this.codeamon.assemble();
    }
}