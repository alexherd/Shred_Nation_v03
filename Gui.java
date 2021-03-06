import java.io.File;
import org.bouncycastle.crypto.CryptoException;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Gui {
	Button addMusic, editMusic, delMusic, scanMusic, sortMusic, clearText;

	private String _user;
	private String _pass;

	public Gui(String user, String pass) {
		_user = user;
		_pass = pass;
	}

	// Fix this fucking mess
	public void setBtnSizes() {
		addMusic.setPrefSize(80, 80);
		editMusic.setPrefSize(80, 80);
		delMusic.setPrefSize(80, 80);
		scanMusic.setPrefSize(80, 80);
		sortMusic.setPrefSize(80, 80);
		clearText.setPrefSize(80, 80);
	}

	public void showGUI() {

		// Root Node
		BorderPane root = new BorderPane();

		// MenuBar
		MenuBar menuBar = new MenuBar();

		// Menu1
		Menu file = new Menu("File");

		// Menu Items
		MenuItem itmExport = new MenuItem("Export");
		MenuItem itmLogOut = new MenuItem("Log Out");
		MenuItem itmExit = new MenuItem("Exit");

		// Menu2
		Menu preferences = new Menu("Preferences");

		// Menu Item
		MenuItem itmOptions = new MenuItem("Options");
		
		// Submenu ****NEW****
		Menu subCustom = new Menu("Customize");

		// Submenu Items (Style Sheets) ****NEW****
		MenuItem itmDefault = new MenuItem("Default");
		MenuItem itmDeadsong = new MenuItem("Deadsong");
		MenuItem itmFountain = new MenuItem("Fountain");
		MenuItem itmMedusalem = new MenuItem("Medusalem");
		MenuItem itmStormcrow = new MenuItem("Stormcrow");
		MenuItem itmUncharted = new MenuItem("Uncharted");
		
		// Menu3
		Menu help = new Menu("Help");

		// Menu Items
		MenuItem itmChanges = new MenuItem("Changes");
		MenuItem itmGuide = new MenuItem("Guide");
		MenuItem itmCredits = new MenuItem("Credits");

		// Add MenuItems to Menus
		file.getItems().addAll(itmExport, itmLogOut, itmExit);
		subCustom.getItems().addAll(itmDefault, itmDeadsong, itmFountain, itmMedusalem, itmStormcrow, itmUncharted);
		preferences.getItems().addAll(itmOptions, subCustom);
		help.getItems().addAll(itmChanges, itmGuide, itmCredits);

		// Add Menus to MenuBar
		menuBar.getMenus().addAll(file, preferences, help);

		// TabPane
		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		// Music Tab
		Tab tabMusic = new Tab();
		tabMusic.setText("Music");

		// Music Tab Layout
		BorderPane paneMusic = new BorderPane();

		// Add scrollpane to layout for displaying information to user via text
		ScrollPane scrollMusic = new ScrollPane();
		scrollMusic.setPadding(new Insets(5,10,5,10));
		Text displayText = new Text("Welcome to Shred Nation " + _user + "!");
		scrollMusic.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollMusic.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scrollMusic.setContent(displayText);
		paneMusic.setCenter(scrollMusic);
		

		// Music Buttons
		addMusic = new Button("Add");
		editMusic = new Button("Edit");
		delMusic = new Button("Delete");
		scanMusic = new Button("Scan");
		sortMusic = new Button("Sort");
		clearText = new Button("Clear");

		// add Event Handlers to buttons
		addMusic.setOnAction(new AddAlbumAlert(_user));
		editMusic.setOnAction(new EditMusicHandler(_user));
		delMusic.setOnAction(new DelMusicHandler(_user));
		scanMusic.setOnAction(new ScanMusicHandler(_user));
		sortMusic.setOnAction(new SortMusicHandler(_user,displayText));
		clearText.setOnAction(new ClearTextHandler(displayText));

		// GridPane for Music
		GridPane gridMusic = new GridPane();
		gridMusic.setHgap(5);
		gridMusic.setVgap(5);
		gridMusic.setPadding(new Insets(10, 10, 10, 10));
		gridMusic.setAlignment(Pos.CENTER);

		// Add buttons to gridMusic
		gridMusic.add(addMusic, 0, 0);
		gridMusic.add(editMusic, 1, 0);
		gridMusic.add(delMusic, 0, 1);
		gridMusic.add(scanMusic, 1, 1);
		gridMusic.add(sortMusic, 0, 2);
		gridMusic.add(clearText, 1, 2);
		paneMusic.setRight(gridMusic);

		// Add layout to music tab
		tabMusic.setContent(paneMusic);

		//Controversial
		setBtnSizes();

		// Add Tabs to tabPane
		tabPane.getTabs().add(tabMusic);

		// Add everything to root borderlayout
		root.setTop(menuBar);
		root.setCenter(tabPane);

		// Usual suspects
		Scene sceneMusic = new Scene(root, 600, 500);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Shred Nation - " + _user);

		// Add event handlers to File Menu
		itmExit.setOnAction(new ExitHandler(primaryStage, 0, _user, _pass));
		itmLogOut.setOnAction(new ExitHandler(primaryStage, 1, _user, _pass));
		
		// Event handlers to Preferences
		itmOptions.setOnAction(new OptionsHandler(_user, _pass));
		
		// Add Event Handlers to Submenu Items
		itmDefault.setOnAction(new StyleHandler(sceneMusic, 0, _user));
		itmDeadsong.setOnAction(new StyleHandler(sceneMusic, 1, _user));
		itmFountain.setOnAction(new StyleHandler(sceneMusic, 2, _user));
		itmMedusalem.setOnAction(new StyleHandler(sceneMusic, 3, _user));
		itmStormcrow.setOnAction(new StyleHandler(sceneMusic, 4, _user));
		itmUncharted.setOnAction(new StyleHandler(sceneMusic, 5, _user));
		
		// Change Menu
		itmChanges.setOnAction(new ChangesHandler(displayText));

		ReadFile readFile = new ReadFile(_user);

		if (readFile.getUse().substring(2, 3).equals("0")) {
			sceneMusic.getStylesheets().add("Default.css");
		} else if (readFile.getUse().substring(2, 3).equals("1")) {
			sceneMusic.getStylesheets().add("Deadsong.css");
		} else if (readFile.getUse().substring(2, 3).equals("2")) {
			sceneMusic.getStylesheets().add("Fountain.css");
		} else if (readFile.getUse().substring(2, 3).equals("3")) {
			sceneMusic.getStylesheets().add("Medusalem.css");
		} else if (readFile.getUse().substring(2, 3).equals("4")) {
			sceneMusic.getStylesheets().add("Stormcrow.css");
		} else {
			sceneMusic.getStylesheets().add("Uncharted.css");
		} 

		// When the program is exited it will re-encrypt files
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				String q = System.getProperty("user.name");

				try {
					// encrypts the list
					File file1 = new File("/Users/" + q + "/Documents/Shred_Nation/Profiles/" + _user + "/List.ser");
					Encryption.encrypt(_pass, file1, file1);

					// encrpyts the properties file
					file1 = new File(
							"/Users/" + q + "/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
					Encryption.encrypt(_pass, file1, file1);
				} catch (CryptoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// Set scene and show
		primaryStage.setScene(sceneMusic);
		primaryStage.show();

	}

}

// <------ALEX------>
// Remove profile tab (this tab is useless) **DONE**
// File Menu (EXIT / LOG OFF DON'T ENCRYPT WHEN USED OTHERWISE FINE)
// Options Menu **WORKING ON**
// Have text show in textarea w/ scroll bar and a clear button **DONE**
// Get changes menu working **DONE**
// Improve CSS **WORKING ON**

// ******* ONLY MADE CHANGES TO Gui CLASS *********
// NEW CLASSES ADDED: ClearTextHandler, ChangesHandler, ExitHandler
// NEWER CLASSED ADDED: Options, OptionsHandler

/*
 * Ideas TO-DO Handle Button Actions (IN PROGRESS) Sort out this mess of a code
 * (new classes for profile/music tabs) I'm a good coder I swear (IN PROGRESS)
 * Make buttons with images in list view on right of stage Cutomize icons Create
 * CSS Add new popup menu to customize color scheme?
 * 
 * 
 * mike bug fix-
 * make sure alerts stay on top... because they dont
 * 
 * encrypt backup files
 * program crashes, cant loig into account
 * 
 * check debug to see if there is something that shows what vars are still in memory to see how we can clean it up more
 * make sure main screen is disabled when doing other stuff, if on wait doesnt work check newaccounthandler to see how i did it before
 * make exit buttons work lol
 * make a credits/about in help
 * make a real help menu about program maybe?
 */
