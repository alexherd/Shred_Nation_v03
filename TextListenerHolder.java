import javafx.scene.control.TextField;

public class TextListenerHolder {

	private TextField _text;
	private TextfieldListener _listener;
	
	public TextListenerHolder(TextField text, TextfieldListener listener){
		_text = text;
		_listener = listener;
	}
	
	
	public void setList(TextfieldListener listener){
    	_listener = listener;
    }
    public TextfieldListener getList(){
    	return _listener;
    }
    
	public void setText(TextField text){
    	_text = text;
    }
    public TextField getText(){
    	return _text;
    }
	
	
}
