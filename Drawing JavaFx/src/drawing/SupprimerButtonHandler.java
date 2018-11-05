package drawing;

import javafx.event.Event;
import javafx.event.EventHandler;

public class SupprimerButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	public SupprimerButtonHandler(final DrawingPane d) {
		drawingPane = d;
	}

	@Override
	public void handle(final Event event) {

	}
}
