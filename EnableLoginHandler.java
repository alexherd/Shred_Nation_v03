import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;


public class EnableLoginHandler implements EventHandler<WindowEvent> {

	private GridPane _grid;
	private Text _text;
	
	public EnableLoginHandler(GridPane grid, Text text){
		_grid = grid;
		_text = text;
	}


	@Override
	public void handle(WindowEvent arg0) {
		
		
		_grid.setDisable(false);
		_text.setFill(Color.BLACK);
		
	}

}
