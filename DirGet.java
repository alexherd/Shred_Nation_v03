
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.control.TextField;




//takes in the Directory to use to get all files inside it
public class DirGet {
	private String _dir;
	private String _user;

	public DirGet(String dir, String user) {
		_dir = dir;
		_user = user;
	}

	public void start() {
 

		// uses a stack to make a list for the folders, data holds all of the songs
		Stack<String> stack = new Stack<String>();
		ArrayList<Song> data = new ArrayList<Song>();
		stack.add(_dir);
		ArrayList<AlbumLoc> database = new ArrayList<AlbumLoc>();
		boolean inDataBase = false;
		
		
		
		//will keep going while there is a folder in the stack to look at
		while (stack.isEmpty() == false) {

			File folder = new File(stack.peek());
			File[] hold = folder.listFiles();
			
	
			
			stack.pop();

			//The for loop checks ever file in a folder and determines if it is a mp3 file or folder or none 
			try {

				for (int i = 0; i < hold.length; i++) {
					String use = hold[i].toString();
					use = use.replace("\\", "/");
					//use = use.replace(" ", "%20");
					if (use.substring(use.length() - 4).equals(".mp3")) {
						
						Mp3File mp3file = new Mp3File(use);
						if (mp3file.hasId3v1Tag()) {
							ID3v1 id3v1Tag = mp3file.getId3v1Tag();
							System.out.println(id3v1Tag.getTitle() + " - " + id3v1Tag.getArtist());
							for(int q = 0; q < database.size(); q++){
								if((database.get(q).getArtist() + database.get(q).getAlbum()).compareTo(id3v1Tag.getArtist() + id3v1Tag.getAlbum()) == 0 ){
									inDataBase = true;
								 
									database.get(q).getList().add(new Song(id3v1Tag.getTitle(), use));
									break;
								}
								
							}
							
							if(inDataBase == false){
								database.add(new AlbumLoc(id3v1Tag.getArtist() , id3v1Tag.getAlbum(), new ArrayList<Song>()   ));
								database.get(database.size()-1).getList().add(new Song(id3v1Tag.getTitle(), use));
								
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
		
		
		
		
		ReadFile fe = new ReadFile(_user);
		 try {
	 	ObjectInputStream in = new ObjectInputStream(new FileInputStream(fe.getLoc()));
	 	ArrayList<Album> array = (ArrayList<Album>) in.readObject();
	    in.close();
	    ArrayList<String> comp = new ArrayList<String>();
	    
	    for(int i = 0; i < array.size(); i++){
	    	comp.add(array.get(i).getorg().toLowerCase());
	    }
	    
	

	    
	    
	    
	    for(int q = 0; q < database.size(); q++){
	    	
	    	if(comp.contains(database.get(q).getArtist().toLowerCase() + database.get(q).getAlbum().toLowerCase()) ){
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
	 
	 

/*
		for(int k = 0; k < database.size(); k++ ){
			System.out.println(database.get(k).getArtist() + " - " + database.get(k).getAlbum() + " songs are:");
			for(int q = 0; q < database.get(k).getList().size(); q++){
				System.out.println(database.get(k).getList().get(q).getSong());
			}
			}
			*/

		if(database.size() > 0){
			ScanAlbumScreen screen = new ScanAlbumScreen(database, _user);
			screen.show();
		}
		
		
	
	}





	
}
