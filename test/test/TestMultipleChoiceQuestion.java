package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import quiz.system.MultipleChoiceQuestion;

/**
 * JUnit test class for MultipleChoiceQuestion.
 * Tests letter input, full word input, and spelling mistake tolerance.
 */

public class TestMultipleChoiceQuestion {
	
	
	@Test
	public void testCheckAnswerAllScenarios() {
		String[] options= {"Inheritance","Polymorphism","Encapsulation","Interface"};
		MultipleChoiceQuestion mcq= new MultipleChoiceQuestion("Which is an OOP principle?", options,0);
		
		//letter test:(A,B,C..)
		assertTrue(mcq.checkAnswer("a"), "Lowercase letter 'a' failed ");
		assertTrue(mcq.checkAnswer("A"), "Uppercase letter 'A' failed ");
		
		//exact word test
		assertTrue(mcq.checkAnswer("Inheritance"), "Full word should be correct");
		
		
		//wrong answer test
		assertFalse(mcq.checkAnswer("b"), "Wrong answer should not pass");
		
	}
}
