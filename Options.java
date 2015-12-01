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
	
	private String _user;
	private String _pass;
	
	public Options(String user, String pass){
		_user = user;
		_pass = pass;
	}
	
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
		ReadFile read = new ReadFile(_user);
		String curFind = read.getUse().substring(1,2);
		if(curFind.equals("1")){
			autofind.setSelected(true);
		}
		autofind.setOnAction(new OptionsAutoFind(_user,autofind));
		
		//Text
		Text text = new Text("Backup frequency:");
		
		//ChoiceBox
		ChoiceBox<Integer> backup = new ChoiceBox<Integer>();
		backup.getItems().addAll(0,1,5,10,25);
		backup.setValue(Integer.parseInt(read.getFuture()));
		//backup.setOnAction(new OptionsBackup(_user, backup));
		
		//VBox stuff
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(autofind, text, backup);
		
		//HBox for Ok & Cancel (hungrybox confirmed)
		HBox hbox = new HBox(3);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		//Ok & Cancel Buttons
		
		Button cancel = new Button("Exit");
		
		//Event Handlers 
		//MAKE HANDLER FOR OK SAVE TO FILE OR SOMETHING SO IT CAN BE READ AFTER ITS CLOSED	
		cancel.setOnAction(new ExitHandler(optionStage, 2, _user, _pass));
		hbox.getChildren().addAll(cancel);
		
		//Add VBox & HBox to main pane
		root.setCenter(vbox);
		root.setBottom(hbox);
		
		optionStage.setScene(optionScene);
		optionStage.initModality(Modality.APPLICATION_MODAL);
		optionStage.show();
	}
}
