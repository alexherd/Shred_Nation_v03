import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class AddAlbumAlert implements EventHandler<ActionEvent> {

	private String _user;

	public AddAlbumAlert(String user) {
		_user = user;
	}

	public void handle(ActionEvent arg0) {

		// Starts the alert
		Alert alertAddMusic = new Alert(AlertType.CONFIRMATION);
		alertAddMusic.setTitle("Add Music");
		alertAddMusic.setHeaderText("What would you like to add?");

		// Makes the things to put in the alert
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		final TextField artist = new TextField();
		TextField album = new TextField();
		grid.add(new Label("Artist:             "), 0, 0);
		grid.add(artist, 1, 0);
		grid.add(new Label("Album:              "), 0, 1);
		grid.add(album, 1, 1);
		alertAddMusic.getDialogPane().setContent(grid);

		// Buttons
		ButtonType addAlbum = new ButtonType("Continue", ButtonData.OK_DONE);
		ButtonType addCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		// Add buttons to alert
		alertAddMusic.getButtonTypes().setAll(addAlbum, addCancel);

		Platform.runLater(new Runnable() {
		     @Override
		     public void run() {
		         artist.requestFocus();
		     }
		});
		
		// Get user input + show alert
		Optional<ButtonType> addInput = alertAddMusic.showAndWait();
		if (addInput.get() == addAlbum) {

			// Only will do this is both textboxes are not empty
			if (!(artist.getText().equals("")) && !(album.getText().equals(""))) {

				AlbumFinder finder = new AlbumFinder(artist, album, _user);
				ArrayList<String> songList = finder.findMusic();
				AddAlbumScreen newScreen = new AddAlbumScreen(songList, artist, album, _user);
				newScreen.show();
				alertAddMusic.close();

			}

		} else {
			// CANCEL OR CLOSED DIALOG BOX
		}
	}

}
