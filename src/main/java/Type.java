public class Type {
    String type;

    public Type(Codeamon.Name name) {
        if (name.equals(Codeamon.Name.CUBONE)) {
            type = "Ground";
        } else if (name.equals(Codeamon.Name.MACHOP)) {
            type = "Fighting";
        } else if (name.equals(Codeamon.Name.NINETALES)) {
            type = "Fire";
        } else if (name.equals(Codeamon.Name.PSYDUCK)) {
            type = "Water";
        } else {
            type = "Normal";
        }
    }
}
