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
//		setShapesBeforeClearing(drawingPane.getShapes());
		shapesBeforeClearing.addAll(drawingPane.getShapes());

		drawingPane.clear();
		drawingPane.clearSelectedShape();
	}

	@Override
	public void undo() {
//		drawingPane.getShapes().addAll(shapesBeforeClearing);
		shapesBeforeClearing.forEach(shape -> drawingPane.addShape(shape));
	}

//	public void setShapesBeforeClearing(final List<IShape> shapesBeforeClearing) {
//		this.shapesBeforeClearing = shapesBeforeClearing;
//	}
}
