package drawing.ui;

import drawing.enums.ButtonEnum;
import drawing.factory.ButtonFactory;
import drawing.factory.ButtonFactory.StyleButtonEnum;
import drawing.handlers.ClearButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.GroupButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.SupprimerButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import drawing.handlers.UngroupButtonHandler;
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
	private Button groupButton;
	private Button ungroupButton;

	private final StyleButtonEnum styleButton = StyleButtonEnum.TEXT_ONLY;

	public ToolBar(final DrawingPane d) {
		drawingPane = d;
		init();
	}

	public void init() {
		clearButton = buttonFactory.createButton(ButtonEnum.CLEAR, styleButton);
		clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(drawingPane));

		rectangleButton = buttonFactory.createButton(ButtonEnum.RECTANGLE, styleButton);
		rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));

		circleButton = buttonFactory.createButton(ButtonEnum.CIRCLE, styleButton);
		circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));

		triangleButton = buttonFactory.createButton(ButtonEnum.TRIANGLE, styleButton);
		triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));

		supprimerButton = buttonFactory.createButton(ButtonEnum.DELETE, styleButton);
		supprimerButton.addEventFilter(ActionEvent.ACTION, new SupprimerButtonHandler(drawingPane));

		groupButton = buttonFactory.createButton(ButtonEnum.GROUP, styleButton);
		groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(drawingPane));

		ungroupButton = buttonFactory.createButton(ButtonEnum.UNGROUP, styleButton);
		ungroupButton.addEventFilter(ActionEvent.ACTION, new UngroupButtonHandler(drawingPane));

		getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, supprimerButton, groupButton,
				ungroupButton);
	}
}
