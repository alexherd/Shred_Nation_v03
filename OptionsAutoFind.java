import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class OptionsAutoFind implements EventHandler<ActionEvent> {

	private String _user;
	private CheckBox _autofind;
	
	public OptionsAutoFind(String user, CheckBox autofind){
		_user = user;
		_autofind = autofind;
	}
	@Override
	public void handle(ActionEvent arg0) {
		
		ReadFile read = new ReadFile(_user);
		String selected = "0";
		if(_autofind.isSelected() == true){
			selected = "1";
		}
		StringBuffer buffer= new StringBuffer(read.getUse());
		buffer.replace(1, 2, selected);
		
		
		WriteFile write = new WriteFile(_user,read.getLoc(),buffer.toString(),read.getAlbum(),read.getFuture(),read.getChange());
		write.Write();
		
		
	}

}
