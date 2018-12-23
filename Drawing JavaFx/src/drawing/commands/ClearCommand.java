package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ClearCommand implements ICommand {

	private final DrawingPane drawingPane;
	private final List<IShape> shapesBeforeClearing;

	public ClearCommand(final DrawingPane dp) {
		shapesBeforeClearing = new ArrayList<>();
		drawingPane = dp;
	}

	@Override
	public void execute() {
		shapesBeforeClearing.addAll(drawingPane.getShapes());

		clear();
	}

	private void clear() {
		drawingPane.clear();
		drawingPane.clearSelectedShape();
	}

	@Override
	public void undo() {
		shapesBeforeClearing.forEach(shape -> drawingPane.addShape(shape));
	}

	@Override
	public void redo() {
		clear();
	}

}
