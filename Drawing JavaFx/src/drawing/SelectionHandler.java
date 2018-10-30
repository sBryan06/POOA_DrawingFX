package drawing;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionHandler implements EventHandler<MouseEvent> {

	Logger logger = Logger.getLogger(SelectionHandler.class.getName());

	private final DrawingPane drawingPane;

	List<IShape> selectedShapes;

	public SelectionHandler(final DrawingPane pane) {
		selectedShapes = new ArrayList<>();
		drawingPane = pane;
		drawingPane.setOnMouseClicked(this);
	}

	@Override
	public void handle(final MouseEvent event) {
		if (event.isShiftDown()) {
			for (final IShape shape : drawingPane) {
				if (shape.isOn(event.getX(), event.getY())) {
					addOrRemoveSelectedShape(shape);
					break;
				}
			}
		} else {
			clearSelectedShapes();
			addClickedShape(event);
		}
	}

	private void addClickedShape(final MouseEvent event) {
		for (final IShape shape : drawingPane) {
			if (shape.isOn(event.getX(), event.getY())) {
				addShape(shape);
			}
		}
	}

	private void addOrRemoveSelectedShape(final IShape shape) {
		if (selectedShapes.contains(shape)) {
			removeShape(shape);
		} else {
			addShape(shape);
		}
	}

	private void addShape(final IShape shape) {
		selectedShapes.add(shape);
		shape.setSelected(true);
	}

	private void removeShape(final IShape shape) {
		selectedShapes.remove(shape);
		shape.setSelected(false);
	}

	private void clearSelectedShapes() {
		for (final IShape shape : drawingPane) {
			removeShape(shape);
		}
	}

	public List<IShape> getSelectedShapes() {
		return selectedShapes;
	}
}
