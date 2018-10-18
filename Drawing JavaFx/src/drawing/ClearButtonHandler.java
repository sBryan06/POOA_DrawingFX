package drawing;

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
	}

}
