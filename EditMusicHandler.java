import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Optional;
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

public class EditMusicHandler implements EventHandler<ActionEvent> {

	private String _user;

	public EditMusicHandler(String user) {
		_user = user;
	}

	public void handle(ActionEvent event) {

		Alert alertEditMusic = new Alert(AlertType.CONFIRMATION);
		alertEditMusic.setTitle("Edit Music");
		alertEditMusic.setHeaderText("What Album would you like to change?");

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		TextField artist = new TextField();
		TextField album = new TextField();
		grid.add(new Label("Album:             "), 0, 0);
		grid.add(album, 1, 0);
		grid.add(new Label("Artist:            "), 0, 1);
		grid.add(artist, 1, 1);
		alertEditMusic.getDialogPane().setContent(grid);

		// Buttons
		ButtonType addAlbum = new ButtonType("Continue");
		ButtonType addCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		// Add buttons to alert
		alertEditMusic.getButtonTypes().setAll(addAlbum, addCancel);

		// Get user input
		Optional<ButtonType> addInput = alertEditMusic.showAndWait();
		if (addInput.get() == addAlbum) {

			// For album only
			if ((artist.getText().equals("")) && !(album.getText().equals(""))) {
				String search = album.getText().toLowerCase();
				ReadFile read = new ReadFile(_user);

				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
					@SuppressWarnings("unchecked")
					ArrayList<Album> array = (ArrayList<Album>) in.readObject();
					in.close();

					for (int i = 0; i < array.size(); i++) {

						int checker = search.compareTo(array.get(i).getalbum().toLowerCase());
						// If found add every song and score to an array its a
						// mess :(
						if (checker == 0) {

							// Hold songs and scores
							ArrayList<String> songs = new ArrayList<String>();
							ArrayList<String> scores = new ArrayList<String>();

							if (!array.get(i).getsong1().equals("")) {
								songs.add(array.get(i).getsong1());
							}

							if (!array.get(i).getsong2().equals("")) {
								songs.add(array.get(i).getsong2());
							}

							if (!array.get(i).getsong3().equals("")) {
								songs.add(array.get(i).getsong3());
							}

							if (!array.get(i).getsong4().equals("")) {
								songs.add(array.get(i).getsong4());
							}

							if (!array.get(i).getsong5().equals("")) {
								songs.add(array.get(i).getsong5());
							}

							if (!array.get(i).getsong6().equals("")) {
								songs.add(array.get(i).getsong6());
							}

							if (!array.get(i).getsong7().equals("")) {
								songs.add(array.get(i).getsong7());
							}

							if (!array.get(i).getsong8().equals("")) {
								songs.add(array.get(i).getsong8());
							}

							if (!array.get(i).getsong9().equals("")) {
								songs.add(array.get(i).getsong9());
							}

							if (!array.get(i).getsong10().equals("")) {
								songs.add(array.get(i).getsong10());
							}

							if (!array.get(i).getsong11().equals("")) {
								songs.add(array.get(i).getsong11());
							}

							if (!array.get(i).getsong12().equals("")) {
								songs.add(array.get(i).getsong12());
							}

							if (!array.get(i).getsong13().equals("")) {
								songs.add(array.get(i).getsong13());
							}
							if (!array.get(i).getsong14().equals("")) {
								songs.add(array.get(i).getsong14());
							}

							if (!array.get(i).getsong15().equals("")) {
								songs.add(array.get(i).getsong15());
							}

							if (!array.get(i).getsong16().equals("")) {
								songs.add(array.get(i).getsong16());
							}

							if (!array.get(i).getsong17().equals("")) {
								songs.add(array.get(i).getsong17());
							}

							if (!array.get(i).getsong18().equals("")) {
								songs.add(array.get(i).getsong18());
							}

							if (!array.get(i).getsong19().equals("")) {
								songs.add(array.get(i).getsong19());
							}

							if (!array.get(i).getsong20().equals("")) {
								songs.add(array.get(i).getsong20());
							}

							if (!array.get(i).getscore1().equals("")) {
								scores.add(array.get(i).getscore1());
							}

							if (!array.get(i).getscore2().equals("")) {
								scores.add(array.get(i).getscore2());
							}

							if (!array.get(i).getscore3().equals("")) {
								scores.add(array.get(i).getscore3());
							}

							if (!array.get(i).getscore4().equals("")) {
								scores.add(array.get(i).getscore4());
							}

							if (!array.get(i).getscore5().equals("")) {
								scores.add(array.get(i).getscore5());
							}

							if (!array.get(i).getscore6().equals("")) {
								scores.add(array.get(i).getscore6());
							}

							if (!array.get(i).getscore7().equals("")) {
								scores.add(array.get(i).getscore7());
							}

							if (!array.get(i).getscore8().equals("")) {
								scores.add(array.get(i).getscore8());
							}

							if (!array.get(i).getscore9().equals("")) {
								scores.add(array.get(i).getscore9());
							}

							if (!array.get(i).getscore10().equals("")) {
								scores.add(array.get(i).getscore10());
							}

							if (!array.get(i).getscore11().equals("")) {
								scores.add(array.get(i).getscore11());
							}

							if (!array.get(i).getscore12().equals("")) {
								scores.add(array.get(i).getscore12());
							}

							if (!array.get(i).getscore13().equals("")) {
								scores.add(array.get(i).getscore13());
							}
							if (!array.get(i).getscore14().equals("")) {
								scores.add(array.get(i).getscore14());
							}

							if (!array.get(i).getscore15().equals("")) {
								scores.add(array.get(i).getscore15());
							}

							if (!array.get(i).getscore16().equals("")) {
								scores.add(array.get(i).getscore16());
							}

							if (!array.get(i).getscore17().equals("")) {
								scores.add(array.get(i).getscore17());
							}

							if (!array.get(i).getscore18().equals("")) {
								scores.add(array.get(i).getscore18());
							}

							if (!array.get(i).getscore19().equals("")) {
								scores.add(array.get(i).getscore19());
							}

							if (!array.get(i).getscore20().equals("")) {
								scores.add(array.get(i).getscore20());
							}

							EditScreen newScreen = new EditScreen(songs, scores, array.get(i).getband(),
									album.getText(), _user, i);
							newScreen.show();
							alertEditMusic.close();
							break;

						}

					}

					// end try
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// end if
			}

			// For album and band
			if (!(artist.getText().equals("")) && !(album.getText().equals(""))) {
				String search = artist.getText().toLowerCase() + album.getText().toLowerCase();
				ReadFile read = new ReadFile(_user);

				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
					@SuppressWarnings("unchecked")
					ArrayList<Album> array = (ArrayList<Album>) in.readObject();
					in.close();

					for (int i = 0; i < array.size(); i++) {

						int checker = search.compareTo(array.get(i).getorg());
						// if found do the mess again
						if (checker == 0) {
							ArrayList<String> songs = new ArrayList<String>();
							ArrayList<String> scores = new ArrayList<String>();

							if (!array.get(i).getsong1().equals("")) {
								songs.add(array.get(i).getsong1());
							}

							if (!array.get(i).getsong2().equals("")) {
								songs.add(array.get(i).getsong2());
							}

							if (!array.get(i).getsong3().equals("")) {
								songs.add(array.get(i).getsong3());
							}

							if (!array.get(i).getsong4().equals("")) {
								songs.add(array.get(i).getsong4());
							}

							if (!array.get(i).getsong5().equals("")) {
								songs.add(array.get(i).getsong5());
							}

							if (!array.get(i).getsong6().equals("")) {
								songs.add(array.get(i).getsong6());
							}

							if (!array.get(i).getsong7().equals("")) {
								songs.add(array.get(i).getsong7());
							}

							if (!array.get(i).getsong8().equals("")) {
								songs.add(array.get(i).getsong8());
							}

							if (!array.get(i).getsong9().equals("")) {
								songs.add(array.get(i).getsong9());
							}

							if (!array.get(i).getsong10().equals("")) {
								songs.add(array.get(i).getsong10());
							}

							if (!array.get(i).getsong11().equals("")) {
								songs.add(array.get(i).getsong11());
							}

							if (!array.get(i).getsong12().equals("")) {
								songs.add(array.get(i).getsong12());
							}

							if (!array.get(i).getsong13().equals("")) {
								songs.add(array.get(i).getsong13());
							}
							if (!array.get(i).getsong14().equals("")) {
								songs.add(array.get(i).getsong14());
							}

							if (!array.get(i).getsong15().equals("")) {
								songs.add(array.get(i).getsong15());
							}

							if (!array.get(i).getsong16().equals("")) {
								songs.add(array.get(i).getsong16());
							}

							if (!array.get(i).getsong17().equals("")) {
								songs.add(array.get(i).getsong17());
							}

							if (!array.get(i).getsong18().equals("")) {
								songs.add(array.get(i).getsong18());
							}

							if (!array.get(i).getsong19().equals("")) {
								songs.add(array.get(i).getsong19());
							}

							if (!array.get(i).getsong20().equals("")) {
								songs.add(array.get(i).getsong20());
							}

							if (!array.get(i).getscore1().equals("")) {
								scores.add(array.get(i).getscore1());
							}

							if (!array.get(i).getscore2().equals("")) {
								scores.add(array.get(i).getscore2());
							}

							if (!array.get(i).getscore3().equals("")) {
								scores.add(array.get(i).getscore3());
							}

							if (!array.get(i).getscore4().equals("")) {
								scores.add(array.get(i).getscore4());
							}

							if (!array.get(i).getscore5().equals("")) {
								scores.add(array.get(i).getscore5());
							}

							if (!array.get(i).getscore6().equals("")) {
								scores.add(array.get(i).getscore6());
							}

							if (!array.get(i).getscore7().equals("")) {
								scores.add(array.get(i).getscore7());
							}

							if (!array.get(i).getscore8().equals("")) {
								scores.add(array.get(i).getscore8());
							}

							if (!array.get(i).getscore9().equals("")) {
								scores.add(array.get(i).getscore9());
							}

							if (!array.get(i).getscore10().equals("")) {
								scores.add(array.get(i).getscore10());
							}

							if (!array.get(i).getscore11().equals("")) {
								scores.add(array.get(i).getscore11());
							}

							if (!array.get(i).getscore12().equals("")) {
								scores.add(array.get(i).getscore12());
							}

							if (!array.get(i).getscore13().equals("")) {
								scores.add(array.get(i).getscore13());
							}
							if (!array.get(i).getscore14().equals("")) {
								scores.add(array.get(i).getscore14());
							}

							if (!array.get(i).getscore15().equals("")) {
								scores.add(array.get(i).getscore15());
							}

							if (!array.get(i).getscore16().equals("")) {
								scores.add(array.get(i).getscore16());
							}

							if (!array.get(i).getscore17().equals("")) {
								scores.add(array.get(i).getscore17());
							}

							if (!array.get(i).getscore18().equals("")) {
								scores.add(array.get(i).getscore18());
							}

							if (!array.get(i).getscore19().equals("")) {
								scores.add(array.get(i).getscore19());
							}

							if (!array.get(i).getscore20().equals("")) {
								scores.add(array.get(i).getscore20());
							}

							EditScreen newScreen = new EditScreen(songs, scores, array.get(i).getband(),
									album.getText(), _user, i);
							newScreen.show();
							alertEditMusic.close();
							break;
						}

					}

					// end try
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// end if
			}

		} else {
			// CANCEL OR CLOSED DIALOG BOX
		}

	}

}