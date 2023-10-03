 import java.util.Scanner;
import java.lang.Math;

public class Task1 {
  public static void main(String[] args)
  {
	   generateRandom(); 
    } //end main method 
    public static void generateRandom()
	{ 
    
    int answer = (int)(Math.random() * 100) + 1;
   
    int k = 10;
    // create a scanner object to read user input
    Scanner input = new Scanner(System.in);
    // TO check if the user has guessed the number
    boolean correct = false;
	System.out.println("   ");
    System.out.println("Helloooo !!!! Welcome to Number Guessing Game In java.\n"); 
	System.out.println("YOU CAN CHOOSE ANY NUMBER BETWEEN  1 and 100\n");
	System.out.println("You have 10 tries to guess the number\n Let's Gets started!!!!!!!!!!!!!");
	
System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	
	int tries=0; 
    while (k > 0) {
		tries++;
      System.out.println("Enter your guess: ");
     int guess = input.nextInt();
      
      if (guess == answer) {
        System.out.println("You guesse is correct!\nYou win! Congratulations");
        break;
      }
      
      else if (guess > answer) {
        System.out.println("Your guess is too high.\nYou have " + (k - 1) + " tries left.");
        k--;
      }
      
      else {
        System.out.println("Your guess is too low.\nYou have " + (k - 1) + " tries left.");
      }
      // after each trial decrease the number of trials by 1
      k--;
    }
    
    if (correct == false)
	{
      System.out.println("You ran out of tries!\n");
	   System.out.println("Your Total Wrong Tries: "+tries);
	}
	
	   //Play again or exit? 
	   
     System.out.println("Press 1 to Play again."); 
	 
     System.out.println("Press 0 to exit."); 
     int choice=input.nextInt(); 
     if(choice==1)
	 		 
      generateRandom();
	 	  
     else
	 
      return ; 
    
  }
}




