import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sync {
	public static void demandSync(int stepNum, int heartRate, String totalTime) throws IOException {
		Clock timeStamp = new Clock();
		BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt", true));
		writer.newLine();
		writer.append(timeStamp.getTimeStamp() + "Steps: " + stepNum + " HeartRate: " + heartRate + " Sleep: " + totalTime);
		writer.close();
	}

}
