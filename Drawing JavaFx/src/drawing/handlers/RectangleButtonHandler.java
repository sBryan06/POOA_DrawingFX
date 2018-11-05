package drawing.handlers;

import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import drawing.ui.DrawingPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class RectangleButtonHandler extends ShapeButtonHandler {

	public RectangleButtonHandler(final DrawingPane drawingPane) {
		super(drawingPane);
	}

	@Override
	protected IShape createShape() {
		final double x = Math.min(originX, destinationX);
		final double y = Math.min(originY, destinationY);
		final double width = Math.abs(destinationX - originX);
		final double height = Math.abs(destinationY - originY);
		final Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.getStyleClass().add("rectangle");
//        return rectangle;
		return new ShapeAdapter(rectangle);
	}
}
