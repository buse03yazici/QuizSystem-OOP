package quiz.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
 * The Quiz class manages a collection of Question objects and implements grading.
 * It handles loading questions from the questions.txt and executing the quiz logic.               
 */
public class Quiz implements Gradable {
	private List<Question> questions;
	private int score;
	
	/**
	 * Initializes a new Quiz and loads questions from a text file.
	 * @param filename The path to the questions source file.
	 */
	public Quiz(String filename) {
		this.questions= new ArrayList<>();
		this.score= 0 ; 
		loadQuestionsFromFile(filename);
		}

	/**
	 * Reads questions from a pipe-seperated file.
	 * *@param filename Name of the file.
	 */
	private void loadQuestionsFromFile(String filename) {
		try (Scanner fileScanner = new Scanner(new File(filename))) {
			while(fileScanner.hasNextLine()) {
				 String line=fileScanner.nextLine();
				 if(line.trim().isEmpty()) continue;
				 String[] parts = line.split("\\|");
				 
				 if (parts[0].equals("MCQ")){
					 questions.add(new MultipleChoiceQuestion(parts[1], parts[2].split(","), Integer.parseInt(parts[3])));
				 } else if (parts[0].equals("TF")) {
					 questions.add(new TrueFalseQuestion(parts[1],Boolean.parseBoolean(parts[2])));
				 }
			 }
		} catch (FileNotFoundException e) {
			    System.out.println("Error:Question file not found.");
		}
	}
	
	/** 
	 * Starts the quiz, iterates through questions, and uses polymorphism to check answers.
	 */
	public void start() {
		Scanner scanner=new Scanner(System.in);
		score=0;
		
		for(Question q: questions) {
			System.out.println("\n" + q.getText());
			
			//polymorphism: checks if it is a MultipleChoiceQuestion to print options.
			if(q instanceof MultipleChoiceQuestion) {
				((MultipleChoiceQuestion)q).printOptions();
			} else if(q instanceof TrueFalseQuestion) {
				System.out.println("(Type 'true' or 'false')");
			}
			
			System.out.print("Your answer is: ");
			String answer= scanner.nextLine().trim().toLowerCase(); 
			
			if(q.checkAnswer(answer)) {
				System.out.println("Correct");
				score++;
			} else {
				System.out.println("Wrong answer");
			}
		}
		showResults(); // we are directed to  Interface method. 
		scanner.close();
	}
	

	
	@Override
	public int calculateScore() {
		return this.score;
		
	}
	
	@Override
	public void showResults() {
		System.out.println("\n---Quiz Finished---");
		System.out.println("Your total score is: " + calculateScore()+ "/" + questions.size());
	}
}
		