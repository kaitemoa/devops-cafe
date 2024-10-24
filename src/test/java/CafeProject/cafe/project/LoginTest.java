package CafeProject.cafe.project;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LoginTest {

    Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testLoginSuccess() {
        // positive test = correct username and password allow login
        boolean result = login.login("Spiderman", "123");
        assertTrue(result);
    }

    @Test
    public void testLoginFailure() {
        // negative test = invalid username or passwprd deny login
        boolean result = login.login("Batman", "321");
        assertFalse(result);
    }

    @Test
    public void testDisplayContactInfoAfterLogin() {
        // pressing 1 after successful login
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);

        boolean loginSuccess = login.login("Spiderman", "123");
        assertTrue(loginSuccess);

        System.setIn(sysInBackup);
    }

}
