package drawing;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 * Created by lewandowski on 20/12/2017.
 */
public abstract class ShapeButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;
	protected double originX;
	protected double originY;
	protected double destinationX;
	protected double destinationY;

	protected Shape shape;

	public ShapeButtonHandler(final DrawingPane drawingPane) {
		this.drawingPane = drawingPane;
	}

	protected abstract Shape createShape();

	@Override
	public void handle(final Event event) {

		if (event instanceof ActionEvent) {
			drawingPane.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
		}

		if (event instanceof MouseEvent) {
			if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
				drawingPane.addEventHandler(MouseEvent.MOUSE_RELEASED, this);
				originX = ((MouseEvent) event).getX();
				originY = ((MouseEvent) event).getY();
			}

			if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
				destinationX = ((MouseEvent) event).getX();
				destinationY = ((MouseEvent) event).getY();
				shape = createShape();
				// drawingPane.addShape(shape);
//				drawingPane.getShapes().add(shape);
				drawingPane.addShape(shape);

				drawingPane.removeEventHandler(MouseEvent.MOUSE_PRESSED, this);
				drawingPane.removeEventHandler(MouseEvent.MOUSE_RELEASED, this);
			}
		}
	}

}
