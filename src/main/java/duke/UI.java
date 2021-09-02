package duke;
import duke.task.Task;

import java.util.Scanner;

/**
 * Class to abstract the rendering of the UI of the Duke
 */
public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    private final Scanner input;

    /**
     * Constructor for the UI Class
     */
    public UI() {
        input = new Scanner(System.in);
    }

    /**
     * Method to print the UI on the console
     *
     * @param output The String message to be printed on the console
     */
    public void display(String output) {
        System.out.println(ANSI_CYAN + "     " + output + ANSI_RESET);
    }

    /**
     * Method to print the Logo and the Welcome Message
     */
    public void showWelcome() {
        System.out.println("\n");
        String buffer = "     ";
        String logo =   buffer + " ____        _\n"
                + buffer + "|  _ \\ _   _| | _____\n"
                + buffer + "| | | | | | | |/ / _ \\\n"
                + buffer + "| |_| | |_| |   <  __/\n"
                + buffer + "|____/ \\__,_|_|\\_\\___|\n";
        display("Hello from\n" + logo);

        showLine();
        display("Hello! I'm Duke");
        display("What can I do for you?");
        showLine();
    }

    /**
     * Method to print the Line in the console
     */
    public void showLine() {
        System.out.println("____________________________________________________________________________________" +
                "____________________________________");
    }

    /**
     * Method to Read a Command Inputted by the User
     *
     * @return The Command Inputted by the User
     */
    public String readCommand() {
        return input.hasNextLine() ? input.nextLine().trim() : "";
    }

    /**
     * Method to print the error message on the console
     *
     * @param error The error message to be printed on the console
     */
    public void showError(String error) {
        System.out.println(ANSI_RED + "     " + error + "\n     Try Again \\_(\"v\")_/" + ANSI_RESET);
    }

    /**
     *
     */
    public void byCommandUi() {
        display("Bye. Hope to see you again soon! \\_(\"v\")_/");
    }

    /**
     *
     * @param task
     * @param numberOfTasks
     */
    public void addCommandUi(Task task, int numberOfTasks) {
        display("Got it. I've added this task:");
        display("  " + task);
        display("Now you have " + numberOfTasks + " tasks in the list.");
    }

    /**
     *
     * @param task
     */
    public void deleteCommandUi(Task task) {
        display("Noted. I've removed this task:");
        display("  " + task);
    }

    /**
     *
     * @param task
     */
    public void doneCommandUi(Task task) {
        display("Nice! I've marked this task as done:");
        display("  " + task);
    }

    /**
     *
     * @param taskList
     */
    public void findCommandUi(TaskList taskList) {
        if ((taskList != null) && (taskList.getTaskListLength() > 0)) {
            display("Here are the tasks with the search parameters:");
            for (int i = 0; i < taskList.getTaskListLength(); i++) {
                display((i + 1) + "." + taskList.getTask(i));
            }
        } else {
            display("There are no Tasks with the given parameters");
        }
    }

    /**
     * Method to display all the Tasks in the Task List
     * @param taskList The List of Tasks in Duke
     */
    public void listCommandUi(TaskList taskList) {
        if ((taskList != null) && (taskList.getTaskListLength() > 0)) {
            display("Here are the tasks in your list:");
            for (int i = 0; i < taskList.getTaskListLength(); i++) {
                display((i + 1) + "." + taskList.getTask(i));
            }
        } else {
            display("The Task List is Empty");
        }
    }
}