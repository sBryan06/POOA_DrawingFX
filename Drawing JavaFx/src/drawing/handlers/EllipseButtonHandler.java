package drawing.handlers;

import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import drawing.ui.DrawingPane;
import javafx.scene.shape.Ellipse;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class EllipseButtonHandler extends ShapeButtonHandler {

	public EllipseButtonHandler(final DrawingPane drawingPane) {
		super(drawingPane);
	}

	@Override
	protected IShape createShape() {
		final double x = Math.min(originX, destinationX);
		final double y = Math.min(originY, destinationY);
		final double width = Math.abs(destinationX - originX);
		final double height = Math.abs(destinationY - originY);
		final Ellipse ellipse = new Ellipse(x + width / 2, y + height / 2, width / 2, height / 2);
		ellipse.getStyleClass().add("ellipse");
		return new ShapeAdapter(ellipse);
	}
}
