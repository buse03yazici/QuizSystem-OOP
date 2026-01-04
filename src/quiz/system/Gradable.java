package quiz.system;

/**
 * This interface defines the contract for any item that can be graded.
 * It is a core part of the system's "Interface" implementation.   
 */
public interface Gradable {
	
	
	/**
	 * Calculates the total score based on the student's performance.
	 * @return The final score as an integer.
	 *  */
	int calculateScore();
	
	/**
	 * Displays the final results and scores to the console.
	 */
	void showResults();
}
