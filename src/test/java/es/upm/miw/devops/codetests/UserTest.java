package es.upm.miw.devops.codetests;
import es.upm.miw.devops.code.User;
import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("1", "Jiale", "Wang", new ArrayList<>());
    }

    @Test
    public void testBuilder(){
        this.user=new User();
        assertNotNull(user);
    }
    @Test
    public void testGetId(){
        assertEquals("1",this.user.getId());
    }
    @Test
    public void testToString(){
        assertEquals("User{id='1', name='Jiale', familyName='Wang', fractions=[]}",this.user.toString());
    }
    @Test
    public void testFullName() {
        assertEquals("Jiale Wang", user.fullName());
    }

    @Test
    public void testInitials() {
        assertEquals("J", user.initials());
    }

    @Test
    public void testAddFraction() {
        Fraction fraction = new Fraction(1, 2);
        user.addFraction(fraction);

        List<Fraction> fractions = user.getFractions();
        assertEquals(1, fractions.size());
        assertEquals(fraction, fractions.get(0));
    }

    @Test
    public void testSetFractions() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));

        user.setFractions(fractions);

        assertEquals(fractions, user.getFractions());
    }



    @Test
    public void testSetAndGetName() {
        user.setName("Jiale");
        assertEquals("Jiale", user.getName());
    }

    @Test
    public void testSetAndGetFamilyName() {
        user.setFamilyName("Wang");
        assertEquals("Wang", user.getFamilyName());
    }
}
