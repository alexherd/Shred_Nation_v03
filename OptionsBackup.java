import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;

public class OptionsBackup implements EventHandler<ActionEvent> {

	private String _user;
	private ChoiceBox<Integer> _backup;
	
	public OptionsBackup(String user, ChoiceBox<Integer> backup){
		_user = user;
		_backup = backup;
	}
	@Override
	public void handle(ActionEvent arg0) {
		
		ReadFile read = new ReadFile(_user);
		
	
		
		WriteFile write = new WriteFile(_user,read.getLoc(),read.getUse(),read.getAlbum(),Integer.toString(_backup.getValue()),read.getChange());
		write.Write();
		
		
	}

}
