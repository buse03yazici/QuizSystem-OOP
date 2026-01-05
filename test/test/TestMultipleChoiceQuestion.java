package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import quiz.system.MultipleChoiceQuestion;

/**
 * JUnit test class for MultipleChoiceQuestion.
 * Validates letter inputs, full word matches and spelling tolerance
 * @author Buse
 * @version 1.1
 */

public class TestMultipleChoiceQuestion {
	
	/**Tests various answers scenarios including letters, full words,
	 * and spelling mistakes using tolerance logic.
	 */
	@Test
	public void testCheckAnswerAllScenarios() {
		String[] options= {"Inheritance","Polymorphism","Encapsulation","Interface"};
		MultipleChoiceQuestion mcq= new MultipleChoiceQuestion("Which is an OOP principle?", options,0);
		
		//letter test:(A,B,C..)
		assertTrue(mcq.checkAnswer("a"), "Lowercase letter 'a' should be correct ");
		assertTrue(mcq.checkAnswer("A"), "Uppercase letter 'A' should be correct ");
		
		//exact word test
		assertTrue(mcq.checkAnswer("Inheritance"), "Full word match should be correct");
		
		//tolerance logic test
		assertTrue(mcq.checkAnswer("Inheritence"), " Spelling  mistake shoudl be accepted");
		
		//spelling tolerance test, since it starts with "Inh",it should pass (first 3 letters)
		assertTrue(mcq.checkAnswer("Inh"), "Shortened version 'Inh' should be accepted");
		
		
		//wrong answer test
		assertFalse(mcq.checkAnswer("b"), "Wrong answer should not pass");
		
	}
		
	}

