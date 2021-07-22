package UnitTest;

import com.kainos.ea.resources.Training;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TrainingTest {
    @Test
    public void constructor_ValidArguments_ObjectCreated() {
        String trainingName = "Test Name";
        String trainingLink = "Test Link";

        Training training = new Training(trainingName, trainingLink);

        assertNotNull(training);
        assertEquals(training.getTrainingName(), trainingName);
        assertEquals(training.getTrainingLink(), trainingLink);
    }

    @Test
    public void getTrainingName_ValidTest_NameReturned() {
        String trainingName = "Test Name";
        String trainingLink = "Test Link";

        Training training = new Training(trainingName, trainingLink);

        String result = training.getTrainingName();

        assertEquals(result, trainingName);
    }

    @Test
    public void getTrainingLink_ValidTest_LinkReturned() {
        String trainingName = "Test Name";
        String trainingLink = "Test Link";

        Training training = new Training(trainingName, trainingLink);

        String result = training.getTrainingLink();

        assertEquals(result, trainingLink);
    }

    @Test
    public void setTrainingName_ValidTrainingNameInput_TrainingNameSetToNewValue() {
        String trainingName = "Test Name";
        String trainingLink = "Test Link";

        Training training = new Training(trainingName, trainingLink);

        String newTrainingName = "New Test Name";
        training.setTrainingName(newTrainingName);

        assertEquals(training.getTrainingName(), newTrainingName);
    }

    @Test
    public void setTrainingLink_ValidTrainingLinkInput_TrainingLinkSetToNewValue() {
        String trainingName = "Test Name";
        String trainingLink = "Test Link";

        Training training = new Training(trainingName, trainingLink);

        String newTrainingLink = "New Test Link";
        training.setTrainingLink(newTrainingLink);

        assertEquals(training.getTrainingLink(), newTrainingLink);
    }
}
