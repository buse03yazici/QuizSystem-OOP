package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import quiz.system.TrueFalseQuestion;


/**
 * JUnit tests for TrueFalseQuestion.
 * Validates the behavior of boolean answer checking,
 * including case sensitivity, trimming and spelling tolerance.
 * @author Buse
 * @version 1.1
 */
public class TestTrueFalseQuestion {
	
	/**Tests the checkAnswer logic with various scenarios.
	 * Verifies that full words are accepted, single letters are rejected.
	 * and spelling mistakes like 'ture' are tolerated.
	 */
	
	@Test
	public void testCheckAnswerLogic() {
		
		//creating a question whose answer is 'true'
		TrueFalseQuestion tfq= new TrueFalseQuestion("Is Java an OOP language?", true);
		
		//exact word and capitalization test
		assertTrue(tfq.checkAnswer("true"), "Lowercase 'true' should be correct");
		assertTrue(tfq.checkAnswer("TRUE"), "Uppercase 'TRUE' should be correct");
		assertTrue(tfq.checkAnswer(" True"), "Trimmed 'True' should be correct");
		
		//single letter test(t/f) ( should be false, >=3 letters rule) 
		assertFalse(tfq.checkAnswer("t"), "Single letter 't' should be rejected");
		
		//spelling tolerance test
		assertTrue(tfq.checkAnswer("ture"), "Common spelling mistake 'ture' should be accepted by tolerance logic.");
		
		//incorrect answer tests (should be false)
		assertFalse(tfq.checkAnswer("false"), "Answer 'false' should be incorrect");
		assertFalse(tfq.checkAnswer("f"), "Single letter 'f' should be incorrect");
	}

}
