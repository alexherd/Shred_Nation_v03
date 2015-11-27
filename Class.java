import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Class implements Runnable {
	private static String _file;
	public Class(String file){
		_file = file;
	}

	 public void run(){  
		 System.out.println(_file);
		 String bip = "file:" + _file;
			Media hit = new Media(bip);
			MediaPlayer mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.play();
	 
		  }   
		  public static void main(String args[]){  
		     Class obj=new Class(_file);  
		     Thread tobj =new Thread(obj);  
		     tobj.start();  
		 }  
}