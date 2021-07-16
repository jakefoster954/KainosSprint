package UnitTest;

import com.kainos.ea.resources.Capability;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class CapabilityTest {
    @Test
    public void constructor_ValidArguments_ObjectCreated() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        assertNotNull(cap);
        assertEquals(cap.getCapabilityID(), capabilityID);
        assertEquals(cap.getCapabilityName(), capabilityName);
        assertEquals(cap.getLeadName(), leadName);
        assertEquals(cap.getLeadMessage(), leadMessage);
        assertEquals(cap.getLeadPhoto(), leadPhoto);
    }
    @Test
    public void getCapabilityID_ValidTest_IDReturned() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        int result = cap.getCapabilityID();

        assertEquals(result, capabilityID);
    }
    @Test
    public void getCapabilityName_ValidTest_NameReturned() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String result = cap.getCapabilityName();

        assertEquals(result, capabilityName);
    }
    @Test
    public void getLeadName_ValidTest_NameReturned() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String result = cap.getLeadName();

        assertEquals(result, leadName);
    }
    @Test
    public void getLeadMessage_ValidTest_MessageReturned() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String result = cap.getLeadMessage();

        assertEquals(result, leadMessage);
    }
    @Test
    public void getLeadPhoto_ValidTest_PhotoReturned() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String result = cap.getLeadPhoto();

        assertEquals(result, leadPhoto);
    }
    @Test
    public void setCapabilityID_ValidCapabilityIDInput_CapabilityIDSetToNewValue() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        int newCapabilityID = 1;
        cap.setCapabilityID(newCapabilityID);

        assertEquals(cap.getCapabilityID(), newCapabilityID);
    }
    @Test
    public void setCapabilityName_ValidCapabilityNameInput_CapabilityNameSetToNewValue() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String newCapabilityName = "Name Test";
        cap.setCapabilityName(newCapabilityName);

        assertEquals(cap.getCapabilityName(), newCapabilityName);
    }
    @Test
    public void setLeadMessage_ValidLeadMessageInput_LeadMessageSetToNewValue() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String newLeadMessage = "Name Test";
        cap.setLeadMessage(newLeadMessage);

        assertEquals(cap.getLeadMessage(), newLeadMessage);
    }


    @Test
    public void setLeadName_ValidLeadNameInput_LeadNameSetToNewValue() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String newLeadName = "Lead Message Test";
        cap.setLeadName(newLeadName);

        assertEquals(cap.getLeadName(), newLeadName);
    }

    @Test
    public void setLeadPhoto_ValidLeadPhotoInput_LeadPhotoSetToNewValue() {
        int capabilityID = 0;
        String capabilityName = "Test cap";
        String leadName = "Test Name";
        String leadMessage = "Test Msg";
        String leadPhoto = "Test Photo";

        Capability cap = new Capability(capabilityID, capabilityName, leadName, leadMessage, leadPhoto);

        String newLeadPhoto = "Lead Photo Test";
        cap.setLeadPhoto(newLeadPhoto);

        assertEquals(cap.getLeadPhoto(), newLeadPhoto);
    }
}
