import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class PersonTest {

    private Person person;

    @Before
    public void setup() {
        person = new Person();
        person.setName("Paul");
        person.setSurname("McCartney");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2000);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);

        person.setBirthDate(c.getTime());
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary(), 0.001);
    }

    @Test
    public void person_is_MEI() {
        person.setSalary(5000); 
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setAnotherCompanyOwner(true);
        assertFalse(person.isMEI());
    }
}