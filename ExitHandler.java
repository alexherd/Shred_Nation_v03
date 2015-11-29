import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ExitHandler implements EventHandler<ActionEvent> {
	private Stage _stage;
	private int _i;

	public ExitHandler(Stage stage, int i) {
		_stage = stage;
		_i = i;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if (_i == 0) {
			_stage.close();
			_stage = null;
		} else {
			_stage.close();
			_stage = null;
			Login login = new Login();
			try {
				login.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
