package drawing.enums;

public enum ButtonEnum {
	CLEAR("Clear", "clear.png"), RECTANGLE("Rectangle", "rectangle.png"), CIRCLE("Circle", "circle.png"),
	TRIANGLE("Triangle", "triangle.png"), DELETE("Delete", "delete.png"), GROUP("Group", "group.png"),
	UNGROUP("Ungroup", "ungroup.png"), UNDO("Undo", "undo.png"), REDO("Redo", "redo.png");

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
