public class CodeamonDecorator implements CodeamonInterface {
    protected CodeamonInterface codeamon;

    public CodeamonDecorator(CodeamonInterface c){
        this.codeamon=codeamon;
    }

    @Override
    public void assemble() {
        this.codeamon.assemble();
    }
}
