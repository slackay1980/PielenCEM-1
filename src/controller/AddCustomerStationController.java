package controller;

import entyties.Customer;
import entyties.CustomerStation;
import entyties.Region;
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
import view.AlertMessage;
import view.PoolDownDialog;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCustomerStationController extends Controller {

    private Customer customer;

    private CustomerStation customerStation;
    private List<CustomerStation> customerStations;
    private HashMap<Integer,Integer> customerStationsIdxAndIds = new HashMap<>();


    private Region region;
    private List<Region>  regions;
    private HashMap<Integer,Integer> regionsIdxAndIds = new HashMap<>();


    private ObservableList<String> itemsComboBoxStations= FXCollections.observableArrayList();
    private ObservableList<String> itemsComboBoxRegions= FXCollections.observableArrayList();


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
    private ComboBox<String>  listRegions;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

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
        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
    }

    @FXML
    private void selectItemComboBoxRegion() {

    }

    @FXML
    private void btnSaveClicked() {
        if (setCustomerStation()) {


            if (new CustomerService().saveCustomerStation(customerStation)) {
                getStage().close();
                new AlertMessage("Gespeichert", "Eine neue Station wurde hinzugefügt",
                        customerStation.getStationName() + ", " + customerStation.getStationCity());
            } else {
                new AlertMessage("Fehler", "Es konnte keine verbindung zu Datenbank erstellt werden",
                        "Es wurde nichts gespeichert");
            }
        }
    }

    @FXML
    private void btnUpdateClicked() {
        if (setUpdatedCustomerStation()) {
            if (new CustomerService().updateCustomerStation(customerStation)) {
                getStage().close();
                new AlertMessage("Änderungen gespeichert", "Eine Änderungen wurden übernommen",
                        customerStation.getStationName() + ", " + customerStation.getStationCity() + "Region ist " + region.getRegionName());
            } else {
                new AlertMessage("Fehler", "Es konnte keine verbindung zu Datenbank erstellt werden",
                        customerStation.getStationName() + ", " + customerStation.getStationCity() + "  wurde nicht geändert");
            }
        }
    }

    @FXML
    private void btnCancelClicked() {
        getStage().close();
    }



    @FXML
    private void initialize()
    {
        // initialise necessery lists


        regions = new CustomerService().getAllRegions();
        fillObservableListRegions(regions);
        initComboBoxItemsRegions();

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
// TODO Prüfen if List is empty
                if (list.size()>0) {
                    PoolDownDialog dialog = new PoolDownDialog(getStage(), findCustomerStation, list);
                    int i = dialog.showDialog();
                    if (i==-1) {findCustomerStation.setText(""); }
                    else {
                    customer = list.get(i);
                    System.out.println(customer);                                                                            // !!!!!!!!!!!!!!!
                    findCustomerStation.setText(customer.getCustomerName() + ", " + customer.getCustomerCity());
                    findCustomerStation.setEditable(false);
                    findCustomerStation.setDisable(true);
                    fillComboBoxCustomerStations(customer.getId());
                    // **********************
                    enableControllsForSaveNew(); }
                }
            }
        });
    }

    private void fillComboBoxCustomerStations(int i) {

        List<CustomerStation> customerStations = new CustomerService().getStationsFromCustomer(i);
        if (customerStations==null) {
            new AlertMessage("Fehler","Es konnte keine verbindung zu Datenbank erstellt werden",
                    "Das Fenster wird zugemacht");
            getStage().close();
        }
        else {
            this.customerStations = customerStations;
            listStations.setDisable(false);
            fillObservableListStations(customerStations);                                                                // !!!!!!!!!!!!!
            initComboBoxItemsStations();
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
        btnUpdate.setDisable(true);
        listRegions.setDisable(true);


    }


    private void enableControllsForSaveNew() {

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
        listRegions.setDisable(false);



    }

    private void initComboBoxItemsStations() {
        listStations.setItems(itemsComboBoxStations);
    }

    private void initComboBoxItemsRegions() {
        listRegions.setItems(itemsComboBoxRegions);
    }

    // filling observable List from customer List in order to show it in ListWiew
    private void fillObservableListStations(List<CustomerStation> listCustomerStations ) {

        for(int i=0;(i<=listCustomerStations.size()-1);i++) {

            itemsComboBoxStations.add(listCustomerStations.get(i).getStationName() + " ," + listCustomerStations.get(i).getStationCity()+
                    ""+listCustomerStations.get(i).getId());

            //listIdsCustomerStations.add(i);
            customerStationsIdxAndIds.put(i ,listCustomerStations.get(i).getId());

            System.out.println(i+"-----  "+listCustomerStations.get(i).getStationName());
            System.out.println("ID = "+customerStationsIdxAndIds.get(i));
        }
    }

    private void fillObservableListRegions(List<Region> listRegions) {
        for(int i=0; i<=listRegions.size()-1; i++) {
            itemsComboBoxRegions.add(listRegions.get(i).getRegionName());

            regionsIdxAndIds.put(i,listRegions.get(i).getId());

            System.out.println(i+"----  "+listRegions.get(i).getRegionName());
            System.out.println(i+"----  "+regionsIdxAndIds.get(i));
            // listIdsRegions.add(i);
        }
    }

    private void fillFieldsBySelectingCustomerStation() {
        customerStation = new CustomerStation();
        int i = listStations.getSelectionModel().getSelectedIndex();
        customerStation =  customerStations.get(i);
        customerStationName.setText(customerStation.getStationName());
        customerStationStreet.setText(customerStation.getStationStreet());
        customerStationCountry.setText(customerStation.getStationLand());
        customerStationPostCode.setText(customerStation.getStationPostCode());
        customerStationCity.setText(customerStation.getStationCity());
        customerStationEmploee.setText(customerStation.getStationEmploee());
        customerStationTelOffice.setText(customerStation.getStationTelefone1());
        customerStationTelMobile.setText(customerStation.getStationTelefone2());
        //customerStationFax.setText(customerStation.get);
        customerStationEmail.setText(customerStation.getStationEmail());
        customerStationNote.setText(customerStation.getStationNote());
        int regionIndex = getRegionByIdFromMap(customerStation.getRegion().getId());
        System.out.println("Ich ändere listRegions auf index --"+regionIndex);
        listRegions.getSelectionModel().select(regionIndex);

    }

    private boolean ifTxtFieldsValid() {
        if ((customerStationName.getText().equals(""))
                ||
                (customerStationStreet.getText().equals(""))
                ||
                (customerStationCountry.getText().equals(""))
                ||
                (customerStationPostCode.getText().equals(""))
                ||
                (customerStationCity.getText().equals(""))
                ||
                (listRegions.getSelectionModel().getSelectedIndex()==-1))
        return false;
            else
                return true;
    }

    //  Saving new Customer Station.  We fill all fields to CustomerStation
    private Boolean setCustomerStation() {
        if (ifTxtFieldsValid()) {
            customerStation = new CustomerStation();
            customerStation.setCustomer(customer);
            customerStation.setStationName(customerStationName.getText());
            customerStation.setStationStreet(customerStationStreet.getText());
            customerStation.setStationLand(customerStationCountry.getText());
            customerStation.setStationPostCode(customerStationPostCode.getText());
            customerStation.setStationCity(customerStationCity.getText());
            customerStation.setStationEmploee(customerStationEmploee.getText());
            customerStation.setStationTelefone1(customerStationTelOffice.getText());
            customerStation.setStationTelefone2(customerStationTelMobile.getText());
            //customerStation.setStationTelefone3(customerStationFax.getText());
            customerStation.setStationEmail(customerStationEmail.getText());
            customerStation.setStationNote(customerStationNote.getText());
            customerStation.setRegion(regions.get(listRegions.getSelectionModel().getSelectedIndex()));
            return true;
        }
        else {
            new view.AlertMessage("Fehler","Eingabe ist nicht valid",
                    "Alle Felder gekennzeichnet mit * müssen ausgefüllt sein");
            return false;
        }
    }

    private Boolean setUpdatedCustomerStation() {
        if (ifTxtFieldsValid()) {
            customerStation.setStationName(customerStationName.getText());
            customerStation.setStationStreet(customerStationStreet.getText());
            customerStation.setStationLand(customerStationCountry.getText());
            customerStation.setStationPostCode(customerStationPostCode.getText());
            customerStation.setStationCity(customerStationCity.getText());
            customerStation.setStationEmploee(customerStationEmploee.getText());
            customerStation.setStationTelefone1(customerStationTelOffice.getText());
            customerStation.setStationTelefone2(customerStationTelMobile.getText());
            //customerStation.setStationTelefone3(customerStationFax.getText());
            customerStation.setStationEmail(customerStationEmail.getText());
            customerStation.setStationNote(customerStationNote.getText());

            // we get the index(selected Item)  from ComboBox. Then we get from regions List an Object region on this index
            // ComboBox Index is
            region = regions.get(listRegions.getSelectionModel().getSelectedIndex());
            customerStation.setRegion(region);
            return true;
        }
        else {
            new view.AlertMessage("Fehler","Eingabe ist nicht valid",
                    "Alle Felder gekennzeichnet mit * müssen ausgefüllt sein");
            return false;
        }
    }
    
    private int getRegionByIdFromMap(int id) {
        int returnedValue = -1;
        for (Map.Entry<Integer, Integer> entry : regionsIdxAndIds.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("!!!!!!!!!!!!"+key+"   !!!! "+value);                                            //!!!!!!!!!!!!!!!!!!!
            if (id == value) {
                returnedValue =  key;
                System.out.println("Rgion ID "+id+" is eqaul to "+value+"and I set the regionList ID to"+key);  // !!!!!!!!!!!!!!!!!!
            }
        }
        return returnedValue;
    }
}
