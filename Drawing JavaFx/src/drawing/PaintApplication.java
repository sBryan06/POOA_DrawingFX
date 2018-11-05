package drawing;

import drawing.ui.DrawingPane;
import drawing.ui.StatutBar;
import drawing.ui.ToolBar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
	private ToolBar toolbar;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		root = new BorderPane();
		scene = new Scene(root, WIDTH, HEIGHT);

		root.getStylesheets().add(PaintApplication.class.getResource("./css/Paint.css").toExternalForm());

		drawingPane = new DrawingPane();
		drawingPane.getStyleClass().add("drawingPane");
		root.setCenter(drawingPane);

		toolbar = new ToolBar(drawingPane);
		toolbar.setPadding(new Insets(5));
		toolbar.setSpacing(5.0);
		toolbar.getStyleClass().add("toolbar");
		root.setTop(toolbar);

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
