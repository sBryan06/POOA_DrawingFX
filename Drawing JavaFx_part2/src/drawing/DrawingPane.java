package drawing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<Shape>, Observable {

	private final List<Observer> observers;

	private final MouseMoveHandler mouseMoveHandler;

	private final ArrayList<Shape> shapes;

	public DrawingPane() {
		clipChildren();
		shapes = new ArrayList<>();
		observers = new ArrayList<>();
		mouseMoveHandler = new MouseMoveHandler(this);
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

	public void addShape(final Shape shape) {
		shapes.add(shape);
		this.getChildren().add(shape);
		this.notifyObservers();
	}

//	public ArrayList<Shape> getShapes() {
//		return shapes;
//	}
	@Override
	public Iterator<Shape> iterator() {
		return shapes.iterator();
	}

	public void clear() {
		this.getChildren().removeAll(shapes);
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
}
