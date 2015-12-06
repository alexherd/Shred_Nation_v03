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
			WriteFile fi0 = new WriteFile(_user, readFile.getLoc(), change + "0", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi0.Write();
			_sceneMusic.getStylesheets().removeAll("Deadsong.css", "Fountain.css", "Medusalem.css", "Stormcrow.css", "Uncharted.css");
			_sceneMusic.getStylesheets().add("Default.css");
			break;
		
		case 1:
			WriteFile fi1 = new WriteFile(_user, readFile.getLoc(), change + "1", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi1.Write();
			_sceneMusic.getStylesheets().removeAll("Default.css", "Fountain.css", "Medusalem.css", "Stormcrow.css", "Uncharted.css");
			_sceneMusic.getStylesheets().add("Deadsong.css");
			break;
			
		case 2:
			WriteFile fi2 = new WriteFile(_user, readFile.getLoc(), change + "2", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi2.Write();
			_sceneMusic.getStylesheets().removeAll("Default.css", "Deadsong.css", "Medusalem.css", "Stormcrow.css", "Uncharted.css");
			_sceneMusic.getStylesheets().add("Fountain.css");
			break;
		
		case 3:
			WriteFile fi3 = new WriteFile(_user, readFile.getLoc(), change + "3", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi3.Write();
			_sceneMusic.getStylesheets().removeAll("Default.css", "Deadsong.css", "Fountain.css", "Stormcrow.css", "Uncharted.css");
			_sceneMusic.getStylesheets().add("Medusalem.css");
			break;
		
		case 4:
			WriteFile fi4 = new WriteFile(_user, readFile.getLoc(), change + "4", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi4.Write();
			_sceneMusic.getStylesheets().removeAll("Default.css", "Deadsong.css", "Fountain.css", "Medusalem.css", "Uncharted.css");
			_sceneMusic.getStylesheets().add("Stormcrow.css");
			break;
			
		case 5:
			WriteFile fi5 = new WriteFile(_user, readFile.getLoc(), change + "5", readFile.getAlbum(), readFile.getFuture(), readFile.getChange());
			fi5.Write();
			_sceneMusic.getStylesheets().removeAll("Default.css", "Deadsong.css", "Fountain.css", "Medusalem.css",  "Stormcrow.css");
			_sceneMusic.getStylesheets().add("Uncharted.css");
			break;
		}
		
	}

	

}
