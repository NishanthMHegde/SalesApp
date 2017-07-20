package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WelcomeController {
	
	@FXML
	private TextField uname;
	@FXML
	private PasswordField password;
	
	@FXML
	private Label status;
	
	public void exitApp(ActionEvent e){
		Platform.exit();
		System.exit(0);
		
	}
	
	public void login(ActionEvent event) throws IOException{
		
		String u = uname.getText();
		String p = password.getText();
		if(u.equals("overhead")&&p.equals("overhead")){
			Stage primaryStage = new Stage();
			primaryStage.setTitle("OverHeads");
			Parent root = FXMLLoader.load(getClass().getResource("/application/Employee.fxml"));
			Scene scene = new Scene(root,850,900);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		
		else if(u.equals("clients")&&p.equals("clients")){
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Clients.fxml"));
			Scene scene = new Scene(root,850,900);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}
		
		else if(u.equals("statistics")&&p.equals("statistics")){
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/stats.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else
			status.setText("Login Failed");
		
	}

}
