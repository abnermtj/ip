package duke.command;

import duke.exception.DukeException;
import duke.io.Storage;
import duke.io.Ui;
import duke.task.*;

public class AddCommand extends Command {
    public static final String CANNOT_CREATE_TASK = "Unable to create the new Task";
    private static final int NUM_ARGS_DEADLINE = 2;
    private static final int NUM_ARGS_EVENT = 2;

    private String command;
    private String description;

    public AddCommand(String command, String description) throws DukeException {
        this.command = command;
        this.description = description;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws DukeException {
        Task newTask = null;
        switch (command) {
        case "todo":
            newTask = tasksList.addTodo(description, false);
            break;
        case "deadline":
            newTask = tasksList.addDeadline(description, false);
            break;
        case "event":
            newTask = tasksList.addEvent(description, false);
            break;
        }

        ui.printSuccessfulAddEntry(tasksList, newTask);
        storage.saveTasksList(tasksList);
    }

}