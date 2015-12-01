import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class SortMusicHandler implements EventHandler<ActionEvent>{
	private String _user;
	private Text _text;
	public SortMusicHandler(String user, Text text){
		_user = user;
		_text = text;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		Alert alertSortMusic = new Alert(AlertType.CONFIRMATION);
		alertSortMusic.setTitle("Sort Music");
		alertSortMusic.setHeaderText("How would you like to sort?");
		
		//Buttons
		ButtonType sortAlphabet = new ButtonType("Alphabetically");
		ButtonType sortRatingHigh = new ButtonType("Rating (High-Low)");
		ButtonType sortRatingLow = new ButtonType("Songs in range");
		ButtonType sortCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
		//Add buttons to alert
		alertSortMusic.getButtonTypes().setAll(sortAlphabet, sortRatingHigh, sortRatingLow, sortCancel);
		
		//Get user input
		Optional<ButtonType> sortInput = alertSortMusic.showAndWait();
		if(sortInput.get() == sortAlphabet){
			ListAlpha alpha = new ListAlpha(_user, _text);
			alpha.Unbreakable();
		}
		else if (sortInput.get() == sortRatingHigh){
			ListRank rank = new ListRank(_user, _text);
			rank.Unbreakable();
		}
		else if (sortInput.get() == sortRatingLow){
			SortRangeAlert range = new SortRangeAlert(_user,_text);
			range.Range();
		}
		else{
			//CANCEL OR CLOSED DIALOG BOX
		}	
	}
}
