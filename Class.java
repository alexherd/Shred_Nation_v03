import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Class implements Runnable {

	 public void run(){  
		 String bip = "file:/Users/Mike/Music/Carnival.mp3";
			Media hit = new Media(bip);
			MediaPlayer mediaPlayer = new MediaPlayer(hit);
			mediaPlayer.play();
	 
		  }   
		  public static void main(String args[]){  
		     Class obj=new Class();  
		     Thread tobj =new Thread(obj);  
		     tobj.start();  
		 }  
}