package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class TaskManager {


    private ObservableList<String> tasks = FXCollections.observableArrayList();

   private LimitedSizeStack<History> stackHistory = new LimitedSizeStack<>(10);
    public void addTask(String task) {
        tasks.add(task);
        History first = new AddHistory(task);
        stackHistory.push(first);
    }
    public ObservableList<String> getTasks() {
        return tasks;
    }

    public void changeTask(String actualName, int index) {

        History history = new ChangeHistory(tasks.get(index), actualName, index);
        tasks.set(index, actualName);
        stackHistory.push(history);
    }


    public void removeTask(int index) {

        History history = new RemoveHistory(tasks.get(index), index);

        tasks.remove(index);
        stackHistory.push(history);
    }

    public boolean canUndo() {
        return stackHistory.size() > 0;
    }
    public void undo() {

        History history = stackHistory.pop();

        if (history instanceof AddHistory) {
            tasks.remove(history.getTask());
        } else if (history instanceof RemoveHistory) {
            tasks.add(((RemoveHistory) history).getIndex(),history.getTask());
        } else if (history instanceof ChangeHistory) {
            tasks.set(((ChangeHistory) history).getIndex(), ((ChangeHistory) history).getOldValue());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < tasks.size() ; i++) {
            s = s + tasks.get(i) + " ";
        }
        return s;
    }
}
