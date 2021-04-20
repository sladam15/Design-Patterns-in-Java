public class Description {

    public String description;

    public Description() {
        description = "New mascot";
    }

    public Description(Codeamon.Name name) {
        String n = name.toString();
        if (n.equals("CUBONE")) {
            description = "The Alligator";
        } else if (n.equals("MACHOP")) {
            description = "The Buffalo";
        } else if (n.equals("NINETALES")) {
            description = "The Sun Devil";
        } else if (n.equals("PSYDUCK")) {
            description = "The Bull Dog";
        } else {
            description = "New mascot";
        }
    }
}
