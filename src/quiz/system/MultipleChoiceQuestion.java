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
	char userChar=answer.trim().toUpperCase().charAt(0);
	int userChoiceIndex= userChar-'A';
	
	return userChoiceIndex==correctIndex;
}

/**Prints the answer options with A,B,C... labels. */
public void printOptions() {
    for (int i = 0; i < options.length; i++) {
        char label = (char) ('A' + i);
        System.out.println(label + " - " + options[i]);}
 }
} 


