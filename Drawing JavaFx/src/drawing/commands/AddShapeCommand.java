package drawing.commands;

import java.util.logging.Logger;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class AddShapeCommand implements ICommand {
	Logger logger = Logger.getLogger(AddShapeCommand.class.getName());

	private final DrawingPane drawingPane;
	private final IShape shape;

	public AddShapeCommand(final DrawingPane dp, final IShape s) {
		drawingPane = dp;
		shape = s;
	}

	@Override
	public void execute() {
		logger.info("AddShapeCommand::execute");
		drawingPane.addShape(shape);
	}

	@Override
	public void undo() {
		drawingPane.removeShape(shape);
	}

}
