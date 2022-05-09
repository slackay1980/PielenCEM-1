package controller;


import javafx.stage.Stage;

public abstract class Controller  {
    private Stage stage;


    public Controller() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }

 }
