import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MP3Player implements EventHandler<ActionEvent> {

	private String _file;
	private MediaPlayer _mediaPlayer;
	private Button _button;

	public MP3Player(String string, Button button) {
		_file = string;
		_button = button;
		_file = _file.replace(" ", "%20");
		_file = _file.replace("[", "%5B");
		_file = _file.replace("]", "%5D");

		String bip = "file:" + _file.substring(2);
		Media hit = new Media(bip);
		_mediaPlayer = new MediaPlayer(hit);

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start() {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() {

				_mediaPlayer.play();

				return null;
			}
		};

		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();

	}

	public void stop() {

		_mediaPlayer.pause();
	}

	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

		if (_button.getText().equals("Play")) {
			this.start();
			_button.setText("Stop");
		} else {
			this.stop();
			_button.setText("Play");
		}

	}

}