package UnitTest;

import com.kainos.ea.resources.Capability;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class LeadTest {
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
}
