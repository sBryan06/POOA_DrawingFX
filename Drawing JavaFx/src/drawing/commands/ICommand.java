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

	/**
	 * Permet de remettre de la derniere modif
	 */
	public void redo();
}
