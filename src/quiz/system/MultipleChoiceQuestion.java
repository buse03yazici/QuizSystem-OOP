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
	String correctWord= options[correctIndex].toLowerCase();
	char correctChar=(char)('a'+correctIndex);
	
	//Checks the letter of the answer choice (A,B,C...)
	if(input.length()==1) {
		return input.charAt(0)==correctChar;
	}
	//Similarity of the exact word or "first 3 letters"(even if it is "extended", it catches it from the first letters
	if (input.equals(correctWord) ||
		(input.length() >=3 && correctWord.startsWith(input.substring(0,3)))||
		(input.length() >= 3 && input.startsWith(correctWord.substring(0, 3)))) {
        	System.out.println("(!)You may have a spelling mistake,but it is accepted as correct.: " + options[correctIndex]);	
		return true;
	}
	 //general check
	if(correctWord.length()>=3 && (correctWord.contains(input)|| input.contains(correctWord))) {
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

