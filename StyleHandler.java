import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class StyleHandler implements EventHandler<ActionEvent>{
	
	private Scene _sceneMusic;
	private int _id;
	private String _user;
	
	public StyleHandler(Scene sceneMusic, int id, String user){
		_sceneMusic = sceneMusic;
		_id = id;
		_user = user;
	}
	
	
	public void handle(ActionEvent event) {
		ReadFile readFile = new ReadFile(_user);
		String change = readFile.getUse().substring(0, 2);
		switch(_id){
		case 0:
			
			WriteFile fi = new WriteFile(_user, readFile.getLoc(), change + "0", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi.Write();
			_sceneMusic.getStylesheets().removeAll("Forest.css", "Stormcrow.css");
			_sceneMusic.getStylesheets().add("Shred_Style.css");
			break;
		case 1:
			WriteFile fi2 = new WriteFile(_user, readFile.getLoc(), change + "1", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi2.Write();
			_sceneMusic.getStylesheets().removeAll("Shred_Style.css", "Stormcrow.css");
			_sceneMusic.getStylesheets().add("Forest.css");
			break;	
		case 2:
			WriteFile fi3 = new WriteFile(_user, readFile.getLoc(), change + "2", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi3.Write();
			_sceneMusic.getStylesheets().removeAll("Shred_Style.css", "Forest.css");
			_sceneMusic.getStylesheets().add("Stormcrow.css");
		}
		
	}

	

}
