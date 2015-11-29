import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OptionsHandler implements EventHandler<ActionEvent> {
	
	@Override
	public void handle(ActionEvent arg0) {
		Options options = new Options();
		options.showOptions();
	}
}
