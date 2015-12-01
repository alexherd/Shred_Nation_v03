import java.util.ArrayList;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SortRangeAlert {
	
	private String _user;
	private Text _text;
	public SortRangeAlert(String user, Text text){
		_user = user;
		_text = text;
	}

	
	public void Range(){
	Alert alertEditMusic = new Alert(AlertType.CONFIRMATION);
	alertEditMusic.setTitle("Edit Music");
	alertEditMusic.setHeaderText("What Album would you like to change?");

	GridPane grid = new GridPane();
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(20, 150, 10, 10));
	TextField num1 = new TextField();
	TextField num2 = new TextField();
	grid.add(new Label("From      -       "), 0, 0);
	grid.add(num1, 1, 0);
	grid.add(new Label("To          -     "), 0, 1);
	grid.add(num2, 1, 1);
	alertEditMusic.getDialogPane().setContent(grid);

	// Buttons
	ButtonType addAlbum = new ButtonType("Continue");
	ButtonType addCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

	// Add buttons to alert
	alertEditMusic.getButtonTypes().setAll(addAlbum, addCancel);

	// Get user input
	Optional<ButtonType> addInput = alertEditMusic.showAndWait();
	if (addInput.get() == addAlbum) {
		ArrayList<Integer> range = new ArrayList<Integer>();
		int number1 = 0;
		int number2 = 0;
		
		
		try{
			 number1 = Integer.parseInt(num1.getText());
			 number2 = Integer.parseInt(num2.getText());
		} catch(NumberFormatException e){
			return;
		}
		
		if(number1 > 10){
			return;
		}
		
		if(number2 > 10){
			return;
		}
		
		if(number1 < -1){
			return;
		}
		
		if(number2 <-1 ){
			return;
		}
		
		if(number2 > number1){
		for (int i = number1; i <= number2; i++ ){
			range.add(i);
			
		}
		
		}
		
		
		
		
		if(number1 > number2){
			for (int i = number1; i  >= number2; i-- ){
				range.add(i);
				
			}
			
			}
		
		if(number1 == number2){
			
				range.add(number1);
			
			
			}
		
			ListRange lrange = new ListRange(_user,_text,range);
			lrange.Unbreakable();

	} else {
		// CANCEL OR CLOSED DIALOG BOX
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}
