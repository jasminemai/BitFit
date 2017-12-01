///////////////////////////////////////////////////////////////////////////////
//
// Title:            Clock.java
// Purpose:			Returns the time in different formats
// Semester:         Fall 2017
//
// Author:           Jasmine Mai
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	
	//Returns a formatted time
	public String getTime() 
	{
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return time;
	}
	
	//Returns a timestamp
	public String getTimeStamp()
	{
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		return timeStamp;
	}
}
