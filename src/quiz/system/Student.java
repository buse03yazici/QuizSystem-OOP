package quiz.system;

/** The class that keeps track of student admissions and exam scores
    Includes "Encapsulation" */
 
public class Student {
	//Encapsulation: Fields are private, accessed via public methods.
   private String name;    
   private int score;
   
   /** 
    * Constructor to create a new Student 
    * @param name the student's name
     */
   
   public Student(String name) {
	   this.name=name;
	   this.score=0;
   }
   
 // Getter and Setter methods
 /** 
  * Gets the student's name.
  * @return The name of the student
  */
   
   public String getName() { // set the score after the quiz
	   return name;
   }
   
   /** 
    * Gets the student's current score. 
    * @return The current score 
    */
  
   public int getScore() { // getter for student score 
	   return score;
   }
   
   /**     
    * Updates the student's score.
    * @param score The new score to set. 
    */
   public void setScore(int score) {
	   this.score=score;
   }
}
