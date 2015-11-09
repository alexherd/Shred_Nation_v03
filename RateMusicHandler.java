import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class RateMusicHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		TextInputDialog dialogRateMusic = new TextInputDialog("enter \"ub\" for a secret");
		dialogRateMusic.setTitle("Rate Music");
		dialogRateMusic.setHeaderText("What would you like to rate?");
		dialogRateMusic.setContentText("Album Name:");
		Optional<String> rateInput = dialogRateMusic.showAndWait();
		if (rateInput.isPresent()){
			//Possibly keep???
			if(rateInput.get().toLowerCase().equals("ub")){
				Alert alertUB = new Alert(AlertType.WARNING);
				alertUB.setTitle("UH-OH SHIT SCHOOL ALERT!");
				alertUB.setHeaderText("Why do you think it's a bad school?");
				alertUB.setContentText("We don't think, we know.");
				alertUB.showAndWait();
			}
			//SEARCH FOR ALBUM??
		}
	}
}
