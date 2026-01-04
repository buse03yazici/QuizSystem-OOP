package quiz.system;

/**
 * Base class for all types of questions.
 * Implementents Gradable interface and provides inheritance for subclasses.
 */
public abstract class Question  {
	
/**The question text-protected so subclasses can access it */
protected String text;



/**
 * Constructor for Question.
 * @param text The text of the question
 */
public Question(String text) {
	this.text=text; 
}


/**
 * Gets the text of the question.
 * @return The question text
 */
public String getText() {
	return text;
}

public abstract void display();


/**
 * Abstract method to be implemented by MC and TF questions.
 * This is the heart of Polymorphism.
 * @param answer The user's input.
 * @return true if correct, false otherwise.
 */

public abstract boolean checkAnswer(String answer);
}
