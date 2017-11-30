import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Clock {
	public String getTime() 
	{
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		return time;
	}
	public String getTimeStamp()
	{
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		return timeStamp;
	}
}
