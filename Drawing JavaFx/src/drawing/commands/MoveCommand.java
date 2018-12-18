package drawing.commands;

import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class MoveCommand implements ICommand {
	public DrawingPane drawingPane;
	public List<IShape> shapes;
	public double offsetX;
	public double offsetY;

	public MoveCommand(final DrawingPane dp, final List<IShape> selectedShapes, final double offsetX,
			final double offsetY) {
		drawingPane = dp;
		shapes = selectedShapes;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}

	@Override
	public void execute() {
		shapes.forEach(shape -> shape.offset(offsetX, offsetY));
	}

	@Override
	public void undo() {
		shapes.forEach(shape -> shape.offset(-offsetX, -offsetY));
	}

}
