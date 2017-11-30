import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class Controller {
	Stage primaryStage;
	Scene activity;
	Parent root;
	String text;
	public static int stepNum;
	public static int heartRate = 75;
	@FXML
	private Button activityLeft;
	@FXML
	private Label stepField;
	@FXML
	private Label heartField;
	@FXML
	private Button incrementStepButton;
	@FXML
	private Button incrementHeartRateButton;
	HeartRateSensor hr = new HeartRateSensor();
	@FXML
	private void goToMain(ActionEvent event){
		if (event.getSource()==activityLeft)
		{
			try {
				primaryStage=(Stage) activityLeft.getScene().getWindow();
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
    private void initialize() {
        stepField.setText(Integer.toString(stepNum));
        
        heartField.setText(Integer.toString(heartRate));
    }
    
	@FXML
	private void incrementStep(ActionEvent event){
		if (event.getSource()==incrementStepButton)
		{
			stepNum++;
			stepField.setText(Integer.toString(stepNum));
		}
	}
	
	@FXML
	private void incrementHeartRate(ActionEvent event){
		if (event.getSource()==incrementHeartRateButton)
		{
			heartField.setText(Integer.toString(hr.getRate(heartRate)));
			heartRate = hr.getRate(heartRate);
		}
	}

}
