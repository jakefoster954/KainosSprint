package UnitTest;

import com.kainos.ea.resources.User;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UserTest {
    @Test
    public void constructor_ValidArguments_ObjectCreated() {
        String userEmail = "Test Email";
        String userPassword = "Test Password";

        User user = new User(userEmail, userPassword);

        assertNotNull(user);
        assertEquals(user.getUserEmail(), userEmail);
        assertEquals(user.getUserPassword(), userPassword);
    }

    @Test
    public void getUserEmail_ValidTest_UserEmailReturned() {
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        User user = new User(userEmail, userPassword);

        String result = user.getUserEmail();

        assertEquals(result, userEmail);
    }

    @Test
    public void getUserPassword_ValidTest_UserPasswordReturned() {
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        User user = new User(userEmail, userPassword);

        String result = user.getUserPassword();

        assertEquals(result, userPassword);
    }

    @Test
    public void setUserEmail_ValidUserEmailInput_UserEmailSetToNewValue() {
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        User user = new User(userEmail, userPassword);

        String newUserEmail = "Test Email 2";
        user.setUserEmail(newUserEmail);

        assertEquals(user.getUserEmail(), newUserEmail);
    }

    @Test
    public void setUserPassword_ValidUserPasswordInput_UserPasswordSetToNewValue() {
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        User user = new User(userEmail, userPassword);

        String newUserPassword = "Test Password 2";
        user.setUserPassword(newUserPassword);

        assertEquals(user.getUserPassword(), newUserPassword);
    }
}