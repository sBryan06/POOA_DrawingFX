import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import drawing.PaintApplication;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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
			app.getDrawingPane().addShape(new Ellipse(20, 20, 30, 30));
		});
//        Iterator it = app.getDrawingPane().getShapes().iterator();
		final Iterator it = app.getDrawingPane().iterator();
		assertTrue(it.next() instanceof Ellipse);
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
		assertTrue(it.next() instanceof Ellipse);
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
		assertTrue(it.next() instanceof Rectangle);
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
		assertTrue(it.next() instanceof Polygon);
		assertFalse(it.hasNext());
	}

	@Test
	public void check_statutbar() {
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
}