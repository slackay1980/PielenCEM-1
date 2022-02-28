package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class mainWindowController {

    @FXML
    // The reference of inputText will be injected by the FXML loader
    private TreeView controlList;

    @FXML
    private Button btnWindow;

    @FXML
    private ScrollPane mainPane;

    @FXML
    private  AnchorPane  detailsPane;



    // Add a public no-args constructor
    public mainWindowController()
    {
    }

    @FXML
    private void btnClicked(){

        System.out.println("Clicked");
/*
        try {
            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");

            Parent root = FXMLLoader.load(getClass().getResource("/view/dialog.fxml"));

            newWindow.setScene(new Scene(root, 800, 275));

            // Set position of second window, related to primary window.
            // newWindow.setX(primaryStage.getX() + 200);
            // newWindow.setY(primaryStage.getY() + 100);

            newWindow.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
*/

    try {

        Parent ap = FXMLLoader.load(getClass().getResource("/view/dialog.fxml"));
        //mainPane.setContent(ap);

        detailsPane.getChildren().setAll(ap);

    }
    catch (Exception e) {

    }
    }






    @FXML
    private void initialize()
    {
        TreeItem<String> root = new TreeItem<String>("PIELEN CEM");
        root.setExpanded(true);

        TreeItem<String> bestellung = new TreeItem<String>("Bestellung");
        bestellung.setGraphic(new Rectangle(10.0,10.0, Color.RED));
        bestellung.getChildren().add(new TreeItem<String>("neue Bestellung eingeben"));
        bestellung.getChildren().add(new TreeItem<String>("neue bestellung eingeben (Kurzform)"));
        bestellung.setExpanded(true);

        root.getChildren().add(bestellung);
        controlList.setRoot(root);



    }

    @FXML
    private void printOutput(){

    }
}
