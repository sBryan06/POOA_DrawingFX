package drawing.handlers;

import java.util.List;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.Event;
import javafx.event.EventHandler;

public class UngroupButtonHandler implements EventHandler<Event> {

	private final DrawingPane drawingPane;

	public UngroupButtonHandler(final DrawingPane dp) {
		drawingPane = dp;
	}

	@Override
	public void handle(final Event event) {
		final List<IShape> selectedShapes = drawingPane.getSelection();

		for (final IShape iShape : selectedShapes) {
			if (Group.class.isInstance(iShape)) {
				final Group g = (Group) iShape;

				drawingPane.removeShape(iShape);

				for (final IShape shape : g.getShapes()) {
					drawingPane.addShape(shape);
				}
			}
		}
	}

}
