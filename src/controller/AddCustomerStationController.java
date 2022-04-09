package controller;

import entyties.Customer;
import entyties.CustomerStation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private Customer customer;
    private CustomerStation customerStation;
    private List<CustomerStation> customerStations;
    private List<Integer> listIdsCustomerStations;
    private ObservableList<String> itemsComboBox= FXCollections.observableArrayList();

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
    private void selectItemComboBox() {
        System.out.println("ComboSelected");
        fillFieldsBySelectingCustomerStation();
    }

    @FXML
    private void btnSaveClicked() {

    }

    @FXML
    private void btnCancelClicked() {

    }







    @FXML
    private void initialize()
    {
        // disable all controll elements bevor  one customer is selected
        disableAllControllElements();
        findCustomerStation.requestFocus();
        setKeyHandlerOnFindCustomerStation();




    }


    @FXML
    private void printOutput(){

    }

    private void setKeyHandlerOnFindCustomerStation() {

        findCustomerStation.addEventFilter( KeyEvent.KEY_PRESSED, keyEvent -> {
            if( keyEvent.getCode() == KeyCode.ENTER)
            {
                List<Customer> list = new CustomerService().getCustomersLikeString(findCustomerStation.getText());

                PoolDownDialog dialog = new PoolDownDialog(getStage(),findCustomerStation,list);
                int i = dialog.showDialog();
                customer = list.get(i);
                System.out.println(customer);
                findCustomerStation.setText(customer.getCustomerName()+", "+customer.getCustomerCity());
                fillComboBoxCustomerStations(customer.getId());

            }
        });
    }

    private void fillComboBoxCustomerStations(int i) {

        List<CustomerStation> customerStations = new CustomerService().getStationsFromCustomer(i);
        if (customerStation!=null) {

        }
        else {
            this.customerStations = customerStations;
            listStations.setDisable(false);
            fillObservableList(customerStations);
            initComboBoxItems();
            }
    }


    private void disableAllControllElements() {
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
        listStations.setDisable(true);
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

    private void initComboBoxItems() {
        listStations.setItems(itemsComboBox);
    }

    // filling observable List from customer List in order to show it in ListWiew
    private void fillObservableList(List<CustomerStation> listCustomerStations ) {
        for(int i=0;(i<=listCustomerStations.size()-1);i++) {

            itemsComboBox.add(listCustomerStations.get(i).getStationName() + " ," + listCustomerStations.get(i).getStationCity());
            listIdsCustomerStations = new ArrayList<>();
            listIdsCustomerStations.add(i);
        }
    }

    private void fillFieldsBySelectingCustomerStation() {
        CustomerStation customerStation = new CustomerStation();
        int i = listStations.getSelectionModel().getSelectedIndex();
        customerStation =  customerStations.get(i);
        customerStationName.setText(customerStation.getStationName());
        customerStationStreet.setText(customerStation.getStationStreet());
        //customerStationCountry.setText(customerStation.get);
        customerStationPostCode.setText(customerStation.getStationLandPostCode());
        customerStationCity.setText(customerStation.getStationCity());
        customerStationEmploee.setText(customerStation.getStationEmploee());
        customerStationTelOffice.setText(customerStation.getStationTelefone1());
        customerStationTelMobile.setText(customerStation.getStationTelefone2());
        //customerStationFax.setText(customerStation.get);
        customerStationEmail.setText(customerStation.getStationEmail());
        customerStationNote.setText(customerStation.getStationNote());
    }
}
