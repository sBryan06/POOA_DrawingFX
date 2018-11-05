package drawing.factory;

import drawing.enums.ButtonEnum;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonFactory {

	public enum StyleButtonEnum {
		TEXT_ONLY, ICON_ONLY
	}

	public Button createButton(final ButtonEnum btnEnum, final StyleButtonEnum mode) {
		final Button btn = new Button();

		if (mode == StyleButtonEnum.ICON_ONLY) {
			final Image image = new Image(getClass().getResourceAsStream("../res/" + btnEnum.getFileName()));
			final ImageView imageView = new ImageView(image);
			btn.setGraphic(imageView);
			btn.setPadding(Insets.EMPTY);
		} else {
			btn.setText(btnEnum.getLabel());
		}

		return btn;
	}
}
