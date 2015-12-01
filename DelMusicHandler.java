import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class DelMusicHandler implements EventHandler<ActionEvent> {

	private String _user;

	public DelMusicHandler(String user) {
		_user = user;
	}

	public void handle(ActionEvent event) {

		// Make alert
		Alert alertEditMusic = new Alert(AlertType.CONFIRMATION);
		alertEditMusic.setTitle("Edit Music");
		alertEditMusic.setHeaderText("What Album would you like to change?");

		// Make grid and add everything to it
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

					// Get array from file
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
					@SuppressWarnings("unchecked")
					ArrayList<Album> array = (ArrayList<Album>) in.readObject();
					in.close();

					for (int i = 0; i < array.size(); i++) {

						int checker = search.compareTo(array.get(i).getalbum().toLowerCase());

						// if the album is = to the input
						if (checker == 0) {
							array.remove(i);
							int hold = Integer.parseInt(read.getChange());
							hold = hold + 1;
							File arrFile = new File(read.getLoc());
							arrFile.delete();

							// Write the new .ser file and properties file
							ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(read.getLoc()));
							out.writeObject(array);
							out.flush();
							out.close();
							WriteFile file = new WriteFile(_user, read.getLoc(), read.getUse(),
									Integer.toString(Integer.parseInt(read.getAlbum()) - 1), read.getFuture(),
									Integer.toString(hold));
							file.Write();

							// Do backup if change/backup = to a whole number
							if (Integer.parseInt(read.getChange()) % Integer.parseInt(read.getFuture()) == 0) {
								Backup backup = new Backup(_user);
								backup.doit();
							}

							break;

						}

					}

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

				int albAmount = Integer.parseInt(read.getAlbum());
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
					@SuppressWarnings("unchecked")
					ArrayList<Album> array = (ArrayList<Album>) in.readObject();
					in.close();

					for (int i = 0; i < albAmount; i++) {

						int checker = search.compareTo(array.get(i).getorg());

						if (checker == 0) {

							// deletes album from array
							array.remove(i);
							int hold = Integer.parseInt(read.getChange());
							hold = hold + 1;
							File arrFile = new File(read.getLoc());
							arrFile.delete();

							// Make new .ser file
							ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(read.getLoc()));
							out.writeObject(array);
							out.flush();
							out.close();
							WriteFile file = new WriteFile(_user, read.getLoc(), read.getUse(),
									Integer.toString(Integer.parseInt(read.getAlbum()) - 1), read.getFuture(),
									Integer.toString(hold));
							file.Write();

							// Do backup if change/backup = to a whole number
							if (Integer.parseInt(read.getChange()) % Integer.parseInt(read.getFuture()) == 0) {
								Backup backup = new Backup(_user);
								backup.doit();
							}

							break;
						}

					}

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
