package quiz.system;

/**
 * Represents a True/False question.
 * This class handles questions where the answer is either true or false.
 */
public class TrueFalseQuestion extends Question {

	/**  The correct boolen answer for this question. */
    private boolean correctAnswer;
    
 
 /**Constructs a new TrueFalseQuestion.
  * * @param text The text of the question.
  * @param correctAnswer The correct answer as a boolean                             
  */
	public TrueFalseQuestion(String text, boolean correctAnswer) {
		super(text);
		this.correctAnswer=correctAnswer;
		}

		
/** 
 * Checks if the provided answer is correct.
 * It accepts a common boolean strings such as "true", "t", "false", and "f"
 * * @param answer The user's input answer.
 * @return true if the answer matches the correct boolean, otherwise it is false.*/	
	@Override
	public boolean checkAnswer(String answer) {
	if(answer== null || answer.isEmpty()) {
		return false;
	}

		String input= answer.trim().toLowerCase();
		
		//Handlle variations of "true".
		if (input.equals("true")|| input.equals("t")) {
			return correctAnswer==true;
		}
		//Handle variations of "false"
        else if(input.equals("false")|| input.equals("f")) {
        	return correctAnswer==false;
        }
		return false;
		
}
} 