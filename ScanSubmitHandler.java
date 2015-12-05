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

public class ScanSubmitHandler implements EventHandler<ActionEvent> {

	private GridPane _grid;
	private String _user;
	private ArrayList<AlbumLoc> _database;
	private Stage _stage;

	public ScanSubmitHandler(GridPane grid, String user, Stage stage, ArrayList<AlbumLoc> database) {
		_grid = grid;
		_user = user;
		_stage = stage;
		_database = database;
	}

	public void handle(ActionEvent event) {

		// Similar to other SubmitHandlers
		// main difference is if there is more in database show it

		ArrayList<TextField> grid = new ArrayList<TextField>();
		ObservableList<Node> childrens = _grid.getChildren();
		for (Node node : childrens) {
			grid.add((TextField) node);
		}

		ArrayList<String> songName = new ArrayList<String>();
		ArrayList<String> songScore = new ArrayList<String>();

		for (int i = 0; i < _grid.getChildren().size(); i = i + 2) {
			songName.add(grid.get(i).getText());

		}

		for (int i = 1; i < _grid.getChildren().size(); i = i + 2) {
			songScore.add(grid.get(i).getText());
		}

		while (songName.get(songName.size() - 1).equals("") && songScore.get(songName.size() - 1).equals("")) {
			songName.remove(songName.size() - 1);
			songScore.remove(songScore.size() - 1);

		}

		String prev = "prev";
		for (int i = 0; i < songName.size(); i++) {

			if (prev.equals("") && !(songName.get(i).equals(""))) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Shred Nation Alert");
				alert.setHeaderText(null);
				alert.setContentText("Can not have an empty textbox with filled textboxes after it");
				alert.showAndWait();
				alert.setResizable(false);
				return;

			}
			prev = songName.get(i);

		}

		// Checks for 2 errors
		for (int i = 0; i < songScore.size(); i++) {

			if (!(songScore.get(i).equals("0") || songScore.get(i).equals("1") || songScore.get(i).equals("2")
					|| songScore.get(i).equals("3") || songScore.get(i).equals("4") || songScore.get(i).equals("5")
					|| songScore.get(i).equals("6") || songScore.get(i).equals("7") || songScore.get(i).equals("8")
					|| songScore.get(i).equals("9") || songScore.get(i).equals("10") || songScore.get(i).equals("-"))) {
					songScore.set(i, "-");
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

		double alscore = 0;
		int dontcount = 0;
		for (int i = 0; i < songScore.size(); i++) {
			if (!songScore.get(i).equals("0") && !songScore.get(i).equals("-")) {
				alscore = alscore + Double.parseDouble(songScore.get(i));
			} else {
				dontcount = dontcount + 1;
			}

		}
		alscore = alscore / songScore.size() - dontcount;
		alscore = (double)Math.round(alscore * 100) / 100;

		while (songScore.size() < 20) {
			songScore.add("");
		}

		while (songName.size() < 20) {
			songName.add("");
		}

		ReadFile fe = new ReadFile(_user);
		ObjectInputStream in;
		try {

			in = new ObjectInputStream(new FileInputStream(fe.getLoc()));
			@SuppressWarnings("unchecked")
			ArrayList<Album> array = (ArrayList<Album>) in.readObject();
			in.close();

			Album album = new Album(
					_database.get(0).getArtist().toLowerCase() + _database.get(0).getAlbum().toLowerCase(), alscore,
					_database.get(0).getArtist(), _database.get(0).getAlbum(), songName.get(0), songName.get(1),
					songName.get(2), songName.get(3), songName.get(4), songName.get(5), songName.get(6),
					songName.get(7), songName.get(8), songName.get(9), songName.get(10), songName.get(11),
					songName.get(12), songName.get(13), songName.get(14), songName.get(15), songName.get(16),
					songName.get(17), songName.get(18), songName.get(19), songScore.get(0), songScore.get(1),
					songScore.get(2), songScore.get(3), songScore.get(4), songScore.get(5), songScore.get(6),
					songScore.get(7), songScore.get(8), songScore.get(9), songScore.get(10), songScore.get(11),
					songScore.get(12), songScore.get(13), songScore.get(14), songScore.get(15), songScore.get(16),
					songScore.get(17), songScore.get(18), songScore.get(19));

			array.add(album);

			File goop = new File(fe.getLoc());
			goop.delete();

			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fe.getLoc()));
			out.writeObject(array);
			out.flush();
			out.close();

			int foo = Integer.parseInt(fe.getAlbum());
			foo = foo + 1;
			String q = Integer.toString(foo);

			int foops = Integer.parseInt(fe.getChange());
			foops = foops + 1;
			String qq = Integer.toString(foops);

			WriteFile fi = new WriteFile(_user, fe.getLoc(), fe.getUse(), q, fe.getFuture(), qq);
			fi.Write();

			if (Integer.parseInt(fe.getChange()) % Integer.parseInt(fe.getFuture()) == 0) {
				Backup backup = new Backup(_user);
				backup.doit();
			}

			_database.remove(0);

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

		_stage.close();
		_stage = null;

		if (_database.size() > 0) {
			ScanAlbumScreen screen = new ScanAlbumScreen(_database, _user);
			screen.show();
		}

	}

}