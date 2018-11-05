package drawing.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import drawing.Observable;
import drawing.Observer;
import drawing.handlers.MouseMoveHandler;
import drawing.handlers.SelectionHandler;
import drawing.shapes.IShape;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape>, Observable, Observer {

	private final List<Observer> observers;

	private final MouseMoveHandler mouseMoveHandler;

	private final ArrayList<IShape> shapes;

	private final SelectionHandler selectionHandler;

	public DrawingPane() {
		clipChildren();
		shapes = new ArrayList<>();
		observers = new ArrayList<>();
		mouseMoveHandler = new MouseMoveHandler(this);
		selectionHandler = new SelectionHandler(this);

		selectionHandler.addObserver(this);
	}

	/**
	 * Clips the children of this {@link Region} to its current size. This requires
	 * attaching a change listener to the region’s layout bounds, as JavaFX does not
	 * currently provide any built-in way to clip children.
	 */
	void clipChildren() {
		final Rectangle outputClip = new Rectangle();
		this.setClip(outputClip);

		this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
			outputClip.setWidth(newValue.getWidth());
			outputClip.setHeight(newValue.getHeight());
		});
	}

	public void addShape(final IShape shape) {
		shapes.add(shape);
//		this.getChildren().add(shape);
		shape.addShapeToPane(this);
		this.notifyObservers();
	}

	public void removeShape(final IShape shape) {
		shapes.remove(shape);
		shape.removeShapeFromPane(this);
		this.notifyObservers();
	}

//	public ArrayList<Shape> getShapes() {
//		return shapes;
//	}
	@Override
	public Iterator<IShape> iterator() {
		return shapes.iterator();
	}

	public void clear() {
//		this.getChildren().removeAll(shapes);
		for (final IShape shape : shapes) {
			shape.removeShapeFromPane(this);
		}
		shapes.clear();
		this.notifyObservers();
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

	public int getNbShapes() {
		return shapes.size();
	}

	public List<IShape> getSelection() {
		return selectionHandler.getSelectedShapes();
	}

	@Override
	public void update() {
		notifyObservers();
	}

	public ArrayList<IShape> getShapes() {
		return shapes;
	}

	public void clearSelectedShape() {
		selectionHandler.clearSelectedShapes();
	}
}
