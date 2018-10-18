package drawing;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class PaintApplication extends Application {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Scene scene;
	private BorderPane root;
	private DrawingPane drawingPane;
	private StatutBar statutBar;

	private Button clearButton;
	private Button rectangleButton;
	private Button circleButton;
	private Button triangleButton;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		root = new BorderPane();
		scene = new Scene(root, WIDTH, HEIGHT);

		root.getStylesheets().add(PaintApplication.class.getResource("./Paint.css").toExternalForm());

		drawingPane = new DrawingPane();
		drawingPane.getStyleClass().add("drawingPane");
		root.setCenter(drawingPane);

		final HBox hBox = new HBox();
		clearButton = new Button("Clear");
//		clearButton.setOnAction(event -> drawingPane.clear());
		clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(drawingPane));
		rectangleButton = new Button("Rectangle");
		rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
		circleButton = new Button("Circle");
		circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
		triangleButton = new Button("Triangle");
		triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
		hBox.getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton);
		hBox.setPadding(new Insets(5));
		hBox.setSpacing(5.0);
		hBox.getStyleClass().add("toolbar");
		root.setTop(hBox);

		statutBar = new StatutBar(drawingPane);
		statutBar.getChildren().add(statutBar.getLabel());
		statutBar.setPadding(new Insets(5));
		statutBar.setSpacing(5.0);
		statutBar.getStyleClass().add("statutbar");
		root.setBottom(statutBar);

		primaryStage.setTitle("Drawing");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public DrawingPane getDrawingPane() {
		return drawingPane;
	}

	public static void main(final String[] args) {
		launch(args);
	}

	public StatutBar getStatutBar() {
		return statutBar;
	}

}
