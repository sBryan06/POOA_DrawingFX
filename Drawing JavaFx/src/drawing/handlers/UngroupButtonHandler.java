package drawing.handlers;

import drawing.commands.ICommand;
import drawing.commands.UngroupCommand;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class UngroupButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	private final ICommand command;

	public UngroupButtonHandler(final DrawingPane dp) {
		drawingPane = dp;
		command = new UngroupCommand(drawingPane);
	}

	@Override
	public void handle(final Event event) {
//		final List<IShape> selectedShapes = drawingPane.getSelection();
//
//		for (final IShape iShape : selectedShapes) {
//			if (Group.class.isInstance(iShape)) {
//				final Group g = (Group) iShape;
//
//				drawingPane.removeShape(iShape);
//
//				for (final IShape shape : g.getShapes()) {
//					drawingPane.addShape(shape);
//				}
//			}
//		}
//		command.execute();
		drawingPane.getCommandHistory().exec(command);
	}

}
