package drawing.handlers;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SupprimerButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	public SupprimerButtonHandler(final DrawingPane d) {
		drawingPane = d;
	}

	@Override
	public void handle(final Event event) {
		for (final IShape iShape : drawingPane.getSelection()) {
			drawingPane.removeShape(iShape);
		}

		drawingPane.clearSelectedShape();
	}
}