///////////////////////////////////////////////////////////////////////////////
//
// Title:            Sync.java
// Purpose:			Writes to a file and appends the updated information
// Semester:         Fall 2017
//
// Author:           Jasmine Mai
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sync {
	
	//Appends to the file
	public static void demandSync(int stepNum, int heartRate, String totalTime) throws IOException {
		Clock timeStamp = new Clock();
		BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt", true));
		writer.newLine();
		writer.append(timeStamp.getTimeStamp() + " Steps: " + stepNum + " HeartRate: " + heartRate + " Sleep: " + totalTime);
		writer.close();
	}

}
