import java.io.IOException;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Sleep {
	Stage primaryStage;
	Scene activity;
	Parent root;
	String text;
	long beginSleepTime;
	String beginSleep;
	public static String totalTime;
	@FXML
	private Button sleepRight;
	@FXML 
	private Label sleepField;
	@FXML 
	private Label totalSleepField;
	@FXML
	private Button sleepButton;
	@FXML
	private Button endSleepButton;
	SleepTracker st = new SleepTracker();
	
	@FXML
	private void goToMain2(ActionEvent event){
		if (event.getSource()==sleepRight)
		{
			try {
				primaryStage=(Stage) sleepRight.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
	@FXML
	private void goToSleep(ActionEvent event){
		if (event.getSource()==sleepButton)
		{
			beginSleep = st.makeNewSleep();
			sleepField.setText("Zzzzz...");
		}
	}
	
	@FXML
	void endSleep(ActionEvent event) {
		if (event.getSource()==endSleepButton)
		{
			long total = 0;
			total = st.endSleep(beginSleep);
			totalTime = st.getSleepTime(total);
			totalSleepField.setText("Total:\n" + totalTime);
			//sleepField.setText(Integer.toString(total));
		}
	}

}
