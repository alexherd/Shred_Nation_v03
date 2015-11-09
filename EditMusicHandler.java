import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

public class EditMusicHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		TextInputDialog dialogEditMusic = new TextInputDialog();
		dialogEditMusic.setTitle("Edit Music");
		dialogEditMusic.setHeaderText("What would you like to edit?");
		dialogEditMusic.setContentText("Album Name:");
		Optional<String> editInput = dialogEditMusic.showAndWait();
		if (editInput.isPresent()) {
			// SEARCH FOR ALBUM??
		}
	}
}
