import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class HeartRateTracker {
    private static boolean isOn = true;
    static ArrayList<Integer> heartRates = new ArrayList();
    static int currentRate;
    
    public HeartRateTracker() {
   	 // sets starting heart rate (for simulation)
   	 currentRate = ThreadLocalRandom.current().nextInt(70,100);
   	 
   	 // while tracker is on
   	 while (isOn) {
   		 
   		 // every 1 second
   		 try {
   		 TimeUnit.SECONDS.sleep(1);}
   		 catch(InterruptedException e){
   			 Thread.currentThread().interrupt();
   		 }
   		 
   		 currentRate = this.measureHeartRate();
   		 
   		 // add current rate to daily list of rates
   		 heartRates.add(currentRate);
   		 
   	 }

    }
    
    // gets current hr from sensor
    public static int measureHeartRate() {
   	 return HeartRateSensor.getRate(currentRate);
    }
    
    // returns current hr
    public static int getRate() {
   	 return currentRate;
    }
    
    // returns list of all heart rates of the day
    public static ArrayList<Integer> getRates(){
   	 return heartRates;
    }
    
    public static void clearData() {
   	 heartRates.clear();
    }
    
    // turns off tracker
    public static void turnOffHRTracker() {
   	 isOn = false;
    }
    
}

