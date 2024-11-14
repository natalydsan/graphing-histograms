/**
 * Title: Histogram
 *
 * Description: Histogram Drawing Class
 *
 * Copyright: Copyright (c) 2015
 *
 * Company: UMB
 *
 * Original Author: Bob Wilson
 * Modified by Chris Kelly for CS/IT114L, Spring 2015
 */

public class Histogram {
    private int[] values;
    private int   minIndex;
    private int   maxIndex;
    private int   maxLength;
    
     /*  
      *  constructor for histogram drawing class
      *  values: the array of integer values to draw
      *  minIndex: the lowest index in the array for the range to draw
      *  maxIndex: the highest index in the array for the range to draw
      *  maxLength: the length of line to draw for the largest value
      */
    
    public Histogram(int[] values, int minIndex, int maxIndex, int maxLength) {
          // initialize the values of the instance variables from the constructor parameters
          this.values = new int [maxIndex + 1];   // allocate memory for a copy of the values array
          this.minIndex = minIndex;
          this.maxIndex = maxIndex;
          this.maxLength = maxLength;

          // step 7: 
          // find largest number in values array for scaling length of bars
          
          int maxValue = values[0];
          for(int i = 0; i < values.length; i++) {
            if (values[i] > maxValue){ 
              maxValue = values[i];
            }
          }
                           
        
          // step 8:
          // copy data from values array to this.values array while scaling to maximum length of bars
          
          for (int i = 0; i < this.values.length; i++) {
            this.values[i] = (int) (( values[i] * maxLength) / (double)maxValue);
          }
                      
    }
      
    public void drawHor()  {
        // step 9:
        // draw horizontal bar graph
      for (int i = minIndex; i <= maxIndex; i++) {
        //System.out.println(i < 10 ? " " + i + " " : i + " ");
        for (int j = 0; j < this.values[i]; j++) {
          System.out.print("*");
        }
          //System.out.println();
          System.out.println(i < 10 ? " " + i + " " : i + " ");
      }
        
      }

      
      
    public void drawVer() {

        // step 10:
        // draw vertical bar graph 
        for (int count = maxLength; count >= 1; count--) {
           System.out.print(count < 10 ? "Count " + count + " ": "Count " + count + " ");
           for (int value: values) {
              if (value >= count) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }   
        }
        System.out.println();
    }
}
}