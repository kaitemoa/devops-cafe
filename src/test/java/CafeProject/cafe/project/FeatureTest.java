package CafeProject.cafe.project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FeatureTest {

    Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testMenuNavigation() {
    	// Test that menu options are shown
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("Spiderman\n123\n1\n5\n".getBytes());
        System.setIn(in);

        boolean loginSuccess = login.login("Spiderman", "123");
        assertTrue(loginSuccess);
        System.setIn(sysInBackup);
    }

    @Test
    public void testContactInfoDisplay() {
        // Test that contact information is shown
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("Spiderman\n123\n2\n5\n".getBytes());
        System.setIn(in);

        boolean loginSuccess = login.login("Spiderman", "123");
        assertTrue(loginSuccess);
        System.setIn(sysInBackup);
    }
    
    @Test
    public void testReviewDisplay() {
        // Test that reviews are shown
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("Spiderman\n123\n3\n5\n".getBytes());
        System.setIn(in);

        boolean loginSuccess = login.login("Spiderman", "123");
        assertTrue(loginSuccess);
        System.setIn(sysInBackup);
    }

    @Test
    public void testInvalidMenuInput() {
        // Test wrong input value
        InputStream sysInBackup = System.in; 
        ByteArrayInputStream in = new ByteArrayInputStream("Spiderman\n123\n4\n".getBytes());
        System.setIn(in);

        boolean loginSuccess = login.login("Spiderman", "123");
        assertTrue(loginSuccess);
        System.setIn(sysInBackup);
    }
}
