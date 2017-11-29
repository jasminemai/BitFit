import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sync {
	public void writer(String x, String y){
		FileWriter fw;
		try {
			fw = new FileWriter("Data.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
