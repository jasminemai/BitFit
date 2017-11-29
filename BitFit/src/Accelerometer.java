
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
public class Accelerometer {
    
    
    // this method uses probability to decide whether a step is taken
    public static int getStep(int currentStep) {
   	 // default value
   	 int stepTaken = 0;
   	 
   	 // select random int between 0 and 5000
   	 int randInt = ThreadLocalRandom.current().nextInt(0,5000);
   	 
   	 // if last step value was zero
   	 if (currentStep == 0 ) {
   		 
   		 // if random int is between 0 and 4995 (seems arbitrary, but delivers reasonable #s)
   		 if (randInt > 0 && randInt < 4995) {
   		 
   			 // then this step value is zero
   		 stepTaken = 0;
   		 }else {
   			 
   			 // else step is taken
   			 stepTaken = 1;
   		 }
   	 }
   	 
   	 // if last step value was one
   	 if (currentStep == 1 ) {
   		 
   		 // if random int is between 0 and 1000
   		 if (randInt > 0 && randInt < 1000) {
   			 // thens this step value is zero
   		 stepTaken = 0;
   		 }else {
   			 
   			 //else step is taken
   			 stepTaken = 1;
   		 }
   	 }
   	 
   	 return stepTaken;
    }
    
}

