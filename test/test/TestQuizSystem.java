package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import quiz.system.Quiz;
import java.io.File;

/**
 * Junit tests class for the Quiz system.
 * This class verifies the integration between the Quiz class and the external questions file.
 * that the system can correctly locate and load questions from an external file.
 * @author Buse
 * @version 1.1
 */
public class TestQuizSystem {
	
	/**
	 * Tests if the Quiz can successfully load questions from "questions.txt"
	 * Since the loading method is private and called in the constructor
	 * we test the result by creating a new Quiz instance.
	 */
	@Test
	public void testQuizInitializationAndLoading() {
		//verifies the physical existence of the data source
		String fileName="questions.txt";
		File file=new File(fileName);
		assertTrue(file.exists(), "CRITICAL ERROR: " + fileName + "was not found in the project root directory");
		
		//instantiate the Quiz object
		Quiz quiz=new Quiz(fileName);
		
		//validates successful object creation and initial state
		assertNotNull(quiz, "The Quiz object should not be null after initialization");
		assertEquals(0, quiz.calculateScore(), "The initial score must be 0 upon loading.");
		
		System.out.println("Integration Test Status: File loaded and Quiz object initialized sucessfully");
	}
	
    /**
     *Verifies that the saveResultToFile method correctly creates the "result.txt" file in th project directory.
     */
	@Test
	public void testSaveResultsToFileCreation() {
		Quiz quiz = new Quiz("questions.txt");
		String testName="Test Student";
		String testID="12345";
		
		quiz.saveResultsToFile(testName, testID);
		
		File resultsFile= new File("results.txt");
		assertTrue(resultsFile.exists(), "Test Failed: results.txt was not created by saveResultsToFile method.");
		
		System.out.println("Result Saving Test Status: results.txt verified.");
	}
}

