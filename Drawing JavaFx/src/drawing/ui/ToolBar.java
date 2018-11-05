package drawing.ui;

import drawing.enums.ButtonEnum;
import drawing.factory.ButtonFactory;
import drawing.factory.ButtonFactory.StyleButtonEnum;
import drawing.handlers.ClearButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.SupprimerButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox {
	ButtonFactory buttonFactory = new ButtonFactory();

	private final DrawingPane drawingPane;

	private Button clearButton;
	private Button rectangleButton;
	private Button circleButton;
	private Button triangleButton;
	private Button supprimerButton;

	public ToolBar(final DrawingPane d) {
		drawingPane = d;
		init();
	}

	public void init() {
		clearButton = buttonFactory.createButton(ButtonEnum.CLEAR, StyleButtonEnum.ICON_ONLY);
		clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(drawingPane));

		rectangleButton = buttonFactory.createButton(ButtonEnum.RECTANGLE, StyleButtonEnum.ICON_ONLY);
		rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));

		circleButton = buttonFactory.createButton(ButtonEnum.CIRCLE, StyleButtonEnum.ICON_ONLY);
		circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));

		triangleButton = buttonFactory.createButton(ButtonEnum.TRIANGLE, StyleButtonEnum.ICON_ONLY);
		triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));

		supprimerButton = buttonFactory.createButton(ButtonEnum.DELETE, StyleButtonEnum.ICON_ONLY);
		supprimerButton.addEventFilter(ActionEvent.ACTION, new SupprimerButtonHandler(drawingPane));

		getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, supprimerButton);
	}
}
