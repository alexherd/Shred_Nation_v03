
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;




//takes in the Directory to use to get all files inside it
public class DirGet implements ActionListener {
	private String _dir;

	public DirGet(String dir) {
		_dir = dir;
	}

	public void actionPerformed(ActionEvent arg0) {
 
		
		Prog prog = new Prog();
		prog.start();
		// uses a stack to make a list for the folders, data holds all of the songs
		Stack<String> stack = new Stack<String>();
		ArrayList<Song> data = new ArrayList<Song>();
		stack.add(_dir);

		//will keep going while there is a folder in the stack to look at
		while (stack.isEmpty() == false) {

			File folder = new File(stack.peek());
			File[] hold = folder.listFiles();
			stack.pop();

			//The for loop checks ever file in a folder and determines if it is a mp3 file or folder or none 
			try {
				for (int i = 0; i < hold.length; i++) {
					String use = hold[i].toString();

					if (use.substring(use.length() - 4).equals(".mp3")) {
						Mp3File mp3file = new Mp3File(use);
						if (mp3file.hasId3v1Tag()) {
							ID3v1 id3v1Tag = mp3file.getId3v1Tag();
							data.add(new Song(id3v1Tag.getTitle(), use, id3v1Tag.getAlbum(), id3v1Tag.getArtist()));
						}
					}
					if (hold[i].isDirectory() == true)
						stack.push(use);
				}

			} catch (IOException | UnsupportedTagException | InvalidDataException | NullPointerException e) {
			}
		}
		
		
		ArrayList<String> playlist = new ArrayList<String>();
		
		for(int y = 0; y < data.size() ; y++){
			String test = data.get(y).getBand() + "/" + data.get(y).getAlbum();
			test = test.toLowerCase();
			if(!playlist.contains(test)){
				playlist.add(test);
			}
			
		}
		
		int count = playlist.size();
		 for(int i = 0; i < count; i++){

		 for(int p = i + 1; p < count; p++){
		 	
		 	if(playlist.get(p).compareTo(playlist.get(i))<0){
		 		String hold = playlist.get(p);
		 		playlist.remove(p);
		 		playlist.add(i, hold);
		 	}

		 }	
		 }
		
		
		
		
		for(int q = 0; q < playlist.size(); q++){
			System.out.println(playlist.get(q));
		}
		
		

		
	
		
		
		
		
		
		
		
		
		
	
	}

	public class Prog extends Thread {

	    public void run() {
	    	ProgressBarExamples ppp = new ProgressBarExamples();
	    }



	}
}
