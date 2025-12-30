package quiz.system;

/**
 * This interface defines the contract for any item that can be graded.
 * It is a core part of the system's "Interface" implementation.   
 */
public interface Gradable {
	/**
	 * Checks if the provided answer is correct according to the specific question.
	 * @param answer The input string provided by the student. 
	 *  
	 *  */
   boolean checkAnswer(String answer);
}
