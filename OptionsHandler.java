import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OptionsHandler implements EventHandler<ActionEvent> {
	
	private String _user;
	private String _pass;
	
	public OptionsHandler(String user, String pass){
		_user = user;
		_pass = pass;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		Options options = new Options(_user, _pass);
		options.showOptions();
	}
}
