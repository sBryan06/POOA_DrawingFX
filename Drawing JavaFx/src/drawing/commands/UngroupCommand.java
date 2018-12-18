package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class UngroupCommand implements ICommand {

	private final DrawingPane drawingPane;
	private final List<Group> savedGroups;

	public UngroupCommand(final DrawingPane dp) {
		drawingPane = dp;
		savedGroups = new ArrayList<>();
	}

	@Override
	public void execute() {
		final List<IShape> selectedShapes = drawingPane.getSelection();

		for (final IShape iShape : selectedShapes) {
			if (Group.class.isInstance(iShape)) {
				final Group g = (Group) iShape;

				// save for undo
				savedGroups.add(g);

				drawingPane.removeShape(iShape);

				for (final IShape shape : g.getShapes()) {
					drawingPane.addShape(shape);
				}
			}
		}
	}

	@Override
	public void undo() {
		for (final Group group : savedGroups) {
			group.getShapes().forEach(shape -> drawingPane.removeShape(shape));
			drawingPane.addShape(group);
		}
	}

}
