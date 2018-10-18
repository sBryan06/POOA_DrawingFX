package drawing;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

	private final DrawingPane drawingPane;

	private double orgSceneX;
	private double orgSceneY;
	private double orgTranslateX;
	private double orgTranslateY;

	private Shape selectedShape;

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
			for (final Shape shape : drawingPane) {
				if (shape.getBoundsInParent().contains(event.getX(), event.getY())) {
					selectedShape = shape;
					break;
				}
			}

			orgTranslateX = selectedShape == null ? 0 : selectedShape.getTranslateX();
			orgTranslateY = selectedShape == null ? 0 : selectedShape.getTranslateY();

		}

		if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
			if (selectedShape == null)
				return;

			final double offsetX = event.getSceneX() - orgSceneX;
			final double offsetY = event.getSceneY() - orgSceneY;
			final double newTranslateX = orgTranslateX + offsetX;
			final double newTranslateY = orgTranslateY + offsetY;

			selectedShape.setTranslateX(newTranslateX);
			selectedShape.setTranslateY(newTranslateY);
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
			selectedShape = null;
		}
	}
}
