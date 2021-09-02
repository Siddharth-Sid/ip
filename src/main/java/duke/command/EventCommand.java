package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.UI;
import duke.task.EventTask;
import java.time.format.DateTimeParseException;

public class EventCommand extends AddCommand {
    public EventCommand(CommandTypes type, String taskDetails) {
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
        if ((taskDetails == null) || !(taskDetails.contains(" /at "))) {
            throw new DukeException("Incorrect Format of the Event Command!!, " +
                    "Correct Format --> event <Description> /at <dd/MM/yyyy HHmm>");
        } else {
            String[] values = taskDetails.split(" /at ", 2);
            try {
                EventTask event = new EventTask(values[0], values[1]);
                tasks.addTask(event);
                ui.addCommandUi(event, tasks.getTaskListLength());
            } catch (DateTimeParseException e) {
                throw new DukeException("Incorrect Format of the Event Command!!, " +
                        "Correct Format --> event <Description> /at <dd/MM/yyyy HHmm>");
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}