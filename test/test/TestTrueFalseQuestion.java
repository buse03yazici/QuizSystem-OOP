package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import quiz.system.TrueFalseQuestion;


/**
 * JUnit tests for TrueFalseQuestion.
 * Tests boolean strings, single letters, and spelling tolerance
 */
public class TestTrueFalseQuestion {
	
	@Test
	public void testCheckAnswerLogic() {
		
		//creating a question whose answer is 'true'
		TrueFalseQuestion tfq= new TrueFalseQuestion("Is Java an OOP language?", true);
		
		//exact word and capitalization test
		assertTrue(tfq.checkAnswer("true"), "Lowercase 'true' should be correct");
		assertTrue(tfq.checkAnswer("TRUE"), "Uppercase 'TRUE' should be correct");
		assertTrue(tfq.checkAnswer(" True"), "Trimmed 'True' should be correct");
		
		//single letter test(t/f)
		assertTrue(tfq.checkAnswer("t"), "Single letter 't' should be correct");
		
		//mistyping test
		assertFalse(tfq.checkAnswer("false"), "Answer 'false' should be incorrect");
		assertFalse(tfq.checkAnswer("f"), "Single letter 'f' should be incorrect");
	}

}
