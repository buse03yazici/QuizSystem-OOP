package quiz.system;

import java.util.Scanner;


/**
 * The Main class serves as the entry point for the Quiz System.
 * It handles the initialization of the student, loads the quiz from question.txt 
 */
public class Main {
	
/** The main method to execute the system.*/
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in); // creating a scanner object to read user input.
       
		//prompt the user for name.
		System.out.println("Welcome to the Quiz System!");
		System.out.print("Please enter your name: ");
		String name= scanner.nextLine(); 
		System.out.print("Please enter your surname: ");
		String surname= scanner.nextLine(); 
		System.out.print("Please enter your student ID: ");
		String studentID = scanner.nextLine(); 
	
		System.out.println("Student ID " + studentID + " recognized. Good luck, " + name + "!");
		
		Student student= new Student(name);//to initialize the Student object.
		
		
		//to initialize the Quiz object with the source file.
		Quiz quiz= new Quiz("questions.txt"); 
		quiz.start(name + " " + surname); 
		quiz.saveResultsToFile(name + " " + surname, studentID); //saving file
		student.setScore(quiz.calculateScore());
		
		scanner.close();
	}
	
	
	

}
