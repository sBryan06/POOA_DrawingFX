package drawing.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {

	private final Shape shape;
	private boolean selected;

	public ShapeAdapter(final Shape p) {
		shape = p;
		selected = false;
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(final boolean selected) {
		this.selected = selected;

		if (selected) {
			shape.getStyleClass().add("selected");
		} else {
			shape.getStyleClass().remove("selected");
		}
	}

	@Override
	public boolean isOn(final double x, final double y) {
		return shape.getBoundsInParent().contains(x, y);
	}

	@Override
	public void offset(final double x, final double y) {
		shape.setTranslateX(shape.getTranslateX() + x);
		shape.setTranslateY(shape.getTranslateY() + y);
	}

	@Override
	public void addShapeToPane(final Pane pane) {
		pane.getChildren().add(shape);
	}

	@Override
	public void removeShapeFromPane(final Pane pane) {
		pane.getChildren().remove(shape);
	}

	public Shape getShape() {
		return shape;
	}
}
