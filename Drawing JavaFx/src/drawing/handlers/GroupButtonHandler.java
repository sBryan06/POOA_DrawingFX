package drawing.handlers;

import java.util.List;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.Event;

public class GroupButtonHandler implements javafx.event.EventHandler<Event> {

	private final DrawingPane drawingPane;

	public GroupButtonHandler(final DrawingPane dp) {
		drawingPane = dp;
	}

	@Override
	public void handle(final Event event) {
		final List<IShape> selectedShape = drawingPane.getSelection();
		final Group g = new Group();
		g.setShapes(selectedShape);

		for (final IShape iShape : selectedShape) {
			drawingPane.removeShape(iShape);
		}

		drawingPane.addShape(g);
	}

}
