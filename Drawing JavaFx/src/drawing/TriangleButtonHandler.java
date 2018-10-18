package drawing;

import javafx.scene.shape.Polygon;

public class TriangleButtonHandler extends ShapeButtonHandler {

	public TriangleButtonHandler(final DrawingPane drawingPane) {
		super(drawingPane);
	}

	@Override
	protected IShape createShape() {
		final double x = Math.min(originX, destinationX);
		final double y = Math.min(originY, destinationY);
		final double width = Math.abs(destinationX - originX);
		final double height = Math.abs(destinationY - originY);
		final Polygon triangle = new Polygon();
		triangle.getPoints().addAll(new Double[] { x, y + height, (x + (width / 2)), y, (x + width), (y + height) });
		triangle.getStyleClass().add("triangle");
//        return triangle;
		return new ShapeAdapter(triangle);
	}

}
