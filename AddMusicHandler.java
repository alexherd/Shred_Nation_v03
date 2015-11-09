import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class AddMusicHandler implements EventHandler<ActionEvent> {
	
	private String _user;
	public AddMusicHandler(String user){
		_user = user;
	}

	public void handle(ActionEvent event) {
		Alert alertAddMusic = new Alert(AlertType.CONFIRMATION);
		alertAddMusic.setTitle("Add Music");
		alertAddMusic.setHeaderText("What would you like to add?");

		// Buttons
		ButtonType addSong = new ButtonType("Add a song");
		ButtonType addAlbum = new ButtonType("Add an album");
		ButtonType addCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		// Add buttons to alert
		alertAddMusic.getButtonTypes().setAll(addSong, addAlbum, addCancel);
		
		// Get user input
		Optional<ButtonType> addInput = alertAddMusic.showAndWait();
		if (addInput.get() == addSong) {
			// ADD SONG PICKED
		} else if (addInput.get() == addAlbum) {
			// ADD ALBUM PICKED
			AddAlbumAlert albumAlert = new AddAlbumAlert(_user);
			albumAlert.handle(event);
			
		} else {
			// CANCEL OR CLOSED DIALOG BOX
		}
	}
}
