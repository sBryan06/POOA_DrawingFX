package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class DeleteCommand implements ICommand {

	private final DrawingPane drawingPane;
	private List<IShape> savedShapes;

	public DeleteCommand(final DrawingPane dp) {
		drawingPane = dp;
		savedShapes = new ArrayList<>();
	}

	@Override
	public void execute() {
		System.out.println("deleteCommand execute");
		savedShapes = drawingPane.getSelection();
		removeShapes();

		drawingPane.clearSelectedShape();
	}

	@Override
	public void undo() {
		savedShapes.forEach(shape -> drawingPane.addShape(shape));
	}

	@Override
	public void redo() {
		removeShapes();
	}

	private void removeShapes() {
//		for (final IShape iShape : drawingPane.getSelection()) {
//			drawingPane.removeShape(iShape);
//		}
		savedShapes.forEach(shape -> drawingPane.removeShape(shape));
	}
}
