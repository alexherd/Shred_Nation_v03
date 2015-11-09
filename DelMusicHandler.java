import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

public class DelMusicHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		TextInputDialog dialogDelMusic = new TextInputDialog();
		dialogDelMusic.setTitle("Delete Music");
		dialogDelMusic.setHeaderText("What would you like to delete?");
		dialogDelMusic.setContentText("Album Name:");
		Optional<String> delInput = dialogDelMusic.showAndWait();
		if (delInput.isPresent()){
			//SEARCH FOR ALBUM??
		}
	}
}
