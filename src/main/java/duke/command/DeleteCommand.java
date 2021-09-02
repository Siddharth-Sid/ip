package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.UI;

public class DeleteCommand extends Command {
    public DeleteCommand(CommandTypes type, String taskDetails) {
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
        try {
            int index = Integer.parseInt(taskDetails) - 1;
            if ((index >= 0) && (index < tasks.getTaskListLength())) {
                ui.deleteCommandUi(tasks.deleteTaskAtIndex(index));
            } else {
                int numberOfTasks = tasks.getTaskListLength();
                if (numberOfTasks == 0) {
                    throw new DukeException("Incorrect Index!! There are no Tasks in the Task List");
                } else {
                    throw new DukeException("Incorrect Index!! There are " + numberOfTasks + " tasks in the Task List");
                }
            }
        } catch (NumberFormatException e) {
            throw new DukeException("Incorrect Format of the Delete Command!!, Correct Format --> delete <index>");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}