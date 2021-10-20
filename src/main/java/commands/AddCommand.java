package commands;

import exceptions.DukeException;
import storage.Storage;
import tasks.*;
import tasks.TaskList;
import ui.Ui;

import java.io.IOException;

/**
 * <code>AddCommand</code> is used to add new task into the TaskList.
 * Extends the <code>Command</code> class.
 */
public class AddCommand extends Command{
    Task task;

    public AddCommand(Task task){
        this.task = task;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        boolean isAdded = taskList.addTask(task);

        if (isAdded){
            storage.saveTasks(taskList.getTasks());
            ui.showAdded();
            ui.printTask(task.toString());
            ui.printTaskCount(taskList.getListSize());
        } else {
            ui.showError("Task is not added. There is a schedule clash!");
        }
    }
}
