///////////////////////////////////////////////////////////////////////////////
//
// Title:            SleepTracker.java
// Purpose:			Gets the beginning and ending of the sleeping duration and returns the amount slept.
// Semester:         Fall 2017
//
// Author:           Anna Uhl
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepTracker {
	String beginSleepTime;
	String endSleepTime;
	long totalSleepTime;
	String sleepTime;
	Clock currTime = new Clock();

	//returns total sleeping time in format hh:mm as a string
	String getSleepTime(long totalSleepTime) {
		String sleep = String.format("%d hr(s), %d min(s)", 
			    TimeUnit.MILLISECONDS.toHours(totalSleepTime),
			    (TimeUnit.MILLISECONDS.toMinutes(totalSleepTime) - 
			    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(totalSleepTime)))
			);
		return sleep;
	}

	//saves time user starts sleeping, called by button
	String makeNewSleep(){
		beginSleepTime = currTime.getTime();
		return beginSleepTime;
	} 

	//saves time user stops sleeping, called by button
	long endSleep (String begin){
		endSleepTime = currTime.getTime();
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
}
