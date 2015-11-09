import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class SortMusicHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		Alert alertSortMusic = new Alert(AlertType.CONFIRMATION);
		alertSortMusic.setTitle("Sort Music");
		alertSortMusic.setHeaderText("How would you like to sort?");
		
		//Buttons
		ButtonType sortAlphabet = new ButtonType("Alphabetically");
		ButtonType sortRatingHigh = new ButtonType("Rating (High-Low)");
		ButtonType sortRatingLow = new ButtonType("Rating (Low-High)");
		ButtonType sortCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
		//Add buttons to alert
		alertSortMusic.getButtonTypes().setAll(sortAlphabet, sortRatingHigh, sortRatingLow, sortCancel);
		
		//Get user input
		Optional<ButtonType> sortInput = alertSortMusic.showAndWait();
		if(sortInput.get() == sortAlphabet){
			//ALPHABETICALLY PICKED
		}
		else if (sortInput.get() == sortRatingHigh){
			//HIGH TO LOW PICKED
		}
		else if (sortInput.get() == sortRatingLow){
			//LOW TO HIGH PICKED
		}
		else{
			//CANCEL OR CLOSED DIALOG BOX
		}	
	}
}
