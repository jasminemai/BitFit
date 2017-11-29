public class ActivityTracker {
    
    public ActivityTracker() {
   	 
   	 //new instance of the heart rate tracker is created and run
    	new Thread() {
        	public void run() {
       		 HeartRateTracker hrt = new HeartRateTracker();
       		 
       	}
    	}.start();
      //new instance of the step tracker is created
    	new Thread() {
        	public void run() {
       		 StepTracker st = new StepTracker();
        	}
    	}.start();
    }

public static int getStepCount() {
   	 return StepTracker.getStepNum();
    }
    
    public static int getHR() {
   	 return HeartRateTracker.getRate();
    }
    
    
//main
    /*public static void main(String[] args) {
   	 ActivityTracker at = new ActivityTracker();
    }*/
}
