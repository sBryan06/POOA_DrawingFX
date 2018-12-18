package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<Event> {
	private final DrawingPane drawingPane;

	public UndoButtonHandler(final DrawingPane dp) {
		drawingPane = dp;
	}

	@Override
	public void handle(final Event event) {
		drawingPane.getCommandHistory().undo();
	}
}
