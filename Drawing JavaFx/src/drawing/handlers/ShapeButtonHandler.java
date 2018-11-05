package drawing.handlers;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2017.
 */
public abstract class ShapeButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;
	protected double originX;
	protected double originY;
	protected double destinationX;
	protected double destinationY;

	protected IShape shape;

	public ShapeButtonHandler(final DrawingPane drawingPane) {
		this.drawingPane = drawingPane;
	}

	protected abstract IShape createShape();

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
