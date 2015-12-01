import java.io.File;
import org.bouncycastle.crypto.CryptoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ExitHandler implements EventHandler<ActionEvent> {
	private Stage _stage;
	private int _i;
	private String _user;
	private String _pass;

	public ExitHandler(Stage stage, int i, String user, String pass) {
		_stage = stage;
		_i = i;
		_user = user;
		_pass = pass;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
		String sysName = System.getProperty("user.name");


		
		if (_i == 0) {
			
			try {
				// encrypts the list
				File file1 = new File("/Users/" + sysName + "/Documents/Shred_Nation/Profiles/" + _user + "/List.ser");
				Encryption.encrypt(_pass, file1, file1);

				// encrpyts the properties file
				file1 = new File(
						"/Users/" + sysName + "/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
				Encryption.encrypt(_pass, file1, file1);
			} catch (CryptoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			_stage.close();
			_stage = null;
				
		}
		
		if(_i == 1){
			
			try {
				// encrypts the list
				File file1 = new File("/Users/" + sysName + "/Documents/Shred_Nation/Profiles/" + _user + "/List.ser");
				Encryption.encrypt(_pass, file1, file1);

				// encrpyts the properties file
				file1 = new File(
						"/Users/" + sysName + "/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
				Encryption.encrypt(_pass, file1, file1);
			} catch (CryptoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			_stage.close();
			_stage = null;
			Login login = new Login();
			try {
				login.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(_i == 2){
			
			_stage.close();
			_stage = null;
			
			
		}
			
		
	}

}
