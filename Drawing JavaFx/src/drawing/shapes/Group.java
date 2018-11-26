package drawing.shapes;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;

public class Group implements IShape {

	private List<IShape> shapes;
	private boolean selected;

	public Group() {
		shapes = new ArrayList<>();
	}

	@Override
	public void addShapeToPane(final Pane pane) {
		for (final IShape shape : shapes) {
			shape.addShapeToPane(pane);
		}
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(final boolean selected) {
		this.selected = selected;

		for (final IShape shape : shapes) {
			shape.setSelected(selected);
		}
	}

	@Override
	public boolean isOn(final double x, final double y) {
		for (final IShape shape : shapes) {
			if (shape.isOn(x, y))
				return true;
		}
		return false;
	}

	@Override
	public void offset(final double x, final double y) {
		for (final IShape shape : shapes) {
			shape.offset(x, y);
		}
	}

	@Override
	public void removeShapeFromPane(final Pane pane) {
		for (final IShape shape : shapes) {
			shape.removeShapeFromPane(pane);
		}
	}

	public List<IShape> getShapes() {
		return shapes;
	}

	public void setShapes(final List<IShape> shapes) {
		this.shapes = shapes;
	}
}
