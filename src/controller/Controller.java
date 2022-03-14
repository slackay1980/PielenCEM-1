package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller extends Stage {
    private Stage primaryStage;
    private String view;
    private FXMLLoader loader = null;
    private Stage  stage = this;
    private Parent root;

    public Controller(Stage primaryStage,String view) {
            super();
            this.primaryStage = primaryStage;
            this.view = view;
            initialize();

    }

    private void  initialize() {

        this.initOwner(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);

        try {
            loader = new FXMLLoader(getClass().getResource(view));
            System.out.println(loader);
        }
        catch (Exception e) {
            new view.AlertMessage("Info-1","Es ist ein Fehler aufgetretten",
                    "Das Fenster konnte nicht angezeigt werden");

        }


    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public Parent getRoot() {
        try {
            root = loader.load();
            System.out.println(root);
        }
        catch (Exception e) {
            new view.AlertMessage("Info-2","Es ist ein Fehler aufgetretten",
                    "Das Fenster konnte nicht angezeigt werden");

        }
        return root;
    }
}
