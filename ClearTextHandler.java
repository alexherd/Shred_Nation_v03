import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ClearTextHandler implements EventHandler<ActionEvent> {
	private Text _text;
	
	public ClearTextHandler(Text text){
		_text = text;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		_text.setText("");
	}

}
