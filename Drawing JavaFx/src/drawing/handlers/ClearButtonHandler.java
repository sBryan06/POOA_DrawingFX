package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	public ClearButtonHandler(final DrawingPane d) {
		drawingPane = d;
	}

	@Override
	public void handle(final Event event) {
		drawingPane.clear();
		drawingPane.clearSelectedShape();
	}

}
