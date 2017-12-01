///////////////////////////////////////////////////////////////////////////////
//
// Title:            HeartRateSensor.java
// Purpose:			Creates randomly generated numbers of heart rates that are realistic
// Semester:         Fall 2017
//
// Author:           Lara Brooksbank
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class HeartRateSensor {


	public static int getRate(int currentRate) {
		// default heartRate is the last rate calculated
		int heartRate = currentRate;
		
		// get random int between 0 and 6
		int randInt = ThreadLocalRandom.current().nextInt(0,6);
		
		// if the random int is zero and hr is greater than 40 (not too small)
		if (randInt == 0 && heartRate > 40 ) {
			
			// decrease by one
			heartRate = heartRate - 1;
		}
		
		
		// if the random int is 1,2,3,or 4
		if (randInt == 1 ||  randInt == 2 || randInt == 3 || randInt == 4) {
			
			// rate is same as last one calculated
			heartRate = heartRate - 0;
		}
		
		// if the random int is 5 and hr is less than 145 (not too big) 
		if (randInt == 5 && heartRate < 145 ) {
			
			// increase by one
			heartRate = heartRate + 1;
		}
		
		return heartRate;
	}
	

	
}