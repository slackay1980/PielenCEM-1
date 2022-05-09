package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddRelationController extends Controller{

    public  AddRelationController() {

    }


    @FXML
    private TextField relationProducerStation;

    @FXML
    private TextField relationCustomerStationr;

    @FXML
    private TextField relationDistance;

    @FXML
    private TextField relationOptional1;

    @FXML
    private TextField relationOptional2;

    @FXML
    private TextField relationOptional3;

    @FXML
    private TextField relationOptional4;

    @FXML
    private CheckBox relationCustom;


    @FXML
    private void btnSaveClicked() {

    }


    @FXML
    private void btnCancelClicked()
    {
        getStage().close();
    }
}
