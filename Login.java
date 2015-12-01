import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

	public void start(Stage primaryStage) throws Exception {

		// GridPane for root layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(5);
		root.setVgap(5);

		// Title
		Text title = new Text("Login");
		root.add(title, 0, 0, 2, 1);

		// User Name Label
		Label userName = new Label("User Name:");
		root.add(userName, 0, 1);

		// User Name TextField
		TextField tfUserName = new TextField();
		root.add(tfUserName, 1, 1);

		// Password Label
		Label password = new Label("Password:");
		root.add(password, 0, 2);

		// PasswordField
		PasswordField pfPassword = new PasswordField();
		root.add(pfPassword, 1, 2);

		// Log in Button
		Button btnLogin = new Button("Login");
		Button btnNew = new Button("New Account");

		// HBox for buttons
		HBox hbBtns = new HBox(5);
		hbBtns.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtns.getChildren().addAll(btnNew, btnLogin);
		root.add(hbBtns, 1, 4);

		// Show Stage
		Scene sceneLogin = new Scene(root, 350, 300);
		primaryStage.setTitle("Shred Nation");
		primaryStage.setScene(sceneLogin);
		primaryStage.show();
		primaryStage.setResizable(false);

		// Set Handlers to buttons
		btnLogin.setOnAction(new LoginHandler(tfUserName, pfPassword, primaryStage));
		btnNew.setOnAction(new NewAccountHandler(root, title));
	}

	public static void main(String[] args) {
		launch(args);
	}
}