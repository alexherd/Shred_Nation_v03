import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Options {
	
	
	public void showOptions(){
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5,10,5,10));
		Scene optionScene = new Scene(root, 250, 250);
		Stage optionStage = new Stage();
		optionStage.setTitle("Options");
		
		//VBox for options
		VBox vbox = new VBox(10);
		
		//CheckBox
		CheckBox autofind = new CheckBox("Auto-find with Google Play");
		
		//Text
		Text text = new Text("Backup frequency:");
		
		//ChoiceBox
		ChoiceBox<Integer> backup = new ChoiceBox<Integer>();
		backup.getItems().addAll(0,1,5,10);
		
		
		//VBox stuff
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(autofind, text, backup);
		
		//HBox for Ok & Cancel (hungrybox confirmed)
		HBox hbox = new HBox(3);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		//Ok & Cancel Buttons
		Button ok = new Button("Ok");
		Button cancel = new Button("Cancel");
		
		//Event Handlers 
		//MAKE HANDLER FOR OK SAVE TO FILE OR SOMETHING SO IT CAN BE READ AFTER ITS CLOSED	
		cancel.setOnAction(new ExitHandler(optionStage, 0));
		hbox.getChildren().addAll(ok, cancel);
		
		//Add VBox & HBox to main pane
		root.setCenter(vbox);
		root.setBottom(hbox);
		
		optionStage.setScene(optionScene);
		optionStage.initModality(Modality.APPLICATION_MODAL);
		optionStage.show();
	}
}
