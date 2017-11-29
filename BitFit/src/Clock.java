import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Clock {
	public String printTime() 
	{
		String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	public String printDate()
	{
		String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance());
		return date;
		
	}
}
