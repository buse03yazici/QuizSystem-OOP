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
	
@Override
public void display() {
	System.out.println(getText());
	System.out.println("True / False"); 
}

		
/** 
 * Checks if the provided answer is correct.
 * It accepts a common boolean strings such as "true", "t", "false", and "f"
 * * @param answer The user's input answer.
 * @return true if the answer matches the correct boolean, otherwise it is false.*/	
	@Override
	public boolean checkAnswer(String answer) {
	if(answer== null || answer.isEmpty())  return false;
	
	
	String input= answer.trim().toLowerCase();
	String correctStr= String.valueOf(this.correctAnswer).toLowerCase();
		
		//first control: exact match (true/false)
		if (input.equals(correctStr)){
			return true;
		}
		//tolerance for spelling errors such as ttru or ffalse
		//if the first letter is true and has at least 3 letters
		if (input.length() >= 3 && input.startsWith(correctStr.substring(0, 1))) {
			System.out.println("(!)Spelling mistake detected in TF,but accepted: "+ correctStr);
			return true;
		}
		
        
		return false;
	}	
}
