package drawing.handlers;

import java.util.logging.Level;
import java.util.logging.Logger;

import drawing.commands.ICommand;
import drawing.commands.MoveCommand;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

	Logger logger = Logger.getLogger(MouseMoveHandler.class.getName());

	private final DrawingPane drawingPane;
	private ICommand command;

	private double orgSceneX;
	private double orgSceneY;

	private double sommeOffsetX = 0;
	private double sommeOffsetY = 0;

	public MouseMoveHandler(final DrawingPane drawingPane) {
		this.drawingPane = drawingPane;
		drawingPane.setOnMousePressed(this);
		drawingPane.setOnMouseDragged(this);
		drawingPane.setOnMouseReleased(this);
	}

	@Override
	public void handle(final MouseEvent event) {
		if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
			logger.log(Level.INFO, "MouseMoveHandler#handle MOUSE_PRESSED");
			orgSceneX = event.getSceneX();
			orgSceneY = event.getSceneY();
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
			if (drawingPane.getSelection().isEmpty())
				return;

			final double offsetX = event.getSceneX() - orgSceneX;
			final double offsetY = event.getSceneY() - orgSceneY;

			sommeOffsetX += offsetX;
			sommeOffsetY += offsetY;

			// deplacement pour voir le move
			for (final IShape shape : drawingPane.getSelection()) {
				shape.offset(offsetX, offsetY);
			}

			orgSceneX = event.getSceneX();
			orgSceneY = event.getSceneY();
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
			if (sommeOffsetX > 0 && sommeOffsetY > 0) {
				drawingPane.getSelection().forEach(shape -> shape.offset(-sommeOffsetX, -sommeOffsetY));
				command = new MoveCommand(drawingPane, drawingPane.getSelection(), sommeOffsetX, sommeOffsetY);
				drawingPane.getCommandHistory().exec(command);
				sommeOffsetX = 0;
				sommeOffsetY = 0;
				drawingPane.clearSelectedShape();
			}
		}
	}
}
