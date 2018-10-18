package drawing;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

	private final DrawingPane drawingPane;

	private double orgSceneX;
	private double orgSceneY;

	private IShape selectedShape;

	public MouseMoveHandler(final DrawingPane drawingPane) {
		this.drawingPane = drawingPane;
		drawingPane.setOnMousePressed(this);
		drawingPane.setOnMouseDragged(this);
		drawingPane.setOnMouseReleased(this);
	}

	@Override
	public void handle(final MouseEvent event) {

		if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
			orgSceneX = event.getSceneX();
			orgSceneY = event.getSceneY();

//			for (final Shape shape : drawingPane.getShapes()) {
			for (final IShape shape : drawingPane) {
				if (shape.isOn(event.getX(), event.getY())) {
					selectedShape = shape;
					shape.setSelected(true);
					break;
				}
			}
//			orgTranslateX = selectedShape == null ? 0 : selectedShape.getTranslateX();
//			orgTranslateY = selectedShape == null ? 0 : selectedShape.getTranslateY();
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
			if (selectedShape == null)
				return;

			final double offsetX = event.getSceneX() - orgSceneX;
			final double offsetY = event.getSceneY() - orgSceneY;

//			final double offsetX = event.getSceneX() - orgSceneX;
//			final double offsetY = event.getSceneY() - orgSceneY;
//			final double newTranslateX = orgTranslateX + offsetX;
//			final double newTranslateY = orgTranslateY + offsetY;

//			selectedShape.setTranslateX(newTranslateX);
//			selectedShape.setTranslateY(newTranslateY);
//			selectedShape.offset(newTranslateX, newTranslateY);
			selectedShape.offset(offsetX, offsetY);

			orgSceneX = event.getSceneX();
			orgSceneY = event.getSceneY();
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
			if (selectedShape == null)
				return;

			selectedShape.setSelected(false);
			selectedShape = null;
		}
	}
}
