package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class MainWindowController {

    private Stage parentStage;

    @FXML
    // The reference of inputText will be injected by the FXML loader
    private TreeView controlList;

    @FXML
    private Button btnWindow;

    @FXML
    private ScrollPane mainPane;

    @FXML
    private  AnchorPane  detailsPane;

    @FXML
    private MenuItem mnuAllCustomersView;


    // Add a public no-args constructor
    public MainWindowController()
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

    @FXML // Menu -> Kunde -> Kunde neu anlegen
    private void addCustomerShow() {

//        new AddCustomerController(parentStage, "/view/AddCustomerView1.fxml");

            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AddCustomerView.fxml"));

                root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Kunde neu anlegen");

                stage.setScene(new Scene(root, 600, 600));

                stage.initOwner(parentStage);
                stage.initModality(Modality.APPLICATION_MODAL);
                AddCustomerController addCustomerCtrl = (AddCustomerController) loader.getController();
                addCustomerCtrl.setStage(stage);

                stage.showAndWait();

            }
            catch (IOException e) {
                e.printStackTrace();
            }


    }

    @FXML // Menu -> Kunde -> Kundenstationen ...
    private void  addCustomerStationShow() {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AddCustomerStation.fxml"));

            root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Kundenstationen ...");

            stage.setScene(new Scene(root, 600, 680));

            stage.initOwner(parentStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            AddCustomerStationController addCustomerStationCtrl = (AddCustomerStationController) loader.getController();
            addCustomerStationCtrl.setStage(stage);

            stage.showAndWait();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML // Menu -> Kunde -> List alle Kunden ...
    private void  allCustomersViewShow() {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AllCustomersView.fxml"));

            root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Alle Kunden ...");

            stage.setScene(new Scene(root, 600, 680));

            stage.initOwner(parentStage);
            stage.initModality(Modality.APPLICATION_MODAL);
            AllCustomersViewController allCustomersViewController = (AllCustomersViewController) loader.getController();
            allCustomersViewController.setStage(stage);

            stage.showAndWait();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize()
    {
        prepareTreeView();
        setHandlerOnTreeView();




    }

    public void setStage(Stage stage) {
        this.parentStage = stage;
    }

    private void prepareTreeView() {

        TreeItem<String> root = new TreeItem<String>("PIELEN CEM");
        root.setExpanded(true);

        TreeItem<String> orderCiment = new TreeItem<String>("Tourenerfassung");
        //order.setGraphic(new Rectangle(10.0,10.0, Color.BLUE));
        orderCiment.getChildren().add(new TreeItem<String>("alle Auftträge"));
        orderCiment.getChildren().add(new TreeItem<String>("alle auf morgen"));
        orderCiment.getChildren().add(new TreeItem<String>("alle verplant"));
        orderCiment.getChildren().add(new TreeItem<String>("alle offen"));
        orderCiment.setExpanded(true);

        TreeItem<String> inputOrder = new TreeItem<String>("Bestellung");
        //bestellung.setGraphic(new Rectangle(10.0,10.0, Color.BLUE));
        inputOrder.getChildren().add(new TreeItem<String>("Bestellung eingeben"));
        inputOrder.getChildren().add(new TreeItem<String>("Bestellung eingeben (Kurzform)"));
        inputOrder.setExpanded(true);

        TreeItem<String> customer = new TreeItem<String>("Kunde");
        //bestellung.setGraphic(new Rectangle(10.0,10.0, Color.BLUE));
        customer.getChildren().add(new TreeItem<String>("Anlegen"));
        customer.getChildren().add(new TreeItem<String>("Neue Station "));
        customer.getChildren().add(new TreeItem<String>("Station redaktieren"));
        customer.getChildren().add(new TreeItem<String>("Kundendaten ändern"));
        customer.getChildren().add(new TreeItem<String>("Kundendaten löschen"));
        customer.setExpanded(false);

        TreeItem<String> transporter = new TreeItem<String>("Spedition");
        //bestellung.setGraphic(new Rectangle(10.0,10.0, Color.BLUE));
        transporter.getChildren().add(new TreeItem<String>("Anlegen"));
        transporter.getChildren().add(new TreeItem<String>("Spedition redaktieren"));
        transporter.getChildren().add(new TreeItem<String>("Kundendaten löschen"));
        transporter.setExpanded(true);

        TreeItem<String> relationFreight = new TreeItem<String>("Relationen & Frachten");
        //bestellung.setGraphic(new Rectangle(10.0,10.0, Color.BLUE));
        relationFreight.getChildren().add(new TreeItem<String>("Relation anlegen"));
        relationFreight.getChildren().add(new TreeItem<String>("Relation redaktieren"));
        relationFreight.getChildren().add(new TreeItem<String>("Relation löschen"));
        relationFreight.getChildren().add(new TreeItem<String>("Fracht managen"));
        relationFreight.setExpanded(true);




        root.getChildren().add(orderCiment);
        root.getChildren().add(inputOrder);
        root.getChildren().add(customer);
        root.getChildren().add(transporter);
        root.getChildren().add(relationFreight);
        controlList.setRoot(root);
    }

    private void setHandlerOnTreeView() {
        controlList.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if(mouseEvent.getClickCount() == 2)
                {
                    TreeItem<String> item = (TreeItem<String>) controlList.getSelectionModel().getSelectedItem();

                    switch(item.getValue()) {
                        case "neue Bestellung eingeben":
                            // code block
                            System.out.println("Selected Text : " + item.getValue());
                            break;
                        case "neue bestellung eingeben (Kurzform)":
                            System.out.println("Selected Text : " + item.getValue());
                            // code block
                            break;
                        default:
                            // code block
                    }




                }
            }
        });
    }


    @FXML
    private void printOutput(){

    }
}
