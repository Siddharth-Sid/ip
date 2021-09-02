package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.UI;
import duke.task.DeadlineTask;

import java.time.format.DateTimeParseException;

public class DeadlineCommand extends AddCommand {
    public DeadlineCommand(CommandTypes type, String taskDetails) {
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
        if ((taskDetails == null) || !(taskDetails.contains(" /by "))) {
            throw new DukeException("Incorrect Format of the Deadline Command!!, Correct Format --> " +
                    "deadline <Description> /by <dd/MM/yyyy HHmm>");
        } else {
            String[] values = taskDetails.split(" /by ", 2);
            try {
                DeadlineTask deadline = new DeadlineTask(values[0], values[1]);
                tasks.addTask(deadline);
                ui.addCommandUi(deadline, tasks.getTaskListLength());
            } catch (DateTimeParseException e) {
                throw new DukeException("Incorrect Format of the Deadline Command!!, Correct Format --> " +
                        "deadline <Description> /by <dd/MM/yyyy HHmm>");
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}