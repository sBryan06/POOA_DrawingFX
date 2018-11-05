package drawing.enums;

public enum ButtonEnum {
	CLEAR("Clear", "clear.png"), RECTANGLE("Rectangle", "rectangle.png"), CIRCLE("Circle", "circle.png"),
	TRIANGLE("Triangle", "triangle.png"), DELETE("Delete", "delete.png");

	private String label;
	private String fileName;

	private ButtonEnum(final String label, final String file) {
		this.label = label;
		fileName = file;
	}

	public String getLabel() {
		return label;
	}

	public String getFileName() {
		return fileName;
	}
}
