package controller;



import entyties.Relation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.RelationService;
import view.PoolDownDialogRelation;

import java.util.List;


public class AddFreightController extends Controller {

    private Relation relation = null;

    public AddFreightController() {

    }


    @FXML
    private TextField findRelation;

    @FXML
    private TextField findForwarder;

    @FXML
    private CheckBox checkFreightTo;

    @FXML
    private CheckBox checkFreightFlat;

    @FXML
    private TextField freightName;

    @FXML
    private TextField freightPerToRate;

    @FXML
    private TextField freightPerToSince;

    @FXML
    private TextField freightPerToNote;

    @FXML
    private TextField freightFlatRate;

    @FXML
    private TextField freightFlatSince;

    @FXML
    private TextField freightFlatNote;

    @FXML
    private Hyperlink freightHistory;

    @FXML
    private Button btnNewFreight;

    @FXML
    private Button btnFindRelation;

    @FXML
    private Button btnFindForwarder;

    @FXML
    private Button btnSave;


    @FXML
    private void btnFindRelationClicked() {

    }

    @FXML
    private void btnFindForwarderClicked() {

    }

    @FXML
    private void btnNewFreightClicked() {

    }

    @FXML
    private void btnSaveClicked() {
    }

    @FXML
    private void btnCancelClicked() {
        getStage().close();
    }

    @FXML
    private void freightHistoryClicked() {

    }




    @FXML
    private void initialize() {
        setFlipFLopOnCheckBox();
        setFieldsToStartState();
        setKeyHandlerToRelation();

    }

    private void setFlipFLopOnCheckBox() {
        checkFreightTo.setSelected(true);
        checkFreightFlat.setSelected(false);

        checkFreightFlat.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                checkFreightTo.setSelected(!newValue);
                freightPerToRate.setDisable(true);
                freightPerToSince.setDisable(true);
                freightPerToNote.setDisable(true);

                freightFlatRate.setDisable(false);
                freightFlatSince.setDisable(false);
                freightFlatNote.setDisable(false);
            }
        });

        checkFreightTo.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                checkFreightFlat.setSelected(!newValue);
                freightPerToRate.setDisable(false);
                freightPerToSince.setDisable(false);
                freightPerToNote.setDisable(false);

                freightFlatRate.setDisable(true);
                freightFlatSince.setDisable(true);
                freightFlatNote.setDisable(true);
            }
        });
    }

    private void setFieldsToStartState() {

        freightHistory.setDisable(true);
        btnSave.setDisable(true);
        btnNewFreight.setDisable(true);

    }

    private void setKeyHandlerToRelation() {
        findRelation.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode()== KeyCode.ENTER ) {
                searchAndSetRelation();
            }
        });
    }

    private void searchAndSetRelation() {
        System.out.println("KeyPressed");
        List<Relation> list = new RelationService().getRelationLikeString(findRelation.getText());
        System.out.println(list.toString());

        if (list.size()>0) {
            PoolDownDialogRelation dialog = new PoolDownDialogRelation(getStage(), findRelation, list);
            int i = dialog.showDialog();
            if (i == -1) {
                findRelation.setText("");
            }

            else {
                relation = list.get(i);
                findRelation.setText(relation.getRelationName() );
                findRelation.setEditable(false);
                //  setRelationTextOnFormIfExist();
            }

        }
    }
/*
    private void setKeyHandlerToCustomerStation() {
        relationCustomerStation.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode()== KeyCode.ENTER ) {
                searchAndSetCustomerStation();
            }
        });
    }

    private void searchAndSetCustomerStation() {

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
*/


}



/*
    private void setKeyHandlerToProducerStation() {
        relationProducerStation.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                if(keyEvent.getCode()== KeyCode.ENTER ) {
                    searchAndSetProducerStation();
                }
        });
    }

    private void searchAndSetProducerStation() {
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

    private void setKeyHandlerToCustomerStation() {
        relationCustomerStation.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode()== KeyCode.ENTER ) {
                searchAndSetCustomerStation();
            }
        });
    }

    private void searchAndSetCustomerStation() {

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

            state = new RelationService().ifRelationExist(producerStation.getId(),customerStation.getId());

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
                relationDistance.setDisable(false);
                relationDistance.setText(Integer.toString(relation.getDistance()));
                relationCustom.setDisable(false);
                relationCustom.setSelected(relation.isIfCustom());
                btnSave.setDisable(false);
            }
            else {
                new AlertMessage(
                        "Fehler",
                        "Datenbankzugrif Fehler",
                        "Es konnten keine Daten aus Datenbank abgerufen werden"
                );
                getStage().close();
            }
    }

    private void setFieldsAccordToRelationNotExist() {
        relationName.setText(
                producerStation.getStationName()+", "+producerStation.getStationCity()+
                " - "+customerStation.getStationCity()+" ("+customerStation.getStationName()+")"
        );

        //relation = new Relation();
        relationDistance.setDisable(false);
        //relationDistance.setText(Integer.toString(relation.getDistance()));
        relationCustom.setDisable(false);
        //relationCustom.setSelected(relation.isIfCustom());
        btnSave.setDisable(false);

    }

    private void prepareFieldsToSave() {
        if (relation==null) {
            relation = new Relation();
        }
            relation.setProducerStation(producerStation);
            relation.setCustomerStation(customerStation);
            relation.setRelationName(relationName.getText());
            relation.setDistance(Integer.parseInt(relationDistance.getText()));
            relation.setIfCustom(relationCustom.isSelected());
    }  */


