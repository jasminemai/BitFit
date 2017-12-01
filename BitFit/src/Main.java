///////////////////////////////////////////////////////////////////////////////
//
// Title:            Main.java
// Purpose:			Initializes the UI
// Semester:         Fall 2017
//
// Author:           Jasmine Mai
// Class:			CSCI 360: Software Architecture & Design
//
/////////////////////////////////////////////////////////////////////////////
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class Main extends Application{
	Stage primaryStage;
	Scene activity;
	Parent root;
	String text;
	@FXML 
	private Button rightMainButton;
	@FXML 
	private Button leftMainButton;
	@FXML
	private Button syncButton;
	@FXML
	private Label dateField;
	@FXML
	private Label timeField;
	@FXML
	private Button clockUpdate;

	
	//Sets the main stage for the UI
	@Override     
	public void start(Stage primaryStage) throws Exception { 
		try {
			root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Button to go to the activity screen
	@FXML
	private void goToActivity(ActionEvent event){
		if (event.getSource()==rightMainButton)
		{
			try {
				primaryStage=(Stage) rightMainButton.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("ActivityScreen.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		}
	}

	//Button to go to the sleep screen
	@FXML
	private void goToSleep(ActionEvent event){
		if (event.getSource()==leftMainButton)
		{
			try {

				primaryStage=(Stage) leftMainButton.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("SleepScreen.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

	//Button to launch the sync function
	@FXML
	private void syncNow(ActionEvent event){
		if (event.getSource()== syncButton)
		{	
			try {
				Sync sync = new Sync();
				sync.demandSync(ActivityUI.stepNum, ActivityUI.heartRate, SleepUI.totalTime);
				System.out.println("Synced!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Initializing class to run the thread for the time and sets the date
	@FXML
	public void initialize() {
		Timeline currentTime = new Timeline(
				new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent actionEvent) {
						Calendar time = Calendar.getInstance();
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
						timeField.setText(simpleDateFormat.format(time.getTime()));
					}
				}
						),
				new KeyFrame(Duration.seconds(1))
				);
		currentTime.setCycleCount(Animation.INDEFINITE);
		currentTime.play();
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		dateField.setText(dateFormat.format(date));
	}

	//Closes the Java window when the exit button is pressed
	public void handle(WindowEvent event) {
		Platform.exit();
		System.exit(0);
	}

	//Launches the application
	public static void main(String[] args) {
		launch(args);
	}

}
