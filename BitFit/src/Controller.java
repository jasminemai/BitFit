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
	@FXML 
	private Button rightMainButton;
	@FXML 
	private Button leftMainButton;
	@FXML
	private Button activityLeft;
	@FXML
	private Button sleepRight;
	@FXML
	private Label stepField;
	@FXML
	private Label heartField;
	@FXML
	private Label sleepField;
	
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
        stepField.setText("100");
        heartField.setText("65");
    }
    

}
