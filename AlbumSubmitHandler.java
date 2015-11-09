import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AlbumSubmitHandler implements EventHandler {

	private GridPane _grid;
	public AlbumSubmitHandler(GridPane grid){
		_grid = grid;
	}
	
	
	@Override
	public void handle(Event arg0) {
		System.out.println(_grid.getChildren().size());
		
		ArrayList<TextField> grid = new ArrayList<TextField>();
		ObservableList<Node> childrens = _grid.getChildren();
        for(Node node : childrens) {
        	grid.add((TextField)node);
        }
		
ArrayList<TextField> songName = new ArrayList<TextField>(); 
ArrayList<TextField> songScore = new ArrayList<TextField>(); 

		for(int i = 0; i < _grid.getChildren().size(); i = i  + 2){
			songName.add(grid.get(i));
		}
		
		for(int i = 1; i < _grid.getChildren().size(); i = i  + 2){
			songScore.add(grid.get(i));
		}
		
		
		
		
		
	}

}
