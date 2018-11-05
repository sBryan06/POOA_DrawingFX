package drawing.ui;

import drawing.handlers.ClearButtonHandler;
import drawing.handlers.EllipseButtonHandler;
import drawing.handlers.RectangleButtonHandler;
import drawing.handlers.SupprimerButtonHandler;
import drawing.handlers.TriangleButtonHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox {

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
		clearButton = new Button("Clear");
//		clearButton.setOnAction(event -> drawingPane.clear());
		clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(drawingPane));
		rectangleButton = new Button("Rectangle");
		rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
		circleButton = new Button("Circle");
		circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
		triangleButton = new Button("Triangle");
		triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
		supprimerButton = new Button("Supprimer");
		supprimerButton.addEventFilter(ActionEvent.ACTION, new SupprimerButtonHandler(drawingPane));
		getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, supprimerButton);
	}
}
