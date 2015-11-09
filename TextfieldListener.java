
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextfieldListener implements EventHandler<KeyEvent> {



private GridPane _gridB;
private ArrayList<TextListenerHolder> _holder;
private Stage _stage;

	public TextfieldListener(GridPane gridB, ArrayList<TextListenerHolder> holder, Stage stage ) {
		_gridB = gridB;
		_holder = holder;
		_stage = stage;
	}

	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int row  = getRowCount(_gridB) - 1;
	
		
		_holder.get(row).getText().removeEventHandler(KeyEvent.KEY_TYPED, _holder.get(row).getList());
	
		if(!(row + 1 >= 20)){
		_gridB.add(new TextField(), 0, row + 1);
		_gridB.add(_holder.get(row + 1).getText(), 1, row + 1);
		_stage.sizeToScene();
		}
	
		
		
	}
	
	
	private int getRowCount(GridPane pane) {
        int numRows = pane.getRowConstraints().size();
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Node child = pane.getChildren().get(i);
            if (child.isManaged()) {
                Integer rowIndex = GridPane.getRowIndex(child);
                if(rowIndex != null){
                    numRows = Math.max(numRows,rowIndex+1);
                }
            }
        }
        return numRows;
    }
	

}
