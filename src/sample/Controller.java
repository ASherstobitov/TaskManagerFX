package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField TextTask;
    public ListView ListView1;
    public Button btnDelete;
    public Button btnChange;


    private TaskManager taskManager = new TaskManager();

    public void createTaskClick() {
        String task = TextTask.getText();
        taskManager.addTask(task);
        TextTask.clear();
    }

    public void changeTaskClick() {
        int index = ListView1.getSelectionModel().getSelectedIndex();
        String actualName = TextTask.getText();
        if (actualName.isEmpty()) {
           Alert alert = new Alert(Alert.AlertType.ERROR, "To enter the name of task");
           alert.showAndWait();
            return;
        }
        taskManager.changeTask(actualName, index);
        TextTask.clear();

    }


    public void removeTaskClick() {
        int index = ListView1.getSelectionModel().getSelectedIndex();
        taskManager.removeTask(index);
    }

    public void undoActionClick() {
        if (taskManager.canUndo()) {
            taskManager.undo();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnDelete.setDisable(true);
        btnChange.setDisable(true);
        ListView1.setItems(taskManager.getTasks());
        ListView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (newValue == null) {
                    btnDelete.setDisable(true);
                    btnChange.setDisable(true);
                } else {
                    btnDelete.setDisable(false);
                    btnChange.setDisable(false);
                }







            }
        });
    }
}
