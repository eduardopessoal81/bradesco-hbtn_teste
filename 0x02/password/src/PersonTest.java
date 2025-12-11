import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {

    private Person person;

    @BeforeAll
    public void setup() {
        person = new Person();
    }

    @ParameterizedTest
    @ValueSource(strings = { "PaulMcCartney2", "NeilArms2" })
    void check_user_valid(String user) {
        assertTrue(person.checkUser(user));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Paul#McCartney", "Neil@Arms" })
    void check_user_not_valid(String user) {
        assertFalse(person.checkUser(user));
    }

    @ParameterizedTest
    @ValueSource(strings = { "123456789", "#$%1234" })
    void does_not_have_letters(String pwd) {
        assertFalse(person.checkPassword(pwd));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Abcabcdefgh@", "#hbtn@%tc" })
    void does_not_have_numbers(String pwd) {
        assertFalse(person.checkPassword(pwd));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Abc@123", "12$@hbt" })
    void does_not_have_eight_chars(String pwd) {
        assertFalse(person.checkPassword(pwd));
    }

    @ParameterizedTest
    @ValueSource(strings = { "abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123" })
    void check_password_valid(String pwd) {
        assertTrue(person.checkPassword(pwd));
    }
}