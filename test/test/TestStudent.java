package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import quiz.system.Student;

/**
 * JUnit test class for the Student class.
 * This class validates student information managament 
 * and the encapsulation of the score field
 */
public class TestStudent {
	
	/**
	 * Tests the constructor and the getName method.
	 * Verifies that the student's name is correctly assigned
	 */
	  @Test
	  public void testStudentInitialization() {
		  Student student= new Student("Buse");
		  
		  //checks if the name is assigned correctly 
		  assertEquals("Buse", student.getName(), "The name which is assigned in constructor should be 'Buse'.");
		  
		  //checks if the initial score is 0
		  assertEquals(0,student.getScore(), "The initial score for a new student should be 0.");
		  }
	  
	  
	  	/** 
	  	 * Tests the encapsulation of the score field
	  	 * Checks that setScore updates the score correctly and getScore gets it back.
	  	 */
	  	@Test
	  	public void testScoreUpdate() {
	  		Student student=new Student("Buse");
	  		
	  		//simulate updating the score after a quiz
	  		student.setScore(90);
	  		
	  		//verify the score update
	  		assertEquals(90,student.getScore(), "The student's score should become 90 ");
	  	}


}





