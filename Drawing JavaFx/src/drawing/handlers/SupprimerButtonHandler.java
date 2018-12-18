package drawing.handlers;

import drawing.commands.DeleteCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SupprimerButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	private final ICommand command;

	public SupprimerButtonHandler(final DrawingPane d) {
		drawingPane = d;
		command = new DeleteCommand(drawingPane);
	}

	@Override
	public void handle(final Event event) {
//		for (final IShape iShape : drawingPane.getSelection()) {
//			drawingPane.removeShape(iShape);
//		}
//
//		drawingPane.clearSelectedShape();
//		command.execute();
		drawingPane.getCommandHistory().exec(command);
	}
}
