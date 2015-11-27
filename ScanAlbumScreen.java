import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ScanAlbumScreen{


	private String _user;
	private ArrayList<AlbumLoc> _database;
	
public ScanAlbumScreen(ArrayList<AlbumLoc> database, String user){
	_database = database;
	_user = user;
}

	public void show() {
		// TODO Auto-generated method stub
		
		Stage stage = new Stage();
		VBox main = new VBox();
		GridPane gridA = new GridPane();
		gridA.add(new Label("Artist :                                   "), 0, 0);
		gridA.add(new Label(_database.get(0).getArtist()), 1, 0);
		gridA.add(new Label("Album : "), 0, 1);
		gridA.add(new Label(_database.get(0).getAlbum()), 1, 1);
		gridA.add(new Label("Song Name     "), 0, 2);
		gridA.add(new Label("Scores        "), 1, 2);
		main.getChildren().add(gridA);
		
		  ArrayList<String> songList = new ArrayList<String>();
		  ArrayList<String> loc = new ArrayList<String>();
          for(int i = 0; i < _database.get(0).getList().size() ; i++){
        	  songList.add(_database.get(0).getList().get(i).getSong());
        	  loc.add(_database.get(0).getList().get(i).getLoc());
          }
		
		GridPane gridB = new GridPane();
		ArrayList<TextListenerHolder> holder = new ArrayList<TextListenerHolder>();
		
		int j = 0;
		for( j = 0; j < songList.size(); j++){
			Button button = new Button("Play");
			
			button.setOnAction(new MP3Player(loc.get(j), button   ));
			
			gridB.add(new TextField(songList.get(j)), 0, j);
			gridB.add(new TextField(), 1, j);
			gridB.add(button, 2, j);
			TextListenerHolder temp = new TextListenerHolder(null,null);
			holder.add(temp);
			
		}
		
		
		for(int i = j; i < 20; i++){
			
			TextfieldListener listen = new TextfieldListener(gridB, holder,stage);

			TextListenerHolder temp = new TextListenerHolder(new TextField(),listen);
			temp.getText().addEventHandler(KeyEvent.KEY_TYPED, listen);
			holder.add(temp);
			
		}
		
		
		
		gridB.add(new TextField(), 0, songList.size() );
		gridB.add(holder.get(songList.size()).getText(), 1, songList.size());
		
		
		
		main.getChildren().add(gridB);
		
		GridPane gridC = new GridPane();
		Button enter = new Button("               Enter                 ");
		Button exit = new Button ("               Exit                    ");
		gridC.add(enter, 0, 0);
		gridC.add(exit, 1, 0);
		main.getChildren().add(gridC);
		
		enter.setOnAction(new ScanSubmitHandler(gridB, _user,stage,_database));
		
		Scene scene = new Scene(main);
		stage.setScene(scene);
		stage.sizeToScene();
		//stage.setAlwaysOnTop(true);
		stage.show();
		
		
		
		
		
	}

}