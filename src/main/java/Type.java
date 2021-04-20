/**
 Class:	Type.java
 Description: The following class sets a certain type
 to Codeamon of a given name which is used later in
 the program for buffs and debuffs against other
 types.
 */

public class Type {
    String type;

    /**
     * Method will assign specific types to Codeamon
     * of a certain name.
     */
    public Type(Codeamon.Name name) {
        if (name.equals(Codeamon.Name.CUBONE)) {
            type = "Ground";
        } else if (name.equals(Codeamon.Name.MACHOP)) {
            type = "Fighting";
        } else if (name.equals(Codeamon.Name.MAROWAK)) {
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
