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
public void display() {
    System.out.println(getText());
    printOptions();
}


/**
 * Checks if the user's choice (A,B,C,D) matches the correct index.
 * Overrides the abstract method from Question class. (Polymorphism)    */
@Override
public boolean checkAnswer(String answer) {
	if (answer == null || answer.isEmpty()) return false;
	
	String input=answer.trim().toLowerCase();
	String correctAnswerText = options[correctIndex].toLowerCase();
	String correctLetter = String.valueOf((char)('a' + correctIndex));
	
	//exact match (letter or a word)
	if (input.equals(correctLetter) || input.equals(correctAnswerText)) {
		return true; 
		
	}
	//if the input is longer then 3 letters and appears in the correct answer
	if (input.length()>= 3 && correctAnswerText.contains(input)|| input.contains(correctAnswerText.substring(0,3))) {
		System.out.println("(!)You may have a spelling mistake, but it is accepted as correct: " + options[correctIndex]);
		return true;
	}
	 
	
	return false;
}

public void printOptions() {
	if (options==null) return;
	for (int i=0; i< options.length; i++) {
		char label=(char)('A'+i);
		System.out.println(label+"-" + options[i]);
	}
}
}

