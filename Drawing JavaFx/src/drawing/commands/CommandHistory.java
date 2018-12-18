package drawing.commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
	private final Deque<ICommand> history;

	public CommandHistory() {
		history = new ArrayDeque<>();
	}

	public void exec(final ICommand command) {
		history.push(command);
		command.execute();
	}

	public void undo() {
		if (!history.isEmpty()) {
			final ICommand last = history.peek();
			last.undo();
			history.pop();
		}
	}
}
