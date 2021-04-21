import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {
    @Before
    public void setUp() throws Exception {

    }

    /**
     * Battle between Ash and Misty on a sunny day with ground attack.
     * Codeamon are Ninetales and Psyduck.
     * @throws Exception
     */
    @Test
    public void NinetalesVsPsyduck() throws Exception {

        Trainer trainer1 = new Trainer(Trainer.Name.ASH);
        Trainer trainer2 = new Trainer(Trainer.Name.MISTY);

        Codeamon codeamon1 = new Codeamon(Codeamon.Name.NINETALES);
        Codeamon codeamon2 = new Codeamon(Codeamon.Name.PSYDUCK);


        Battle fight1 = new Battle(trainer1, trainer2, codeamon1, codeamon2);
        System.out.println("Sunny Weather; Ground Attack");

        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(90, "Ground");

        double damage = fight1.calculateDamage(attack, codeamon1, codeamon2);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 9, 0.2);
    }

    /**
     * Battle between Ash and Misty on a rainy day with fighting attack.
     * Codeamon are Machop and Cubone.
     * @throws Exception
     */
    @Test
    public void MachopVsCubone() throws Exception {

        Trainer trainer1 = new Trainer(Trainer.Name.ASH);
        Trainer trainer2 = new Trainer(Trainer.Name.MISTY);

        Codeamon codeamon1 = new Codeamon(Codeamon.Name.MACHOP);
        Codeamon codeamon2 = new Codeamon(Codeamon.Name.CUBONE);

        Battle fight1 = new Battle(trainer1, trainer2, codeamon1, codeamon2);
        System.out.println("Rainy weather; Fighting Attack");

        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(75, "Fighting");


        double damage = fight1.calculateDamage(attack, codeamon1, codeamon2);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 55, 0.2);
    }
}