package quiz.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** 
 * The Quiz class manages a collection of Question objects.
 * It handles adding questions executing the quiz logic.               
 */
public class Quiz {
	private List<Question> questions;
	private int score;
	
	/**
	 * Initializes a new Quiz with an empty list of questions.
	 */
	public Quiz() {
		this.questions= new ArrayList<>();
		this.score= 0 ; 
		}

	/**
	 * Adds a question to the quiz.
	 * *@param q The Question object to add.
	 */
	public void addQuestion(Question q) {
		questions.add(q);
	}



	/**
	 * Starts the quiz, iterates through questions, and prints the final score.
	 */
	public void start() {
		Scanner scanner= new Scanner(System.in);
		score=0;
		
		for(Question q: questions) {
			System.out.println("\n" + q.getText());
			
			//polymorphism: checks if it is a MultipleChoiceQuestion to print options.
			if (q instanceof MultipleChoiceQuestion) {
				((MultipleChoiceQuestion)q).printOptions();
			}
			
			System.out.print("Your answer: ");
			String answer= scanner.nextLine();
			
			if(q.checkAnswer(answer)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Wrong answer.");
		}
	}

	System.out.println("\n---Quiz Finished---");
	System.out.println("Your total socore is: " + score + "/" + questions.size());
	
	}
}