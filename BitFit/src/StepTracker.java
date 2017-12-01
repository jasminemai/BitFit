///////////////////////////////////////////////////////////////////////////////
//
// Title:            StepTracker.java
// Purpose:			Tracks the number of steps
// Semester:         Fall 2017
//
// Author:           Lara Brooksbank
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.util.concurrent.TimeUnit;

public class StepTracker {
	private static int stepNum;
	private static boolean isOn = true;
	private static int currentStep = 0;
	
	
	public StepTracker(){
		// when a new step tracker is created, its step num is set to zero
		clearStepNum();
		// when steptracker is on
		while (isOn) {
		try {
			
		//run every 50 milliseconds
		TimeUnit.MILLISECONDS.sleep(50);}
			catch(InterruptedException e){
			Thread.currentThread().interrupt();
			}
		
			// 0 or 1 
			currentStep = measureStep();
			
			if(currentStep > 1 || currentStep < 0) {
				System.out.println("ERROR: STEP VALUE OUT OF RANGE");
			}
			if(currentStep == 1) {
				incrementStep();
			}
			
			
			System.out.println(stepNum);
		}

		
		
	}
	
	public static void incrementStep() {
		stepNum = stepNum + 1;
	}
	
	public static int measureStep() {
		return Accelerometer.getStep(currentStep);
	}
	
	// returns step num for day
	public static int getStepNum() {
		return stepNum;
	}
	
	// sets step num to zero
	public static void clearStepNum() {
		stepNum = 0;
	}
	
	// turns off step tracker
	public static void turnOffStepTracker() {
		isOn = false;
	}
	
	
}