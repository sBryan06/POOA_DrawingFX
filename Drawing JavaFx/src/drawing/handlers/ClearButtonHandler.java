package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	private ICommand command;

	public ClearButtonHandler(final DrawingPane d) {
		drawingPane = d;
	}

	@Override
	public void handle(final Event event) {
//		drawingPane.clear();
//		drawingPane.clearSelectedShape();
//		command.execute();
		command = new ClearCommand(drawingPane);
		drawingPane.getCommandHistory().exec(command);
	}

}
