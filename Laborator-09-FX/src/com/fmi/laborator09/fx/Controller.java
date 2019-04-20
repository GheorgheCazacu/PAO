package com.fmi.laborator09.fx;

import com.fmi.laborator09.fx.models.User;
import com.fmi.laborator09.fx.services.UserService;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {

    @FXML private Button exitButton;
    @FXML private ProgressBar taskProgressBar;
    @FXML private Button performTaskButton;
    @FXML private Label taskLabel;
    @FXML private TableView<User> dataTableView;

    /**
     * this method is executed at initialize of the controller
     * this is made auto
     */
    public void initialize() {
        System.out.println("initialize");

        // define columns for the only TableView on the screen
        dataTableView.getColumns().clear();

        TableColumn<User, Integer> userIdColumn = new TableColumn<>("Id");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));

        TableColumn<User, String> userUsernameColumn = new TableColumn<>("Username");
        userUsernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));

        TableColumn<User, String> userNameColumn = new TableColumn<>("name");
        userNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));

        TableColumn<User, Date> userDateOfBirthColumn = new TableColumn<>("DoB");
        userDateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<User, Date>("dateOfBirth"));

        dataTableView.getColumns().addAll(userIdColumn, userUsernameColumn, userNameColumn, userDateOfBirthColumn);

    }

    public void performTask() {
        System.out.println("start performing a task");

        // prepare a task to be executed in parallel
        Task<List<User>> usersTasks = new Task<List<User>>() {
            @Override
            protected List<User> call() throws Exception {
                List<User> result = new ArrayList<>();

                //TODO the logic behind is having only the purpose to be a little slow to make a point
                // don't do this kind of implementation in your real programmes
                List<User> fromService = UserService.getInstance().findAll();
                int counter = 0;
                int maxUsers = fromService.size();
                for(User user : fromService) {
                    if(isCancelled()) {
                        break;
                    }
                    counter++;
                    result.add(user);
                    // update the interface with the progress
                    updateMessage("another user comme in the picture: " + user.getUsername() );
                    updateProgress(counter, maxUsers);
                    updateValue(result);
                    Thread.sleep(500);
                }

                return result;
            }

        };

        usersTasks.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                dataTableView.setItems(FXCollections.observableList(usersTasks.getValue()));
            }
        });

        // start the execution of a task as a thread
        Thread th = new Thread(usersTasks);
        th.setDaemon(true);
        th.start();

        // bind the progressbar property with task property
        taskProgressBar.progressProperty().bind(usersTasks.progressProperty());
        taskLabel.textProperty().bind(usersTasks.messageProperty());

    }

    /**
     * linked to the exit button from sample.fxml
     */
    public void exitButtonOnClick() {
        System.out.println("exitButtonOnClick");
        System.exit(0);

    }


}
