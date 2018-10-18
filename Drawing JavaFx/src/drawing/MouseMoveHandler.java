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
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
			if (drawingPane.getSelection().isEmpty())
				return;

			final double offsetX = event.getSceneX() - orgSceneX;
			final double offsetY = event.getSceneY() - orgSceneY;

			for (final IShape shape : drawingPane.getSelection()) {
				shape.offset(offsetX, offsetY);
			}

			orgSceneX = event.getSceneX();
			orgSceneY = event.getSceneY();
		}

//		if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
//			if (selectedShape == null)
//				return;
//
//			selectedShape.setSelected(false);
//			selectedShape = null;
//		}
	}
}
