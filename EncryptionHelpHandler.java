import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.bouncycastle.crypto.CryptoException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EncryptionHelpHandler implements EventHandler<ActionEvent> {
	private TextField _user;
	private PasswordField _pass1;
	private PasswordField _pass2;
	private Stage _stage;
	private GridPane _grid;
	private Text _text;
	public EncryptionHelpHandler(TextField user, PasswordField pass1, PasswordField pass2, Stage stage, GridPane grid,
			Text text) {
		_pass1 = pass1;
		_pass2 = pass2;
		_stage = stage;
		_user = user;
		_grid = grid;
		_text = text;
	}

	@Override
	public void handle(ActionEvent event) {
		// Checks to see if passwords match
		if (!_pass1.getText().equals(_pass2.getText())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Shred Nation Alert");
			alert.setHeaderText(null);
			alert.setContentText("Passwords dont match");
			alert.showAndWait();
			alert.setResizable(false);

		} else {

			String sysName = System.getProperty("user.name");
			String name = _user.getText();
			String pass = _pass1.getText();

			try {
				
				// Makes sure the password is 16 or less chars
				if (pass.length() > 16) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Shred Nation Alert");
					alert.setHeaderText(null);
					alert.setContentText("Password is not less than 17 characters");
					alert.showAndWait();
					alert.setResizable(false);
				}
				
				// Makes sure the password is 16 or less chars
				if (name.length() == 0) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Shred Nation Alert");
					alert.setHeaderText(null);
					alert.setContentText("User name is blank");
					alert.showAndWait();
					alert.setResizable(false);
				}
				

				

				File theDir = new File("/Users/" + sysName + "/Documents/Shred_Nation/Profiles");
			

				// If the shred nation folder doesnt exist it will start it
				if (!theDir.exists()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Shred Nation Alert");
					alert.setHeaderText(null);
					alert.setContentText("No profile found with that name");
					alert.showAndWait();
					alert.setResizable(false);
				}

				
				File[] hold = theDir.listFiles();
				boolean inFile = false;
				if(hold.length > 0){
					
					for(int i = 0; i < hold.length; i++){
						
						if(hold[i].getName().contains(name)){
							inFile = true;

							
							
						}
					}
					
					if(inFile == false){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Shred Nation Alert");
						alert.setHeaderText(null);
						alert.setContentText("Username does not exist");
						alert.showAndWait();
						alert.setResizable(false);
						return;
					}
					
					
				} else {
					return;
				}
				
				
				
		ReadFile read = new ReadFile(name);
		String test = read.getAlbum();
		System.out.println(test);
		
		// For encryption it needs to be exactly 16 chars, so if its
		// less it will fill it with blanks
		while (pass.length() != 16) {
			pass = pass + " ";
		}
		
				// encrypts the list
				File file1 = new File("/Users/" + sysName + "/Documents/Shred_Nation/Profiles/" + name + "/List.ser");
				Encryption.encrypt(pass, file1, file1);

				// encrpyts the properties file
				file1 = new File(
						"/Users/" + sysName + "/Documents/Shred_Nation/Profiles/" + name + "/Config.properties");
				Encryption.encrypt(pass, file1, file1);

				_grid.setDisable(false);
				_text.setFill(Color.BLACK);
				_stage.hide();
				_stage.close();
				_stage = null;

			
			} catch (CryptoException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Shred Nation Alert");
				alert.setHeaderText(null);
				alert.setContentText("Meltdown");
				alert.showAndWait();
				alert.setResizable(false);
				return;
			} catch(NoSuchElementException e2){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Shred Nation Alert");
				alert.setHeaderText(null);
				alert.setContentText("File seems to be encypted");
				alert.showAndWait();
				alert.setResizable(false);
				return;
			}

		}

	}

}
