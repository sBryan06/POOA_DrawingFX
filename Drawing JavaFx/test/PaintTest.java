import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import drawing.PaintApplication;
import drawing.shapes.Group;
import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class PaintTest extends ApplicationTest {

	PaintApplication app;

	@Override
	public void start(final Stage stage) {
		try {
			app = new PaintApplication();
			app.start(stage);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void should_draw_circle_programmatically() {
		interact(() -> {
			app.getDrawingPane().addShape(new ShapeAdapter(new Ellipse(20, 20, 30, 30)));
		});
//        Iterator it = app.getDrawingPane().getShapes().iterator();
		final Iterator it = app.getDrawingPane().iterator();
//		assertTrue(it.next() instanceof Ellipse);
		assertTrue(it.next() instanceof IShape);
		assertFalse(it.hasNext());
	}

	@Test
	public void should_draw_circle() {
		// given:
		clickOn("Circle");
		moveBy(60, 60);

		// when:
		drag().dropBy(30, 30);
		// press(MouseButton.PRIMARY); moveBy(30,30); release(MouseButton.PRIMARY);

		// then:
//		final Iterator it = app.getDrawingPane().getShapes().iterator();
		final Iterator it = app.getDrawingPane().iterator();
//		assertTrue(it.next() instanceof Ellipse);
		assertTrue(it.next() instanceof IShape);
		assertFalse(it.hasNext());
	}

	@Test
	public void should_draw_rectangle() {
		// given:
		clickOn("Rectangle");
		moveBy(0, 60);

		// when:
		drag().dropBy(70, 40);

		// then:
//        Iterator it = app.getDrawingPane().getShapes().iterator();
		final Iterator it = app.getDrawingPane().iterator();
//		assertTrue(it.next() instanceof Rectangle);
		assertTrue(it.next() instanceof IShape);
		assertFalse(it.hasNext());
	}

	@Test
	public void should_clear() {
		// given:
		clickOn("Rectangle");
		moveBy(30, 60).drag().dropBy(70, 40);
		clickOn("Circle");
		moveBy(-30, 160).drag().dropBy(70, 40);

		// when:
		clickOn("Clear");

		// then:
//        assertFalse(app.getDrawingPane().getShapes().iterator().hasNext());
		assertFalse(app.getDrawingPane().iterator().hasNext());
	}

	@Test
	public void should_draw_triangle() {
		// given:
		clickOn("Triangle");
		moveBy(50, 50);

		// when:
		drag().dropBy(80, 80);

		// then:
//		final Iterator it = app.getDrawingPane().getShapes().iterator();
		final Iterator it = app.getDrawingPane().iterator();
//		assertTrue(it.next() instanceof Polygon);
		assertTrue(it.next() instanceof IShape);
		assertFalse(it.hasNext());
	}

	@Test
	public void check_count_shape_statutbar() {
		assertTrue(app.getStatutBar().getCountShape() == 0);

		clickOn("Triangle");
		moveBy(50, 50);
		drag().dropBy(80, 80);

		assertTrue(app.getStatutBar().getCountShape() == 1);

		clickOn("Rectangle");
		moveBy(40, 40);
		drag().dropBy(90, 90);

		assertTrue(app.getStatutBar().getCountShape() == 2);
	}

	@Test
	public void check_count_selected_shape_statutbar() {
		assertTrue(app.getStatutBar().getCountSelectedShape() == 0);

		clickOn("Triangle");
		moveBy(50, 50);
		drag().dropBy(80, 80);

		clickOn("Rectangle");
		moveBy(40, 40);
		drag().dropBy(90, 90);

		press(KeyCode.SHIFT);
		for (int i = 0; i < app.getDrawingPane().getShapes().size() - 1; i++) {
			final IShape shape = app.getDrawingPane().getShapes().get(i);
			clickOn(((ShapeAdapter) shape).getShape());
		}
		assertTrue(app.getStatutBar().getCountSelectedShape() == 2);
	}

	@Test
	public void check_delete_selected_shape() {
		assertTrue(app.getDrawingPane().getSelection().size() == 0);

		clickOn("Triangle");
		moveBy(50, 50);
		drag().dropBy(80, 80);

		clickOn("Rectangle");
		moveBy(40, 40);
		drag().dropBy(90, 90);

		clickOn("Delete");

		assertTrue(app.getDrawingPane().getNbShapes() == 1);
	}

	@Test
	public void check_group_and_ungroup_shapes() {
		clickOn("Rectangle");
		moveBy(30, 60).drag().dropBy(70, 40);
		clickOn("Circle");
		moveBy(-30, 160).drag().dropBy(70, 40);
		clickOn("Triangle");
		moveBy(50, 50).drag().dropBy(80, 80);

		press(KeyCode.SHIFT).clickOn(app.getDrawingPane().getChildren().get(0));
		clickOn(app.getDrawingPane().getChildren().get(1));
//		clickOn(app.getDrawingPane().getChildren().get(2));

		release(KeyCode.SHIFT);

		assertTrue(app.getDrawingPane().getShapes().size() == 3);

		clickOn("Group");

		assertTrue(app.getDrawingPane().getShapes().size() == 1);

		final Iterator it = app.getDrawingPane().iterator();
		assertTrue(Group.class.isInstance(it.next()));
		assertFalse(it.hasNext());

		clickOn(app.getDrawingPane().getChildren().get(0));
		clickOn("Ungroup");

		final Iterator it2 = app.getDrawingPane().iterator();
		assertTrue(ShapeAdapter.class.isInstance(it2.next()));
	}
}