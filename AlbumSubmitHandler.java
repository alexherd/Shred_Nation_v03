import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlbumSubmitHandler implements EventHandler<ActionEvent> {

	private GridPane _grid;
	private String _user;
	private TextField _artist;
	private TextField _album;
	private Stage _stage;

	public AlbumSubmitHandler(GridPane grid, String user, TextField artist, TextField album, Stage stage) {
		_grid = grid;
		_user = user;
		_artist = artist;
		_album = album;
		_stage = stage;
	}

	public void handle(ActionEvent arg0) {

		// Makes an array of textfields where evens will be song names and odds
		// song scores
		// Takes them in order from grid 2 and adds them to the array
		ArrayList<TextField> grid = new ArrayList<TextField>();
		ObservableList<Node> childrens = _grid.getChildren();
		for (Node node : childrens) {
			grid.add((TextField) node);
		}

		// For holding the names and scores respectively
		ArrayList<String> songName = new ArrayList<String>();
		ArrayList<String> songScore = new ArrayList<String>();

		// Puts evens in the song list
		for (int i = 0; i < _grid.getChildren().size(); i = i + 2) {
			songName.add(grid.get(i).getText());

		}

		// Puts odds in the score list
		for (int i = 1; i < _grid.getChildren().size(); i = i + 2) {
			songScore.add(grid.get(i).getText());
		}

		// Removes all blank pairs of textboxes
		while (songName.get(songName.size() - 1).equals("") && songScore.get(songName.size() - 1).equals("")) {
			songName.remove(songName.size() - 1);
			songScore.remove(songScore.size() - 1);

		}

		// Needs to check for this error first, so its above the other ones
		String prev = "prev";
		for (int i = 0; i < songScore.size(); i++) {

			if (prev.equals("") && !(songScore.get(i).equals(""))) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Shred Nation Alert");
				alert.setHeaderText(null);
				alert.setContentText("Can not have an empty textbox with filled textboxes after it");
				alert.showAndWait();
				alert.setResizable(false);
				return;

			}
			prev = songScore.get(i);

		}

		// Checks for 2 errors
		for (int i = 0; i < songScore.size(); i++) {

			if (!(songScore.get(i).equals("0") || songScore.get(i).equals("1") || songScore.get(i).equals("2")
					|| songScore.get(i).equals("3") || songScore.get(i).equals("4") || songScore.get(i).equals("5")
					|| songScore.get(i).equals("6") || songScore.get(i).equals("7") || songScore.get(i).equals("8")
					|| songScore.get(i).equals("9") || songScore.get(i).equals("10") || songScore.get(i).equals("-"))) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Shred Nation Alert");
				alert.setHeaderText(null);
				alert.setContentText("Song scores must be through 0-10 or -");
				alert.showAndWait();
				alert.setResizable(false);
				return;
			}

			if (songName.get(i).equals("")) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Shred Nation Alert");
				alert.setHeaderText(null);
				alert.setContentText("Empty song name with a score detected");
				alert.showAndWait();
				alert.setResizable(false);
				return;

			}

		}

		// Gets the album rank, will not count 0 and - and will take the average
		// accordingly
		double alscore = 0;
		int dontcount = 0;
		for (int i = 0; i < songScore.size(); i++) {
			if (!songScore.get(i).equals("0") && !songScore.get(i).equals("-")) {
				alscore = alscore + Double.parseDouble(songScore.get(i));
			} else {
				dontcount = dontcount + 1;
			}

		}
		alscore = alscore / (songScore.size() - dontcount);
		alscore = (double)Math.round(alscore * 100) / 100;

		// Sets the array size back up to 20 to make the album as a class
		while (songScore.size() < 20) {
			songScore.add("");
		}

		while (songName.size() < 20) {
			songName.add("");
		}

		// Loads the array that holds songs
		try {
			ReadFile read = new ReadFile(_user);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
			@SuppressWarnings("unchecked")
			ArrayList<Album> array = (ArrayList<Album>) in.readObject();
			in.close();

			// Makes the album class and adds it to the array to be remade - lol its a mess
			Album album = new Album(_artist.getText().toLowerCase() + _album.getText().toLowerCase(), alscore,
					_artist.getText(), _album.getText(), songName.get(0), songName.get(1), songName.get(2),
					songName.get(3), songName.get(4), songName.get(5), songName.get(6), songName.get(7),
					songName.get(8), songName.get(9), songName.get(10), songName.get(11), songName.get(12),
					songName.get(13), songName.get(14), songName.get(15), songName.get(16), songName.get(17),
					songName.get(18), songName.get(19), songScore.get(0), songScore.get(1), songScore.get(2),
					songScore.get(3), songScore.get(4), songScore.get(5), songScore.get(6), songScore.get(7),
					songScore.get(8), songScore.get(9), songScore.get(10), songScore.get(11), songScore.get(12),
					songScore.get(13), songScore.get(14), songScore.get(15), songScore.get(16), songScore.get(17),
					songScore.get(18), songScore.get(19));

			array.add(album);

			// Deletes the old file
			File old = new File(read.getLoc());
			old.delete();

			// Writes the array file
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(read.getLoc()));
			out.writeObject(array);
			out.flush();
			out.close();

			// Adds 1 to the album holder
			int amount = Integer.parseInt(read.getAlbum());
			amount = amount + 1;
			String amountF = Integer.toString(amount);

			// Adds 1 to the change holder
			int change = Integer.parseInt(read.getChange());
			change = change + 1;
			String changeF = Integer.toString(change);

			// Writes the properties file
			WriteFile fi = new WriteFile(_user, read.getLoc(), read.getUse(), amountF, read.getFuture(), changeF);
			fi.Write();

			// Check if backup needs to be done and will do so if change/backup#
			// is an int
			if (Integer.parseInt(read.getChange()) % Integer.parseInt(read.getFuture()) == 0) {
				Backup backup = new Backup(_user);
				backup.doit();
			}

		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Free up memory faster
		_stage.close();
		_stage = null;

	}

}
