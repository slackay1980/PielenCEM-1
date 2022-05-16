package controller;

import dao.ProducerStationsDAO;
import entyties.CustomerStation;
import entyties.ProducerStation;
import entyties.Relation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.CustomerService;
import service.ProducerService;
import service.RelationService;
import util.TriState;
import view.AlertMessage;
import view.PoolDownDialogCustomer;
import view.PoolDownDialogCustomerStation;
import view.PoolDownDialogProducerStation;

import java.util.List;


public class AddRelationController extends Controller{

    private ProducerStation producerStation=null;
    private CustomerStation customerStation=null;
    private Relation relation;

    public  AddRelationController() {

    }


    @FXML
    private TextField relationProducerStation;

    @FXML
    private TextField relationCustomerStation;

    @FXML
    private TextField relationName;

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
    private Button btnFindProducerStation;

    @FXML
    private Button btnFindCustomerStation;

    @FXML
    private Button btnSave;




    @FXML
    private void btnProducerStationClicked() {

    }

    @FXML
    private void btnCustomerStationClicked() {

    }

    @FXML
    private void btnSaveClicked() {

    }


    @FXML
    private void btnCancelClicked()
    {
        getStage().close();
    }


    @FXML
    private void initialize() {
        System.out.println("Initialization");
        setKeyHandlerToProducerStation();
        setKeyHandlerToCustomerStation();
    }

    private void setKeyHandlerToProducerStation() {
        relationProducerStation.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                if(keyEvent.getCode()== KeyCode.ENTER ) {

                    System.out.println("KeyPressed");
                    List<ProducerStation> list = new ProducerService().getProducerStationsLikeString(relationProducerStation.getText());
                    System.out.println(list.toString());

                    if (list.size()>0) {
                        PoolDownDialogProducerStation dialog = new PoolDownDialogProducerStation(getStage(), relationProducerStation, list);
                        int i = dialog.showDialog();
                        if (i == -1) {
                            relationProducerStation.setText("");
                        }

                        else {
                            producerStation = list.get(i);
                            relationProducerStation.setText(producerStation.getStationName() + ", " + producerStation.getStationCity());
                            relationProducerStation.setEditable(false);
                            setRelationTextOnFormIfExist();
                        }

                    }
                }
        });
    }

    private void setKeyHandlerToCustomerStation() {
        relationCustomerStation.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode()== KeyCode.ENTER ) {

                System.out.println("KeyPressed");
                List<CustomerStation> list = new CustomerService().getCustomerStationsLikeString(relationCustomerStation.getText());
                System.out.println(list.toString());

                if (list.size()>0) {
                    PoolDownDialogCustomerStation dialog = new PoolDownDialogCustomerStation(getStage(), relationCustomerStation, list);
                    int i = dialog.showDialog();
                    if (i == -1) {
                        relationCustomerStation.setText("");
                    }

                    else {
                        customerStation = list.get(i);
                        relationCustomerStation.setText(customerStation.getStationName() + ", " + customerStation.getStationCity());
                        relationCustomerStation.setEditable(false);
                        setRelationTextOnFormIfExist();
                    }

                }
            }
        });
    }

    private void disableFindProducerStation() {

    }

    private void disableFindCustomerStation() {

    }

    private void enableFields() {
        relationDistance.setDisable(false);
        relationOptional1.setDisable(false);
        relationOptional2.setDisable(false);
        relationOptional3.setDisable(false);
        relationOptional4.setDisable(false);
        relationCustom.setDisable(false);
        //btnFindProducerStation.setDisable(true);
        // btnFindCustomerStation.setDisable(true);
        btnSave.setDisable(true);
    }

    private void disableFields() {
         relationName.setEditable(false);
         relationDistance.setDisable(true);
         relationOptional1.setDisable(true);
         relationOptional2.setDisable(true);
         relationOptional3.setDisable(true);
         relationOptional4.setDisable(true);
         relationCustom.setDisable(true);
            //btnFindProducerStation.setDisable(true);
            // btnFindCustomerStation.setDisable(true);
         btnSave.setDisable(true);
    }

    private void setRelationTextOnFormIfExist() {

        if ((producerStation!=null)&&(customerStation!=null)) {
            TriState state;
            state = new RelationService().ifRelationExist(customerStation.getId(), producerStation.getId());

            switch (state) {
            case triStateTrue:setFieldsAccordToRelationExist();break;
            case triStateFalse:setFieldsAccordToRelationNotExist();break;
            case triStateError:new AlertMessage(
                            "Fehler",
                            "Datenbankzugrif Fehler",
                            "Es konnten keine Daten aus Datenbank abgerufen werden"
                           );break;
            }
        }
    }

    private void setFieldsAccordToRelationExist() {
            relation = new RelationService().getRelation(producerStation.getId(),customerStation.getId());
            if (relation!=null) {

                relationName.setText(relation.getRelationName());
                relationDistance.setText(Integer.toString(relation.getDistance()));
                relationCustom.setSelected(relation.isIfCustom());
            }
            else {
                new AlertMessage(
                        "Fehler",
                        "Datenbankzugrif Fehler",
                        "Es konnten keine Daten aus Datenbank abgerufen werden"
                );
            }
    }

    private void setFieldsAccordToRelationNotExist() {
        relationName.setText(
                producerStation.getStationName()+", "+producerStation.getStationCity()+
                " - "+customerStation.getStationCity()+" ("+customerStation.getStationName()+")"
        );

    }


}