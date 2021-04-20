public class CodeamonEvolution  extends CodeamonDecorator {

    public CodeamonEvolution(CodeamonInterface c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print("A new evolution has been performed.");
    }
}
