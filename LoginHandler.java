import java.io.File;
import org.bouncycastle.crypto.CryptoException;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("rawtypes")
public class LoginHandler implements EventHandler {
	
	private TextField _userName;
	private Stage _stage;
	private PasswordField _pass;

	public LoginHandler(TextField userName, PasswordField pass, Stage stage) {
		_userName = userName;
		_stage = stage;
		_pass = pass;
	}

	public void handle(Event arg0) {
		
		//Checks to see if the username is vaild by checking if the folder name exists
		String q = System.getProperty("user.name");
		File theDir = new File("/Users/" + q
				+ "/Documents/Shred_Nation/Profiles/" + _userName.getText());
		
		//If the username doesnt exist then it will show an alert
		if (!theDir.exists()) {
			
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Shred Nation Alert");
			alert.setHeaderText(null);
			alert.setContentText("User doesn't exist");
			alert.showAndWait();
			alert.setResizable(false);
			return;
		}

		//If the password is longer than 16 chars it will automatically throw an incorrect password message
		if(_pass.getText().length() > 16){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Shred Nation Alert");
			alert.setHeaderText(null);
			alert.setContentText("Incorrect password");
			alert.showAndWait();
			alert.setResizable(false);
			return;
		}
		
		//Because the password needs to be exactly 16 it adds spaces to the password like done when encrypting 
		String pass = _pass.getText();
		while (pass.length() != 16) {
			pass = pass + " ";
		}

		
		try {
			File file1 = new File("/Users/" + q
					+ "/Documents/Shred_Nation/Profiles/" + _userName.getText()
					+ "/List.ser");
			Encryption.decrypt(pass, file1, file1);

			file1 = new File("/Users/" + q
					+ "/Documents/Shred_Nation/Profiles/" + _userName.getText()
					+ "/Config.properties");

			Encryption.decrypt(pass, file1, file1);
		} catch (CryptoException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Shred Nation Alert");
			alert.setHeaderText(null);
			alert.setContentText("Password incorrect");
			alert.showAndWait();
			alert.setResizable(false);
			return;
			
		}

		// Will close the login stage, set it to null to make memory space faster, then will show our main GUI
		_stage.hide();
		_stage.close();
		_stage = null;
		Gui gui = new Gui(_userName.getText(),pass);
		gui.showGUI();

	}

}
