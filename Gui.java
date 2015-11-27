import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.bouncycastle.crypto.CryptoException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Gui {
	Button addMusic, editMusic, delMusic, scanMusic, rateMusic, sortMusic,
			addProfile, delProfile, viewProfile, compProfile;

	private String _user;
	private String _pass;
	
	public Gui(String user, String pass){
		_user = user;
		_pass = pass;
	}
	
	
	
	
	
	// Fix this fucking mess (Do in css)
	public void setBtnSizes() {
		addMusic.setPrefSize(80, 80);
		editMusic.setPrefSize(80, 80);
		delMusic.setPrefSize(80, 80);
		scanMusic.setPrefSize(80, 80);
		rateMusic.setPrefSize(80, 80);
		sortMusic.setPrefSize(80, 80);
		addProfile.setPrefSize(80, 80);
		delProfile.setPrefSize(80, 80);
		viewProfile.setPrefSize(80, 80);
		compProfile.setPrefSize(80, 80);
	}

	public void showGUI() {

		// Root Node
		BorderPane root = new BorderPane();

		// MenuBar
		MenuBar menuBar = new MenuBar();

		// Menu1
		Menu file = new Menu("File");

		// Menu Items
		MenuItem itmNew = new MenuItem("New");
		MenuItem itmDel = new MenuItem("Delete");
		MenuItem itmView = new MenuItem("View");
		MenuItem itmSwitch = new MenuItem("Switch");
		

		// Menu2
		Menu options = new Menu("Options");
		
		//Submenu ****NEW****
		Menu subCustom = new Menu("Customize");
		
		//Submenu Items (Style Sheets) ****NEW****
		MenuItem itmDefault = new MenuItem("Default");
		MenuItem itmForest = new MenuItem("Forest");
		MenuItem itmStormcrow = new MenuItem("Stormcrow");

		// Menu Items
		MenuItem itmCustom = new MenuItem("Customize");

		// Menu3
		Menu help = new Menu("Help");

		// Menu Items
		MenuItem itmChanges = new MenuItem("Changes");

		// Add MenuItems to Menus
		file.getItems().addAll(itmNew, itmDel, itmView, itmSwitch);
		subCustom.getItems().addAll(itmDefault, itmForest, itmStormcrow);
		options.getItems().add(subCustom);
		help.getItems().add(itmChanges);

		// Add Menus to MenuBar
		menuBar.getMenus().addAll(file, options, help);

		// TabPane
		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		// Music Tab
		Tab tabMusic = new Tab();
		tabMusic.setText("Music");

		// Music Tab Layout
		BorderPane paneMusic = new BorderPane();

		// Add label to layout
		Label labelMusic = new Label();
		labelMusic.setText("Music stuff shows here.");
		paneMusic.setCenter(labelMusic);

		// Music Buttons
		addMusic = new Button("Add");
		editMusic = new Button("Edit");
		delMusic = new Button("Delete");
		scanMusic = new Button("Scan");
		rateMusic = new Button("Rate");
		sortMusic = new Button("Sort");

		// NEW! Button Event Handlers NEW!
		// add Event Handlers to buttons
		addMusic.setOnAction(new AddMusicHandler(_user));
		editMusic.setOnAction(new EditMusicHandler(_user));
		delMusic.setOnAction(new DelMusicHandler(_user));
		scanMusic.setOnAction(new ScanMusicHandler(_user));
		rateMusic.setOnAction(new RateMusicHandler());
		sortMusic.setOnAction(new SortMusicHandler());

		// GridPane for Music
		GridPane gridMusic = new GridPane();
		gridMusic.setHgap(5);
		gridMusic.setVgap(5);
		gridMusic.setPadding(new Insets(10, 10, 10, 10));
		gridMusic.setAlignment(Pos.CENTER);

		// Add buttons to gridMusic
		gridMusic.add(addMusic, 0, 0);
		gridMusic.add(editMusic, 0, 1);
		gridMusic.add(delMusic, 0, 2);
		gridMusic.add(scanMusic, 1, 0);
		gridMusic.add(rateMusic, 1, 1);
		gridMusic.add(sortMusic, 1, 2);
		paneMusic.setRight(gridMusic);

		// Add layout to music tab
		tabMusic.setContent(paneMusic);

		// Profile Tab
		Tab tabProfile = new Tab();
		tabProfile.setText("Profile");

		// Profile Tab Layout
		BorderPane paneProfile = new BorderPane();

		// Add label to Profile layout
		Label labelProfile = new Label();
		labelProfile.setText("Profile stuff shows here.");
		paneProfile.setCenter(labelProfile);

		// Profile Buttons
		addProfile = new Button("Add");
		delProfile = new Button("Delete");
		viewProfile = new Button("View");
		compProfile = new Button("Compare");

		// GridPane for Profile
		GridPane gridProfile = new GridPane();
		gridProfile.setHgap(5);
		gridProfile.setVgap(5);
		gridProfile.setPadding(new Insets(10, 10, 10, 10));
		gridProfile.setAlignment(Pos.CENTER);

		// Add Buttons to gridProfile
		gridProfile.add(addProfile, 0, 0);
		gridProfile.add(delProfile, 0, 1);
		gridProfile.add(viewProfile, 1, 0);
		gridProfile.add(compProfile, 1, 1);
		paneProfile.setRight(gridProfile);

		// Add layout to profile tab
		tabProfile.setContent(paneProfile);

		setBtnSizes();

		// Add Tabs to tabPane
		tabPane.getTabs().addAll(tabMusic, tabProfile);

		// Add everything to root borderlayout
		root.setTop(menuBar);
		root.setCenter(tabPane);


		
		// Usual suspects
		Scene sceneMusic = new Scene(root, 600, 500);
		
		ReadFile readFile = new ReadFile(_user);
		
		if(readFile.getUse().substring(2, 3).equals("0")){
		sceneMusic.getStylesheets().add("Shred_Style.css");
		}
		
		if(readFile.getUse().substring(2, 3).equals("2")){
		sceneMusic.getStylesheets().add("Stormcrow.css");
		}
		
		if(readFile.getUse().substring(2, 3).equals("1")){
		sceneMusic.getStylesheets().add("Forest.css");
		}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Shred Nation - " + _user);
		primaryStage.setScene(sceneMusic);
		primaryStage.show();
		
		//Add Event Handlers to Submenu Items ****NEW****
		itmDefault.setOnAction(new StyleHandler(sceneMusic, 0,_user));
		itmForest.setOnAction(new StyleHandler(sceneMusic, 1,_user));
		itmStormcrow.setOnAction(new StyleHandler(sceneMusic, 2,_user));
		
		// When the program is exited it will re-encrypt files
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
            	String q = System.getProperty("user.name");
			
				try {
					//encrypts the list
					File file1 = new File("/Users/" + q + "/Documents/Shred_Nation/Profiles/" + _user + "/List.ser");
					Encryption.encrypt(_pass, file1, file1);
					
					//encrpyts the properties file
					file1 = new File("/Users/" + q + "/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
					Encryption.encrypt(_pass, file1, file1);
				} catch (CryptoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
            }
        });
        
        

	}

}

/*
 * Ideas TO-DO Handle Button Actions (IN PROGRESS) Sort out this mess of a code
 * (new classes for profile/music tabs) I'm a good coder I swear (IN PROGRESS)
 * Make buttons with images in list view on right of stage Cutomize icons Create
 * CSS Add new popup menu to customize color scheme?
 * 
 * 
 * mike bug fix-
 * make sure alerts stay on top... because they dont
 * dont let user name be blank, it accepts it
 * encrypt backup files
 * 
 */