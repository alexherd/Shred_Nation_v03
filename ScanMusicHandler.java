import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

public class ScanMusicHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		TextInputDialog dialogScanMusic = new TextInputDialog("C:\\Users\\"+System.getProperty("user.name")+"\\Music");
		dialogScanMusic.setTitle("Scan Music");
		dialogScanMusic.setHeaderText("Where would you like to scan?");
		dialogScanMusic.setContentText("Directory:");
		Optional<String> scanInput = dialogScanMusic.showAndWait();
		if (scanInput.isPresent()){
			//USE DIRECTORY??
		}
	}
}
