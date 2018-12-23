package drawing.commands;

import java.util.List;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class GroupCommand implements ICommand {

	private final DrawingPane drawingPane;
	private Group savedGroup;

	public GroupCommand(final DrawingPane dp) {
		drawingPane = dp;
	}

	@Override
	public void execute() {
		final List<IShape> selectedShape = drawingPane.getSelection();
		final Group g = new Group();
		g.setShapes(selectedShape);

		// save for undo
		savedGroup = g;

		groupShapes();
	}

	@Override
	public void undo() {
		final List<IShape> shapesOfGroup = savedGroup.getShapes();

		drawingPane.removeShape(savedGroup);

		shapesOfGroup.forEach(shape -> drawingPane.addShape(shape));
	}

	@Override
	public void redo() {
		groupShapes();
	}

	private void groupShapes() {
		savedGroup.getShapes().forEach(shape -> drawingPane.removeShape(shape));
		drawingPane.addShape(savedGroup);
	}
}
