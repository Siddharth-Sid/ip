package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.UI;

public class UnknownCommand extends Command {
    public UnknownCommand(CommandTypes type, String taskDetails) {
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
    public void execute(UI ui, TaskList tasks, Storage storage) throws DukeException {
        throw new DukeException("OOPS! I'm sorry, but I don't know that command");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}