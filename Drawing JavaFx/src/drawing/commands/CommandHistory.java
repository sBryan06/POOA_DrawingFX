package drawing.commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {

	private final Deque<ICommand> undoCommands;
	private final Deque<ICommand> redoCommands;

	public CommandHistory() {
		undoCommands = new ArrayDeque<>();
		redoCommands = new ArrayDeque<>();
	}

	public void exec(final ICommand command) {
		undoCommands.push(command);
		command.execute();
	}

	public void undo() {
		if (!undoCommands.isEmpty()) {
			final ICommand last = undoCommands.peek();
			last.undo();
			redoCommands.push(last);
			undoCommands.pop();
		}
	}

	public void redo() {
		if (!redoCommands.isEmpty()) {
			final ICommand last = redoCommands.peek();
			last.redo();
			undoCommands.push(last);
			redoCommands.pop();
		}
	}
}
