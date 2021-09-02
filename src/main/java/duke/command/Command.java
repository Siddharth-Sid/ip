package duke.command;
import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.UI;

/**
 * Class to abstract the type and execution of a command
 */
public abstract class Command {
    protected final CommandTypes typeOfCommand;
    protected final String taskDetails;

    /**
     * Constructor for the Class Command
     *
     * @param type The type of Command
     * @param taskDetails The String describing the various attributes for the command
     */
    public Command(CommandTypes type, String taskDetails) {
        this.typeOfCommand = CommandTypes.COMMAND;
        this.taskDetails = taskDetails;
    }

    /**
     * Method to check the type of the Command and distribute to the specific type of Command Handler.
     *
     * @param ui The Object to render the UI
     * @param tasks The Object to contain the List of the Tasks
     * @param storage The Object to save the List of the Tasks
     * @throws DukeException An Exception class to be thrown if the command taskDetails is not valid
     */
    public abstract void execute(UI ui, TaskList tasks, Storage storage) throws DukeException;

    /**
     * Method to check if the Command prompts an exit
     *
     * @return Return boolean if the program should exit
     */
    public abstract boolean isExit();
}