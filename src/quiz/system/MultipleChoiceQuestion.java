package quiz.system;

/**
 * Represents a multiple-choice question.
 */
public class MultipleChoiceQuestion extends Question {
     private String[] options;
	 private int correctIndex;
	 
	 public MultipleChoiceQuestion(String text) {
        super(text);
	 }
		

	@Override
	public boolean checkAnswer(String answer) {
		return false;
	}

}
