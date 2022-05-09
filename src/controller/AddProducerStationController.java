package controller;

import entyties.Producer;
import entyties.ProducerStation;
import entyties.Region;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.ProducerService;
import view.AlertMessage;
import view.PoolDownDialogProducer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddProducerStationController extends Controller{

    private Producer producer;

    private ProducerStation producerStation;
    private List<ProducerStation> producerStations;
    private HashMap<Integer,Integer> producerStationsIdxAndIds = new HashMap<>();


    private Region region;
    private List<Region>  regions;
    private HashMap<Integer,Integer> regionsIdxAndIds = new HashMap<>();


    private ObservableList<String> itemsComboBoxStations= FXCollections.observableArrayList();
    private ObservableList<String> itemsComboBoxRegions= FXCollections.observableArrayList();

    @FXML
    private TextField findProducer;

    @FXML
    private TextField producerStationName;

    @FXML
    private TextField producerStationStreet;

    @FXML
    private TextField producerStationCountry;

    @FXML
    private TextField producerStationPostCode;

    @FXML
    private TextField producerStationCity;

    @FXML
    private TextField producerStationEmploee;

    @FXML
    private TextField producerStationTelOffice;

    @FXML
    private TextField producerStationTelMobile;

    @FXML
    private TextField producerStationFax;

    @FXML
    private TextField producerStationEmail;

    @FXML
    private TextField producerStationNote;

    @FXML
    private ComboBox listStations;

    @FXML
    private ComboBox listRegions;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnCancel;



    public AddProducerStationController() {

    }

    @FXML
    private void btnSaveClicked() {
        if (setProducerStation()) {


            if (new ProducerService().saveProducerStation(producerStation)) {
                getStage().close();
                new AlertMessage("Gespeichert", "Eine neue Station wurde hinzugefügt",
                        producerStation.getStationName() + ", " + producerStation.getStationCity());
            } else {
                new AlertMessage("Fehler", "Es konnte keine verbindung zu Datenbank erstellt werden",
                        "Es wurde nichts gespeichert");
            }
        }
    }

    @FXML
    private void btnUpdateClicked() {
        if (setUpdatedProducerStation()) {
            if (new ProducerService().updateProducerStation(producerStation)) {
                getStage().close();
                new AlertMessage("Änderungen gespeichert", "Eine Änderungen wurden übernommen",
                        producerStation.getStationName() + ", " + producerStation.getStationCity() + "Region ist " + region.getRegionName());
            } else {
                new AlertMessage("Fehler", "Es konnte keine verbindung zu Datenbank erstellt werden",
                        producerStation.getStationName() + ", " + producerStation.getStationCity() + "  wurde nicht geändert");
            }
        }
    }

    @FXML
    private void btnCancelClicked() {
        getStage().close();
    }

    @FXML
    private void producerNameClicked() {

    }

    @FXML
    private void selectItemComboBox() {
        System.out.println("ComboSelected");
        fillFieldsBySelectingCustomerStation();
        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
    }

    @FXML
    private void findCustomerStation() { }


    @FXML
    private void selectItemComboBoxRegion() { }

    @FXML
    private void initialize() {
        // initialise necessery lists
        regions = new ProducerService().getAllRegions();
        fillObservableListRegions(regions);
        initComboBoxItemsRegions();

        // disable all controll elements bevor  one customer is selected
        fieldsInit();
        disableAllControllElements();
        findProducer.requestFocus();
        setKeyHandlerOnFindCustomerStation();




    }

    private void fieldsInit() {
                producerStationName.setText("");
                producerStationStreet.setText("");
                producerStationCountry.setText("");
                producerStationPostCode.setText("");
                producerStationCity.setText("");
                producerStationEmploee.setText("");
                producerStationTelOffice.setText("");
                producerStationTelMobile.setText("");
                producerStationFax.setText("");
                producerStationEmail.setText("");
                producerStationNote.setText("");
    }

    private void setKeyHandlerOnFindCustomerStation() {

        findProducer.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if( keyEvent.getCode() == KeyCode.ENTER)
            {
                List<Producer> list = new ProducerService().getProducersLikeString(findProducer.getText());
                System.out.println(list.toString());
// TODO Prüfen if List is empty
                if (list.size()>0) {
                    PoolDownDialogProducer dialog = new PoolDownDialogProducer(getStage(), findProducer, list);
                    int i = dialog.showDialog();
                    if (i==-1) {findProducer.setText(""); }
                    else {
                        producer = list.get(i);
                        System.out.println(producer);                                                                            // !!!!!!!!!!!!!!!
                        findProducer.setText(producer.getProducentName() + ", " + producer.getProducentCity());
                        findProducer.setEditable(false);
                        findProducer.setDisable(true);
                        fillComboBoxCustomerStations(producer.getId());
                        // **********************
                        enableControllsForSaveNew(); }
                }
            }
        });
    }

    private void fillComboBoxCustomerStations(int i) {

        List<ProducerStation> producerStations = new ProducerService().getStationsFromProducer(i);
        if (producerStations==null) {
            new AlertMessage("Fehler","Es konnte keine verbindung zu Datenbank erstellt werden",
                    "Das Fenster wird zugemacht");
            getStage().close();
        }
        else {
            this.producerStations = producerStations;
            listStations.setDisable(false);
            fillObservableListStations(producerStations);                                                                // !!!!!!!!!!!!!
            initComboBoxItemsStations();
        }
    }

    private void disableAllControllElements() {
        producerStationName.setDisable(true);
        producerStationStreet.setDisable(true);
        producerStationCountry.setDisable(true);
        producerStationPostCode.setDisable(true);
        producerStationCity.setDisable(true);
        producerStationEmploee.setDisable(true);
        producerStationTelOffice.setDisable(true);
        producerStationTelMobile.setDisable(true);
        producerStationFax.setDisable(true);
        producerStationEmail.setDisable(true);
        producerStationNote.setDisable(true);
        listStations.setDisable(true);
        btnSave.setDisable(true);
        btnUpdate.setDisable(true);
        listRegions.setDisable(true);


    }

    private boolean ifTxtFieldsValid() {
        if ((producerStationName.getText().equals(""))
                ||
                (producerStationStreet.getText().equals(""))
                  ||
                (producerStationCountry.getText().equals(""))
                ||
                (producerStationPostCode.getText().equals(""))
                ||
                (producerStationCity.getText().equals(""))
                ||
                (listRegions.getSelectionModel().getSelectedIndex()==-1))
            return false;
        else
            return true;
    }


    private void enableControllsForSaveNew() {

        producerStationName.setDisable(false);
        producerStationStreet.setDisable(false);
        producerStationCountry.setDisable(false);
        producerStationPostCode.setDisable(false);
        producerStationCity.setDisable(false);
        producerStationEmploee.setDisable(false);
        producerStationTelOffice.setDisable(false);
        producerStationTelMobile.setDisable(false);
        producerStationFax.setDisable(false);
        producerStationEmail.setDisable(false);
        producerStationNote.setDisable(false);
        btnSave.setDisable(false);
        listRegions.setDisable(false);
    }

    private void fillObservableListStations(List<ProducerStation> listProducerStations ) {

        for(int i=0;(i<=listProducerStations.size()-1);i++) {

            itemsComboBoxStations.add(listProducerStations.get(i).getStationName() + " ," + listProducerStations.get(i).getStationCity()+
                    ""+listProducerStations.get(i).getId());

            //listIdsCustomerStations.add(i);
            producerStationsIdxAndIds.put(i ,listProducerStations.get(i).getId());

            System.out.println(i+"-----  "+listProducerStations.get(i).getStationName());
            System.out.println("ID = "+producerStationsIdxAndIds.get(i));
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

    private void initComboBoxItemsStations() {
        listStations.setItems(itemsComboBoxStations);
    }

    private void initComboBoxItemsRegions() {
        listRegions.setItems(itemsComboBoxRegions);
    }

    private void fillFieldsBySelectingCustomerStation() {
        // producerStation = new ProducerStation();
        int i = listStations.getSelectionModel().getSelectedIndex();
        producerStation =  producerStations.get(i);
        producerStationName.setText(producerStation.getStationName());
        producerStationStreet.setText(producerStation.getStationStreet());
        producerStationCountry.setText(producerStation.getStationLand());
        producerStationPostCode.setText(producerStation.getStationPostCode());
        producerStationCity.setText(producerStation.getStationCity());
        producerStationEmploee.setText(producerStation.getStationEmploee());
        producerStationTelOffice.setText(producerStation.getStationTelefone1());
        producerStationTelMobile.setText(producerStation.getStationTelefone2());
        producerStationFax.setText(producerStation.getStationTelefone3());
        producerStationEmail.setText(producerStation.getStationEmail());
        producerStationNote.setText(producerStation.getStationNote());
        int regionIndex = getRegionByIdFromMap(producerStation.getRegion().getId());
        System.out.println("Ich ändere listRegions auf index --"+regionIndex);
        listRegions.getSelectionModel().select(regionIndex);

    }

    private Boolean setProducerStation() {
        if (ifTxtFieldsValid()) {
            producerStation = new ProducerStation();
            producerStation.setProducer(producer);
            producerStation.setStationName(producerStationName.getText());
            producerStation.setStationStreet(producerStationStreet.getText());
            producerStation.setStationLand(producerStationCountry.getText());
            producerStation.setStationPostCode(producerStationPostCode.getText());
            producerStation.setStationCity(producerStationCity.getText());
            producerStation.setStationEmploee(producerStationEmploee.getText());
            producerStation.setStationTelefone1(producerStationTelOffice.getText());
            producerStation.setStationTelefone2(producerStationTelMobile.getText());
            producerStation.setStationTelefone3(producerStationFax.getText());
            producerStation.setStationEmail(producerStationEmail.getText());
            producerStation.setStationNote(producerStationNote.getText());
            producerStation.setRegion(regions.get(listRegions.getSelectionModel().getSelectedIndex()));
            return true;
        }
        else {
            new view.AlertMessage("Fehler","Eingabe ist nicht valid",
                    "Alle Felder gekennzeichnet mit * müssen ausgefüllt sein");
            return false;
        }
    }

    private Boolean setUpdatedProducerStation() {
        if (ifTxtFieldsValid()) {
            producerStation.setStationName(producerStationName.getText());
            producerStation.setStationStreet(producerStationStreet.getText());
            producerStation.setStationLand(producerStationCountry.getText());
            producerStation.setStationPostCode(producerStationPostCode.getText());
            producerStation.setStationCity(producerStationCity.getText());
            producerStation.setStationEmploee(producerStationEmploee.getText());
            producerStation.setStationTelefone1(producerStationTelOffice.getText());
            producerStation.setStationTelefone2(producerStationTelMobile.getText());
            producerStation.setStationTelefone3(producerStationFax.getText());
            producerStation.setStationEmail(producerStationEmail.getText());
            producerStation.setStationNote(producerStationNote.getText());

            // we get the index(selected Item)  from ComboBox. Then we get from regions List an Object region on this index
            // ComboBox Index is
            region = regions.get(listRegions.getSelectionModel().getSelectedIndex());
            producerStation.setRegion(region);
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
