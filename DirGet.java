import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class DirGet {
	private String _dir;
	private String _user;

	public DirGet(String dir, String user) {
		_dir = dir;
		_user = user;
	}

	public void start() {

		// uses a stack to make a list for the folders, data holds all of the
		// songs
		Stack<String> stack = new Stack<String>();
		stack.add(_dir);
		ArrayList<AlbumLoc> database = new ArrayList<AlbumLoc>();
		boolean inDataBase = false;

		// will keep going while there is a folder in the stack to look at
		while (stack.isEmpty() == false) {

			// Makes the top of the stack into a file and then makes a list of
			// every file in the folder
			File folder = new File(stack.peek());
			File[] hold = folder.listFiles();

			// Remove the top of the stack
			stack.pop();

			// The for loop checks ever file in a folder and determines if it is
			// a mp3 file or folder or none
			try {

				for (int i = 0; i < hold.length; i++) {
					String use = hold[i].toString();
					use = use.replace("\\", "/");

					// If it is a mp3 file, try to make tag then add it
					if (use.substring(use.length() - 4).equals(".mp3")) {

						Mp3File mp3file = new Mp3File(use);
						if (mp3file.hasId3v1Tag()) {
							ID3v1 id3v1Tag = mp3file.getId3v1Tag();

							// Checks if the album and artist is already in the
							// data base
							for (int q = 0; q < database.size(); q++) {
								if ((database.get(q).getArtist() + database.get(q).getAlbum())
										.compareTo(id3v1Tag.getArtist() + id3v1Tag.getAlbum()) == 0) {
									inDataBase = true;

									database.get(q).getList().add(new Song(id3v1Tag.getTitle(), use));
									break;
								}

							}

							// If it is not in the database it will add an entry
							// for it
							if (inDataBase == false) {
								database.add(
										new AlbumLoc(id3v1Tag.getArtist(), id3v1Tag.getAlbum(), new ArrayList<Song>()));
								database.get(database.size() - 1).getList().add(new Song(id3v1Tag.getTitle(), use));

							}

							inDataBase = false;

						}
					}
					if (hold[i].isDirectory() == true)

						stack.push(use);
				}

			} catch (IOException | UnsupportedTagException | InvalidDataException | NullPointerException e) {
			}
		}

		ReadFile read = new ReadFile(_user);
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
			@SuppressWarnings("unchecked")
			ArrayList<Album> array = (ArrayList<Album>) in.readObject();
			in.close();
			ArrayList<String> comp = new ArrayList<String>();

			// Makes an array of the arist/albums to compare with
			for (int i = 0; i < array.size(); i++) {
				comp.add(array.get(i).getorg().toLowerCase());
			}

			// If the artist/album is already made, delete from database
			for (int q = 0; q < database.size(); q++) {

				if (comp.contains(
						database.get(q).getArtist().toLowerCase() + database.get(q).getAlbum().toLowerCase())) {
					database.remove(q);
					q = q - 1;
				}

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

		// If there is at least 1 album, show screen
		if (database.size() > 0) {
			ScanAlbumScreen screen = new ScanAlbumScreen(database, _user);
			screen.show();
		}

	}

}
