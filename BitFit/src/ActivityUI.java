///////////////////////////////////////////////////////////////////////////////
//
// Title:            ActivityUI.java
// Purpose:			Initializes the Activity UI
// Semester:         Fall 2017
//
// Author:           Jasmine Mai
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class ActivityUI {
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
	
	//Button to reach back to the main screen from the activity screen
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
	
	//Sets the labels to the appropriate value
    @FXML
    private void initialize() {
        stepField.setText(Integer.toString(stepNum));
        
        heartField.setText(Integer.toString(heartRate));
    }
    
    //Increments the step every time a button is pressed
	@FXML
	private void incrementStep(ActionEvent event){
		if (event.getSource()==incrementStepButton)
		{
			stepNum++;
			stepField.setText(Integer.toString(stepNum));
		}
	}
	
	//Increments the heart rate to a reasonable amount
	@FXML
	private void incrementHeartRate(ActionEvent event){
		if (event.getSource()==incrementHeartRateButton)
		{
			heartField.setText(Integer.toString(hr.getRate(heartRate)));
			heartRate = hr.getRate(heartRate);
		}
	}

}
