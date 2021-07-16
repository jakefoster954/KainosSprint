package UnitTest;

import com.kainos.ea.resources.Job;
import com.kainos.ea.resources.User;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UserTest {
    @Test
    public void constructor_ValidArguments_ObjectCreated() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";

        User user = new User(userID, userEmail, userPassword, userType);

        assertNotNull(user);
        assertEquals(user.getUserID(), userID);
        assertEquals(user.getUserEmail(), userEmail);
        assertEquals(user.getUserPassword(), userPassword);
        assertEquals(user.getUserType(), userType);
    }

    @Test
    public void getUserID_ValidTest_UserIDReturned() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        int result = user.getUserID();

        assertEquals(result, userID);
    }

    @Test
    public void getUserEmail_ValidTest_UserEmailReturned() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        String result = user.getUserEmail();

        assertEquals(result, userEmail);
    }

    @Test
    public void getUserPassword_ValidTest_UserPasswordReturned() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        String result = user.getUserPassword();

        assertEquals(result, userPassword);
    }

    @Test
    public void getUserType_ValidTest_UserTypeReturned() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        String result = user.getUserType();

        assertEquals(result, userType);
    }

    @Test
    public void setUserID_ValidUserIDInput_UserIDSetToNewValue() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        int newUserId = 1;
        user.setUserID(newUserId);

        assertEquals(user.getUserID(), newUserId);
    }

    @Test
    public void setUserEmail_ValidUserEmailInput_UserEmailSetToNewValue() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        String newUserEmail = "Test Email 2";
        user.setUserEmail(newUserEmail);

        assertEquals(user.getUserEmail(), newUserEmail);
    }

    @Test
    public void setUserPassword_ValidUserPasswordInput_UserPasswordSetToNewValue() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        String newUserPassword = "Test Password 2";
        user.setUserPassword(newUserPassword);

        assertEquals(user.getUserPassword(), newUserPassword);
    }

    @Test
    public void setUserType_ValidUserTypeInput_UserTypeSetToNewValue() {
        int userID = 0;
        String userEmail = "Test Email";
        String userPassword = "Test Password";
        String userType = "Test Type";
        User user = new User(userID, userEmail, userPassword, userType);

        String newUserType = "Test Type 2";
        user.setUserType(newUserType);

        assertEquals(user.getUserType(), newUserType);
    }
}
