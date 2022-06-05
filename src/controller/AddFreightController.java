package controller;



import entyties.Forwarder;
import entyties.Freight;
import entyties.Relation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import service.ForwarderService;
import service.FreightService;
import service.RelationService;
import util.LogoutUtil;
import util.StateOfObjectRequest;
import util.TriState;
import view.AlertMessage;
import view.AlertYesNo;
import view.PoolDownDialogForwarder;
import view.PoolDownDialogRelation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;



public class AddFreightController extends Controller {

    private Relation relation = null;
    private Forwarder forwarder = null;
    private Freight freight;
    private TriState state;

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
    private TextArea freightName;

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
    private Label attentionFreightFlate;

    @FXML
    private Hyperlink hilfeLink;

    @FXML
    private void hilfeLinkClicked() {

    }

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

    if (freight==null) freight = new Freight();

        if (checkFreightTo.isSelected() && (validateDateField(freightPerToSince.getText())!=null)&&
                (validateFieldsPerTo())&&(freightPerToRate.getText().matches("[0-9]+")))  {
            freight.setTyp(0);
            freight.setRelation(relation);
            freight.setForwarder(forwarder);
            freight.setFreightActive(true);
            freight.setFreigtPerTo(Integer.parseInt(freightPerToRate.getText()));

            freight.setFreigtPerToSince(validateDateField(freightPerToSince.getText()));
            freight.setFreigtPerToNote(freightPerToNote.getText());
            new FreightService().saveFreight(freight);
            new AlertMessage("Fracht gespeichert",relation.getRelationName(),"Fracht für "+forwarder.getForwarderName()+
                    "wurde gespeichert");
            getStage().close();
        }
        else {
            if ((checkFreightFlat.isSelected()) && (validateDateField(freightFlatSince.getText())!=null)&&(validateFieldsFlat())
                    &&(freightFlatRate.getText().matches("[0-9]+"))) {
                freight.setTyp(1);
                freight.setRelation(relation);
                freight.setForwarder(forwarder);
                freight.setFreigtPerOrder(Integer.parseInt(freightFlatRate.getText()));
                freight.setFreigtPerOrderSince(validateDateField(freightFlatSince.getText()));
                freight.setFreigtPerOrderNote(freightFlatNote.getText());
                new FreightService().saveFreight(freight);
                new AlertMessage("Fracht gespeichert",relation.getRelationName(),"Fracht für "+forwarder.getForwarderName()+
                        "wurde gespeichert");
                getStage().close();
            }
            else {
                new AlertMessage("Achtung","Eingabefehler","Nicht alle Daten sind korrekt");
            }

        }

    }

    @FXML
    private void btnCancelClicked() {

        if (new AlertYesNo("Achtung", "Sind Sie sicher").show()) {
            getStage().close();
        }
    }

    @FXML
    private void freightHistoryClicked() {

    }



    @FXML
    private void initialize() {
        attentionLabelsTo();
        attentionLabelsFlat();
        setFlipFLopOnCheckBox();
        setFieldsToStartState();
        setKeyHandlerToRelation();
        setKeyHandlerToForwarder();

    }

    private void attentionLabelsTo() {
        checkFreightTo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (!checkFreightTo.isSelected()) {
                    attentionFreightFlate.setTextFill(Color.RED);
                }
            }
        });

        checkFreightTo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                attentionFreightFlate.setTextFill( Color.web("0xF5F3F3"));
            }
        });
    }

    private void attentionLabelsFlat() {
        checkFreightFlat.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (!checkFreightFlat.isSelected()) {
                    attentionFreightFlate.setTextFill(Color.RED);
                }
            }
        });

        checkFreightFlat.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                attentionFreightFlate.setTextFill(Color.web("0xF5F3F3"));
            }
        });
    }

    private void invertFieldstToFrRateAktiv() {
        freightPerToRate.setDisable(true);
        freightPerToSince.setDisable(true);
        freightPerToNote.setDisable(true);
        freightPerToRate.setText("");
        freightPerToSince.setText("");
        freightPerToNote.setText("");
        freightFlatRate.setDisable(false);
        freightFlatSince.setDisable(false);
        freightFlatNote.setDisable(false);
    }

    private void invertFieldstToFrPerToAktiv() {
        freightPerToRate.setDisable(false);
        freightPerToSince.setDisable(false);
        freightPerToNote.setDisable(false);
        freightFlatRate.setText("");
        freightFlatSince.setText("");
        freightFlatNote.setText("");
        freightFlatRate.setDisable(true);
        freightFlatSince.setDisable(true);
        freightFlatNote.setDisable(true);
    }

    private void setFlipFLopOnCheckBox() {
        checkFreightTo.setSelected(true);
        checkFreightFlat.setSelected(false);

        checkFreightFlat.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                checkFreightTo.setSelected(!newValue);

                if (newValue) {
                    invertFieldstToFrRateAktiv();
                }
                else {
                    invertFieldstToFrPerToAktiv();
                    }
            }
        });

        checkFreightTo.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                checkFreightFlat.setSelected(!newValue);
                if (newValue) {
                  invertFieldstToFrPerToAktiv();

                }
                else {
                   invertFieldstToFrRateAktiv();
                }
            }
        });
    }

    private void setFieldsToStartState() {

        freightHistory.setDisable(true);
        btnSave.setDisable(true);
        btnNewFreight.setDisable(true);
        invertFieldstToFrPerToAktiv();
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
        if (list.size()>0) {
            findRelation.setEditable(false);
            PoolDownDialogRelation dialog = new PoolDownDialogRelation(getStage(), findRelation, list);
            int i = dialog.showDialog();
            if (i == -1) {
                findRelation.setText("");
                findRelation.setEditable(true);
            }

            else {
                relation = list.get(i);
                findRelation.setText(relation.getRelationName() );
                findRelation.setEditable(false);
                prepareFormAccordToResponse();
            }

        }
    }

    private void setKeyHandlerToForwarder() {
        findForwarder.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode()== KeyCode.ENTER ) {
                searchAndSetForwarder();
            }
        });
    }

    private void searchAndSetForwarder() {

        System.out.println("KeyPressed");
        StateOfObjectRequest state = new ForwarderService().getForwarderLikeString(findForwarder.getText());
        System.out.println(state.getList().toString());

        if(state.getError()==true) {
            new AlertMessage("Fehler","Verbindung mit Datenbank","Es konnten keine Daten aus der Datenbank gelesen werden");
        }
        else {
            if (state.getList().size() > 0) {

                PoolDownDialogForwarder dialog = new PoolDownDialogForwarder(getStage(), findForwarder, (List<Forwarder>)state.getList());
                int i = dialog.showDialog();
                if (i == -1) {
                    findForwarder.setText("");
                } else {
                    forwarder = (Forwarder) state.getList().get(i);
                    findForwarder.setText(forwarder.getForwarderCity() + ", " + forwarder.getForwarderCity());
                    findForwarder.setEditable(false);
                    prepareFormAccordToResponse();
                }

            }
            else {
                new AlertMessage("Achtung","Nichts gefunden","Es konnten keine Einträge zu eingegebenem Suchkriterium gefunden werden" +
                        "Bitte formulieren Sie Ihre Anfrage alternativ");

            }
        }

    }

    private void prepareFormAccordToResponse() {

        if ((relation!=null)&&(forwarder!=null)) {

            state = new FreightService().ifFreightExist(relation.getId(),forwarder.getId());

            switch (state) {
                case triStateTrue:setFieldsFreightExist();break;
                case triStateFalse:setFieldsFreightNotExist();break;
                case triStateError:new AlertMessage(
                        "Fehler",
                        "Datenbankzugrif Fehler",
                        "Es konnten keine Daten aus Datenbank abgerufen werden"
                );break;
            }
        }
    }

    private void setFieldsFreightExist() {
        StateOfObjectRequest stateOfObject = new FreightService().getFreight(relation.getId(),forwarder.getId());

        // If Datenbank request goes throw
        if (stateOfObject.getError()!=true) {

            // We get the freight from StateOfObject
            freight = (Freight) stateOfObject.getObject();

            String strFreightName = new String();
            strFreightName = freight.getForwarder().getForwarderName()+"\n"+
                    freight.getRelation().getRelationName()+"\n"+"\n"+
                    "Die Fracht existiert bereits";
            freightName.setText(strFreightName);

            // If Freight will be payed per To
            if (freight.getTyp()==0) {
                invertFieldstToFrPerToAktiv();
                setFieldsPerToFromDB(freight);
            }
            if (freight.getTyp()==1) {
                invertFieldstToFrPerToAktiv();
                setFieldsFlatFromDB(freight);
            }

            btnSave.setDisable(false);
            freightHistory.setDisable(false);
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

    private void setFieldsFreightNotExist() {
        btnSave.setDisable(false);
        String strFreightName = new String();
        strFreightName = forwarder.getForwarderName()+"\n"+
                relation.getRelationName()+"\n"+"\n"+
                "Die Fracht wird angelegt";
        freightName.setText(strFreightName);
    }

    private void setDisableFieldsFreightExist() {
        checkFreightFlat.setDisable(true);
        checkFreightTo.setDisable(true);
    }

    private void setFieldsPerToFromDB(Freight freight) {
        checkFreightTo.setSelected(true);
        freightPerToRate.setText(Integer.toString(freight.getFreigtPerTo()));
        freightPerToRate.setEditable(false);
        freightPerToSince.setText(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(
                freight.getFreigtPerToSince()));
        freightPerToSince.setEditable(false);
        freightPerToNote.setText(freight.getFreigtPerToNote());
        freightPerToNote.setEditable(false);
    }

    private void setFieldsFlatFromDB(Freight freight) {
        checkFreightFlat.setSelected(true);
        freightFlatRate.setText(Integer.toString(freight.getFreigtPerOrder()));
        freightFlatRate.setEditable(false);
        freightFlatSince.setText(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(
                freight.getFreigtPerOrderSince()));
        freightFlatSince.setEditable(false);
        freightFlatNote.setText(freight.getFreigtPerOrderNote());
        freightFlatNote.setEditable(false);
    }

    private Date validateDateField(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.GERMAN);

        Date date = null;
        try {
            date = formatter.parse(dateString);
            return date;
        }
        catch (Exception e) {
            return date;
        }
    }

    private Boolean validateFieldsPerTo() {

        if ((freightPerToRate.getText().equals("")) ||
           (freightPerToSince.getText().equals("")) ||
           (freightPerToNote.getText().equals("")) ) {
           return false;
        }
        else {
           return true;
        }
    }

    private Boolean validateFieldsFlat() {
        if ((freightFlatRate.getText().equals(""))||
                (freightFlatSince.getText().equals("")) ||
                (freightFlatNote.getText().equals("")) ) {
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean validateFields() {
        if ((relation!=null)&&(forwarder!=null)) {


            if (checkFreightTo.isSelected())
                return validateFieldsPerTo();
            else
                return validateFieldsFlat();
        }
        else {
            return false;
        }
    }


}
