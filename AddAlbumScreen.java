import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AddAlbumScreen{

	private ArrayList<String> _songList;
	private TextField _artist;
	private TextField _album;
	
public AddAlbumScreen(ArrayList<String> songList, TextField artist, TextField album){
	_songList = songList;
	_artist = artist;
	_album = album;
}

	public void show() {
		// TODO Auto-generated method stub
		
		Stage stage = new Stage();
		VBox main = new VBox();
		GridPane gridA = new GridPane();
		gridA.add(new Label("Artist :                                   "), 0, 0);
		gridA.add(new Label(_artist.getText()), 1, 0);
		gridA.add(new Label("Album : "), 0, 1);
		gridA.add(new Label(_album.getText()), 1, 1);
		gridA.add(new Label("Song Name     "), 0, 2);
		gridA.add(new Label("Scores        "), 1, 2);
		main.getChildren().add(gridA);
		
		
		/*
				if(grid.getChildren().get(0).getClass().equals(lab.getClass())){
            	lab = (Label) grid.getChildren().get(0);
            	System.out.println(lab.getText());}
            	
            	*/
          
		
		GridPane gridB = new GridPane();
		ArrayList<TextListenerHolder> holder = new ArrayList<TextListenerHolder>();
		
		int j = 0;
		for( j = 0; j < _songList.size(); j++){
			gridB.add(new TextField(_songList.get(j)), 0, j);
			gridB.add(new TextField(), 1, j);
			TextListenerHolder temp = new TextListenerHolder(null,null);
			holder.add(temp);
			
		}
		
		
		for(int i = j; i < 20; i++){
			
			TextfieldListener listen = new TextfieldListener(gridB, holder,stage);

			TextListenerHolder temp = new TextListenerHolder(new TextField(),listen);
			temp.getText().addEventHandler(KeyEvent.KEY_TYPED, listen);
			holder.add(temp);
			
		}
		
		
		
		gridB.add(new TextField(), 0, _songList.size() );
		gridB.add(holder.get(_songList.size()).getText(), 1, _songList.size());
		
		
		
		main.getChildren().add(gridB);
		
		GridPane gridC = new GridPane();
		Button enter = new Button("               Enter                 ");
		Button exit = new Button ("               Exit                    ");
		gridC.add(enter, 0, 0);
		gridC.add(exit, 1, 0);
		main.getChildren().add(gridC);
		
		enter.setOnAction(new AlbumSubmitHandler(gridB));
		
		Scene scene = new Scene(main);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setAlwaysOnTop(true);
		stage.showAndWait();
		
		
		
		
		
	}

}
