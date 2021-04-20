/**
 Class:	CodeamonEvolution.java
 Description: The following class implements decorator classes of
 an evolved Codeamon which is an extension of the Codeamon.java class.
 */

public class CodeamonEvolution  extends CodeamonDecorator {

    public CodeamonEvolution(CodeamonInterface c) {
        super(c);
    }

    /**
     * The following method assembles an evolved Codeamon.
     */
    @Override
    public void assemble(){
        super.assemble();
        System.out.print("A new evolution has been performed.");
    }
}
