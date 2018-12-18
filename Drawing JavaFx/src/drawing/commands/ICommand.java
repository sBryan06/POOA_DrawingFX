package drawing.commands;

public interface ICommand {
	/**
	 * Permet d'executer une action
	 */
	public void execute();

	/**
	 * Permet d'annuler la dernier action
	 */
	public void undo();
}
