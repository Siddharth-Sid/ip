package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.UI;

public abstract class AddCommand extends Command{

    public AddCommand(CommandTypes type, String taskDetails) {
        super(type, taskDetails);
    }

    /**
     * Method to check the type of the Command and distribute to the specific type of Command Handler.
     *
     * @param ui The Object to render the UI
     * @param tasks The Object to contain the List of the Tasks
     * @param storage The Object to save the List of the Tasks
     * @throws DukeException An Exception class to be thrown if the command taskDetails is not valid
     */
    @Override
    public abstract void execute(UI ui, TaskList tasks, Storage storage) throws DukeException;

    @Override
    public abstract boolean isExit();
}