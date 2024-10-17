import edu.badpals.proyectoud1_mcrecipes.login.Login;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void testContrasenasValidas() {

        String validUser = "Evan";
        String validPass = "abc";

        assertTrue(Login.validatePass(validUser, validPass));

    }

    @Test
    public void testContrasenasInvalidas() {

        String invalidUser = "Aman";
        String invalidPass = "Pass";

        assertFalse(Login.validatePass(invalidUser, invalidPass));

    }

    @Test
    public void testUsuarioNoExiste() {

        String userNotExist = "aaaaa";
        String pwdNotExist = "Pass";

        assertFalse(Login.validatePass(userNotExist, pwdNotExist));

    }
}
