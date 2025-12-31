package quiz.system;

/**
 * Represents a multiple-choice question.
 * This version includes the full constructor for options and correct answer.
 */
public class MultipleChoiceQuestion extends Question {
     private String[] options;
	 private int correctIndex;

	 
	 
/** 
 * @param text The question text.
 * @param options Array of choices.
 * @param correctIndex Index of the correct answer.
 * */
public  MultipleChoiceQuestion(String text, String[] options, int correctIndex) {
        super(text); //Parent class constructor 
        this.options=options;
        this.correctIndex=correctIndex; 
} 
		

@Override
public boolean checkAnswer(String answer) {
	return false;

}
} 


