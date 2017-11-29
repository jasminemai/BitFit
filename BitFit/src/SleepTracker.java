import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepTracker {
	String beginSleepTime;
	String endSleepTime;
	long totalSleepTime;
	String sleepTime;

	//returns total sleeping time in format hh:mm:ss
	String getSleepTime(long totalSleepTime) {
		String sleep = String.format("%d hr(s), %d min(s)", 
			    TimeUnit.MILLISECONDS.toHours(totalSleepTime),
			    (TimeUnit.MILLISECONDS.toMinutes(totalSleepTime) - 
			    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(totalSleepTime)))
			);
		return sleep;
	}

	//converts hours, minutes, seconds so that they consist of two digits
	private String sleepString (int time){
		String sleepTime;
		if (time < 10){
			sleepTime = "0"+time;
		} 
		else {
			sleepTime = ""+time; 
		}
		return sleepTime;
	}

	//saves time user starts sleeping, called by button
	String makeNewSleep(){
		beginSleepTime = new SimpleDateFormat("HH:mm").format(new Date());
		return beginSleepTime;
	} 

	//saves time user stops sleeping, called by button
	long endSleep (String begin){
		endSleepTime = new SimpleDateFormat("HH:mm").format(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			Date d1 = sdf.parse(begin);
			Date d2 = sdf.parse(endSleepTime);
		    long totalSleepTime = ((d2.getTime() - d1.getTime())); 
		    return totalSleepTime;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalSleepTime;
	}
	/*public static void main(String[] args) {
		String sleep = String.format("%d min, %d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(100000000),
			    TimeUnit.MILLISECONDS.toSeconds(100000000) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(100000000))
			);
		System.out.println(sleep);
	    
	}*/
}
