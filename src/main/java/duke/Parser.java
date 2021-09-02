package duke;

import duke.command.*;

/**
 * Class to abstract the Parsing of the Messages taken as input from the Duke
 */
public class Parser {

    /**
     * Default Constructor for the Parse Class
     */
    public Parser() {

    }

    /**
     * Method to return the Type of Command parsed
     *
     * @param command The Command Passed for comparing to the different types of Commands
     * @return The Type of Command Received
     */
    private CommandTypes getCommand(String command) {
        try {
            if (command != null) {
                return CommandTypes.valueOf(command.toUpperCase());
            } else {
                return CommandTypes.UNKNOWN;
            }
        } catch (IllegalArgumentException e) {
            return CommandTypes.UNKNOWN;
        }
    }

    /**
     * Method to return the specific Command processed from the given from the Command String
     *
     * @param taskDescription The Command inputted as a String
     * @return The specific Command in the given Command String
     */
    public Command parse(String taskDescription) {

        if (taskDescription == null || taskDescription.equals("")) {
            return new UnknownCommand(CommandTypes.UNKNOWN, "");
        } else {
            String taskObjective, taskDetails;
            String[] task = taskDescription.split(" ", 2);
            taskObjective = task[0];
            taskDetails = task.length > 1 ? task[1].trim() : "";
            if(taskObjective.isBlank()) {
                return new EmptyCommand(CommandTypes.EMPTY, "");
            } else {
                switch (getCommand(taskObjective)) {
                case BYE:
                    return new ByeCommand(CommandTypes.BYE, taskDetails);
                case DEADLINE:
                    return new DeadlineCommand(CommandTypes.DEADLINE, taskDetails);
                case DELETE:
                    return new DeleteCommand(CommandTypes.DELETE, taskDetails);
                case DONE:
                    return new DoneCommand(CommandTypes.DONE, taskDetails);
                case EVENT:
                    return new EventCommand(CommandTypes.EVENT, taskDetails);
                case FIND:
                    return new FindCommand(CommandTypes.FIND, taskDetails);
                case LIST:
                    return new ListCommand(CommandTypes.LIST, taskDetails);
                case TODO:
                    return new ToDoCommand(CommandTypes.TODO, taskDetails);
                default:
                    return new UnknownCommand(CommandTypes.UNKNOWN, taskDetails);
                }
            }
        }
    }
}