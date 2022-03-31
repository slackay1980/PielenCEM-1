package controller;

import entyties.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.CustomerService;
import view.PoolDownDialog;

import java.util.ArrayList;
import java.util.List;

public class AddCustomerStationController extends Controller {

    public AddCustomerStationController() {
    }

    @FXML
    private TextField findCustomerStation;

    @FXML
    private  TextField customerStationName;

    @FXML
    private TextField customerStationStreet;

    @FXML
    private TextField customerStationCountry;

    @FXML
    private TextField customerStationPostCode;

    @FXML
    private TextField customerStationCity;

    @FXML
    private TextField customerStationEmploee;

    @FXML
    private TextField  customerStationTelOffice;

    @FXML
    private TextField  customerStationTelMobile;

    @FXML
    private TextField  customerStationFax;

    @FXML
    private TextField  customerStationEmail;

    @FXML
    private TextField customerStationNote;

    @FXML
    private ComboBox<String>  listStations;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    // Action Metods

    @FXML
    private void findCustomerStation() {

    }

    @FXML
    private void customerStationNameClicked() {
        ListView<String> listCustomersLikeString = new ListView<>();
        listCustomersLikeString.setVisible(true);

    }

    @FXML
    private void btnSaveClicked() {

    }

    @FXML
    private void btnCancelClicked() {

    }

    private void disableControlls() {
        customerStationName.setDisable(true);
        customerStationStreet.setDisable(true);
        customerStationCountry.setDisable(true);
        customerStationPostCode.setDisable(true);
        customerStationCity.setDisable(true);
        customerStationEmploee.setDisable(true);
        customerStationTelOffice.setDisable(true);
        customerStationTelMobile.setDisable(true);
        customerStationFax.setDisable(true);
        customerStationEmail.setDisable(true);
        customerStationNote.setDisable(true);
        btnSave.setDisable(true);
        btnCancel.setDisable(true);

    }


    private void enableControlls() {

            customerStationName.setDisable(false);
            customerStationStreet.setDisable(false);
            customerStationCountry.setDisable(false);
            customerStationPostCode.setDisable(false);
            customerStationCity.setDisable(false);
            customerStationEmploee.setDisable(false);
            customerStationTelOffice.setDisable(false);
            customerStationTelMobile.setDisable(false);
            customerStationFax.setDisable(false);
            customerStationEmail.setDisable(false);
            customerStationNote.setDisable(false);
            btnSave.setDisable(false);
            btnCancel.setDisable(false);


    }





    @FXML
    private void initialize()
    {
        disableControlls();
        findCustomerStation.requestFocus();
        findCustomerStation.addEventFilter( KeyEvent.KEY_PRESSED, keyEvent -> {
            if( keyEvent.getCode() == KeyCode.ESCAPE)
            {
                // closeList();

            }


            if( keyEvent.getCode() == KeyCode.ENTER)
            {
                List<Customer> list = new CustomerService().getCustomersLikeString(findCustomerStation.getText());

                PoolDownDialog dialog = new PoolDownDialog(getStage(),findCustomerStation,list);
                int i = dialog.showDialog();
                findCustomerStation.setText(Integer.toString(i));

            }
        });
    }


    @FXML
    private void printOutput(){

    }
}
