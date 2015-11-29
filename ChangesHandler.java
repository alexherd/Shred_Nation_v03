import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ChangesHandler implements EventHandler<ActionEvent> {
	private Text _text;
	private String _changes;
	
	public ChangesHandler(Text text){
		_text = text;
		
		//CHANGE PATCH NOTES HERE, PROBABLY NOT HOW YOU DO THIS BUT FUCK OFF
		_changes = "Version 0.1\n" +
				   "- Changes Menu works\n" +
				   "- Menu Bar under construction\n" +
				   "- Scroll Pane for display added\n" +
				   "- Clear Button clears display HA DURR\n" +
				   "- CSS files updated";
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		_text.setText(_changes);
	}

}

