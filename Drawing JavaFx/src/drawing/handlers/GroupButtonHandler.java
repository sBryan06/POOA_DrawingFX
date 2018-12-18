package drawing.handlers;

import drawing.commands.GroupCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.Event;

public class GroupButtonHandler implements javafx.event.EventHandler<Event> {

	private final DrawingPane drawingPane;

	private final ICommand command;

	public GroupButtonHandler(final DrawingPane dp) {
		drawingPane = dp;
		command = new GroupCommand(drawingPane);
	}

	@Override
	public void handle(final Event event) {
//		final List<IShape> selectedShape = drawingPane.getSelection();
//		final Group g = new Group();
//		g.setShapes(selectedShape);
//
//		for (final IShape iShape : selectedShape) {
//			drawingPane.removeShape(iShape);
//		}
//
//		drawingPane.addShape(g);
//		command.execute();
		drawingPane.getCommandHistory().exec(command);
	}

}
