///////////////////////////////////////////////////////////////////////////////
//
// Title:            ActivityTracker.java
// Purpose:			Creates new threads to simulate heart rate and steps.
// Semester:         Fall 2017
//
// Author:           Lara Brooksbank
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////

public class ActivityTracker {
	
	public ActivityTracker() {
	  //new instance of the heart rate tracker is created and run
	   createStepTracker();
	  //new instance of the step tracker is created
	   createHRTracker();
	   
	   
	}
	
	public static void createStepTracker() {
		 new Thread() { 
		        public void run() {
		        	StepTracker st = new StepTracker();
		        }
		    }.start();
		    
	}
	
	public static void createHRTracker() {
		 new Thread() { 
		        public void run() {
		        	HeartRateTracker hrt = new HeartRateTracker();
		        	
		       }
		    }.start();
	}
	
	public static int getStepCount() {
		return StepTracker.getStepNum();
	}
	
	public static int getHR() {
		return HeartRateTracker.getRate();
	}
	
	public static void makeNewActivityTracker() {
		ActivityTracker at = new ActivityTracker();
	}
	
//main
	public static void main(String[] args) {
		makeNewActivityTracker();

	}
}