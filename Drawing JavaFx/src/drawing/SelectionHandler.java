package drawing;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectionHandler implements EventHandler<MouseEvent>, Observable {

	Logger logger = Logger.getLogger(SelectionHandler.class.getName());

	private final DrawingPane drawingPane;

	List<IShape> selectedShapes;

	List<Observer> observers;

	public SelectionHandler(final DrawingPane pane) {
		selectedShapes = new ArrayList<>();
		drawingPane = pane;
		drawingPane.setOnMouseClicked(this);

		observers = new ArrayList<>();
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
		this.notifyObservers();
	}

	private void removeShape(final IShape shape) {
		selectedShapes.remove(shape);
		shape.setSelected(false);
		this.notifyObservers();
	}

	public void clearSelectedShapes() {
//		for (final IShape shape : drawingPane) {
//			removeShape(shape);
//		}
		for (final IShape shape : selectedShapes) {
			shape.setSelected(false);
		}
		selectedShapes = new ArrayList<>();
		notifyObservers();
	}

	public List<IShape> getSelectedShapes() {
		return selectedShapes;
	}

	@Override
	public void addObserver(final Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(final Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (final Observer observer : observers) {
			observer.update();
		}
	}
}
