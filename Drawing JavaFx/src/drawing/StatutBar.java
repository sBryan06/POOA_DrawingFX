package drawing;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * @author bs
 *
 */
public class StatutBar extends HBox implements Observer {
	private Label label;
	private final DrawingPane drawingPane;

	int countShape = 0;

	public StatutBar(final DrawingPane d) {
		label = new Label(String.format("%d shape(s)", countShape));
		drawingPane = d;
		drawingPane.addObserver(this);
	}

	@Override
	public void update() {
		countShape = drawingPane.getNbShapes();
		label.setText(String.format("%d shape(s)", countShape));
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(final Label label) {
		this.label = label;
	}

	public int getCountShape() {
		return countShape;
	}

}
