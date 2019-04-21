package com.fmi.laborator09.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 800));

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");

        menuFile.getItems().addAll(new MenuItem("New"));
        menuFile.getItems().addAll(new MenuItem("Open"));
        menuFile.getItems().addAll(new MenuItem("Exit"));

        menuBar.getMenus().addAll(menuFile);
        //very important on mac os x
        menuBar.setUseSystemMenuBar(true);
        ((GridPane)primaryStage.getScene().getRoot()).getChildren().addAll(menuBar);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
