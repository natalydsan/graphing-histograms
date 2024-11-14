/**
 * Title: Histogram
 *
 * Description: Histogram Command Line Interface
 *
 * Copyright: Copyright (c) 2015
 *
 * Company: UMB
 *
 * Original Author: Bob Wilson
 * Modified by Chris Kelly for CS/IT114L, Spring 2015
 */

import java.util.Random;
import java.util.Scanner;

public class HistogramCLI {

 public static void main(String[] args) {
  
  boolean again;
  Scanner scan = new Scanner(System.in);
  Random rand  = new Random();
  
  // 1. Declare some variables:
  //    -6 int variables: dice, sides, rolls, dieSum,
  //                      minIndex, maxIndex.  Initialize
  //                      all these to zero
  //    -A Histogram reference variable by the name "hist"
  //        (just declare -- do not initialize yet!)
  //    -An int array variable by the name "counts"
  //        (just declare -- do not initialize yet!)
  
  // intialize six int variables to 0 and declare a histogram and array variable
  
   int dice = 0;
   int sides = 0;
   int rolls = 0;
   int dieSum = 0;
   int minIndex = 0;
   int maxIndex = 0;
   final int MAX_LENGTH = 30;
     
   Histogram hist = null;
   
   int[] counts = null;
  
  // NOTE: The remainder of the code will involve several 
  //       nested loops.  Please pay attention to the 
  //       indentation of my comments, to help yourself
  //       keep track of what is nested where
  
  // 2. Set up an outer do-while loop, which ends when 
  //    the boolean variable "again" is false
   
  do {
   
   // 3. A do-while that asks how many dice the user wants 
   //   (constrain the user to 1 - 3) and assigns the 
   //   resulting value to the variable "dice".
    
       do {
         System.out.println("How many dice do you want? (1 to 3)");
         dice = scan.nextInt();
    
       } while (dice < 1 || dice > 3);




   // 4. A do-while that asks how many sides each die should have 
   //   (constrain the user to 2 - 9) and assigns the resulting
   //   value to the variable "sides". 
       
       do { 
         System.out.print("How many sides does each die have? (Choose an option from 2-9)");
         sides = scan.nextInt();
         
       } while (sides < 2 || sides > 9);
   

   
   // 5. A do-while that asks how many times to roll the die 
   //   (constrain the user to 1000 - 100 million) and assigns the
   //   resulting value to the variable "rolls".
       
       do {
         System.out.print("How many rolls? (Choose from 1000 - 100 million)");
         rolls = scan.nextInt();
         
       } while (rolls < 1000 || rolls > 100000000);

   
   System.out.println();
   
   // 6. Assign values to minIndex and maxIndex, 
   //    based on the number of dice and how 
   //    many sides each die has.
   
      minIndex = dice;
      maxIndex = dice * sides;



   // 7. Initialize counts to a new int array 
   //    with a size of maxIndex plus 1
      
      counts = new int[maxIndex + 1];
   

      
   // 8. Repeatedly roll the dice
   //    --Set "dieSum" back to zero
   //    --For each die, generate a random integer
   //      between 1 and the number of sides, and 
   //      add the resulting value to "dieSum"
   //    --Increment the element in the counts array
   //      corresponding to the value of "dieSum"
        

          for (int i = 0; i < rolls; i++) {
             dieSum = 0;
             for (int j = 0; j < dice; j++) {
                int number = rand.nextInt(sides) + 1;
                dieSum += number;
             }
             
             counts[dieSum]++;
          }
                   
                 
   
   // 9. Call the Histogram constructor with the variables counts, 
   //    minIndex, maxIndex, MAX_LENGTH; and assign the object to hist.
   //    Then, call the drawHor() and drawVer() methods, with lines  
   //    skipped in between for neater output.  
          
          //final int MAX_LENGTH = 25
          hist = new Histogram(counts, minIndex, maxIndex, MAX_LENGTH);
          
          hist.drawHor();
          System.out.println();
          
          hist.drawVer();
          System.out.println();
          
          //for (int numbers:counts) {
               //System.out.println(numbers);
          //}
      
   

   // Sees if user wants to go again.
      
   System.out.print("Continue? (\"true\" for yes and \"false\" for no): ");
   again = scan.nextBoolean();
   System.out.println('\n');
   
  }while (again); {
  // end of the do-while loop indicated in step 2.  (The condition is the 
     // boolean variable "again")
  }
 }

}
