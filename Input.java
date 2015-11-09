import java.awt.GridLayout;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.MalformedURLException;
import java.net.URL;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;


public class Input {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Im a real boy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		JPanel mainp = new JPanel();
		GridLayout lay1 = new GridLayout(0, 1);
		mainp.setLayout(lay1);
		JLabel j1 = new JLabel("Enter the dir");
		TextField f = new TextField();
		f.setText("/Users/Mike/Music");
		JButton b = new JButton("Enter");
		frame.add(mainp);
		mainp.add(j1);
		mainp.add(f);
		mainp.add(b);
		frame.pack();
		b.addActionListener(new DirGet(f.getText()));
		
	
		
		
		
	
	
	}
	

				

}
