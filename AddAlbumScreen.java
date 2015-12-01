import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AddAlbumScreen{

	private ArrayList<String> _songList;
	private TextField _artist;
	private TextField _album;
	private String _user;
	
public AddAlbumScreen(ArrayList<String> songList, TextField artist, TextField album, String user){
	_songList = songList;
	_artist = artist;
	_album = album;
	_user = user;
}

	public void show() {
	
		// Makes the stage and the main node to hold everything
		Stage stage = new Stage();
		VBox main = new VBox();
		
		// Makes the first grid and adds the labels + sets it to the main node
		GridPane gridA = new GridPane();
		gridA.add(new Label("Artist :                                   "), 0, 0);
		gridA.add(new Label(_artist.getText()), 1, 0);
		gridA.add(new Label("Album : "), 0, 1);
		gridA.add(new Label(_album.getText()), 1, 1);
		gridA.add(new Label("Song Name     "), 0, 2);
		gridA.add(new Label("Scores        "), 1, 2);
		main.getChildren().add(gridA);
		

		// Makes the 2nd grid for holding all of the textfields
		GridPane gridB = new GridPane();
		
		// Holder is used to hold all of the textlistenerholds because we need to keep a reference to them
		ArrayList<TextListenerHolder> holder = new ArrayList<TextListenerHolder>();
		
		
		// Add textfields for each song that the list has and make their text equal to the song name
		// We have to add a null listener because it accesses the next textfield based on current spot so its like a place holder
		for( int j = 0; j < _songList.size(); j++){
			gridB.add(new TextField(_songList.get(j)), 0, j);
			gridB.add(new TextField(), 1, j);
			TextListenerHolder temp = new TextListenerHolder(null,null);
			holder.add(temp);
			
		}
		
		// Takes 20 minus the songlist size to fill in the rest of the spots that songs dont hold
		// Makes a textfield and listen for them and puts them in the list
		// This time we need the eventhandler so we add it to the score textfield
		for(int i = 0; i < 20 - _songList.size(); i++){
			TextfieldListener listen = new TextfieldListener(gridB, holder,stage);
			TextListenerHolder temp = new TextListenerHolder(new TextField(),listen);
			temp.getText().addEventHandler(KeyEvent.KEY_TYPED, listen);
			holder.add(temp);
			
		}
		
		
		// Adds one textbox more than the songlist for bonus/missing songs etc
		gridB.add(new TextField(), 0, _songList.size() );
		gridB.add(holder.get(_songList.size()).getText(), 1, _songList.size());
		
		
		// Adds the 2nd grid to the main node
		main.getChildren().add(gridB);
		
		// Makes the 3rd grid for the buttons and adds it to main panel
		GridPane gridC = new GridPane();
		Button enter = new Button("               Enter                 ");
		Button exit = new Button ("               Exit                    ");
		gridC.add(enter, 0, 0);
		gridC.add(exit, 1, 0);
		main.getChildren().add(gridC);
		
		enter.setOnAction(new AlbumSubmitHandler(gridB, _user,_artist,_album,stage));
		
		// Makes scene and shows it
		Scene scene = new Scene(main);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.showAndWait();
		
		
		
		
		
	}

}
