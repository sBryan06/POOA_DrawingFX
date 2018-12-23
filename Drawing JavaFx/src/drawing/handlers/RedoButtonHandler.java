package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class RedoButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	public RedoButtonHandler(final DrawingPane dp) {
		drawingPane = dp;
	}

	@Override
	public void handle(final Event event) {
		drawingPane.getCommandHistory().redo();
	}

}
