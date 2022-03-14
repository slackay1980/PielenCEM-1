package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class AddCustomerController extends Controller {

    private FXMLLoader loader;
    private Parent root;


    public AddCustomerController(Stage primaryStage, String view)  {
        super(primaryStage, view);
        this.loader = getLoader();
        this.root = getRoot();
        this.setScene(new Scene(root, 600, 467));
        this.showAndWait();

    }

    @FXML
    private void initialize()
    {

    }




}
