package controller;

import entyties.Forwarder;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import service.ForwarderService;
import service.ProducerService;

public class AddForwarderController extends Controller {

    private Forwarder forwarder;
    @FXML
    private TextField forwarderName;

    @FXML
    private TextField forwarderStreet;

    @FXML
    private TextField forwarderCountry;

    @FXML
    private TextField forwarderPostCode;

    @FXML
    private TextField forwarderCity;

    @FXML
    private TextField forwarderEmploee;

    @FXML
    private TextField forwarderTelOffice;

    @FXML
    private TextField forwarderTelMobile;

    @FXML
    private TextField forwarderFax;

    @FXML
    private TextField forwarderEmail;

    @FXML
    private TextField forwarderNote;




    @FXML
    private void btnSaveClicked()
    {
        setForwarder();
        if (forwarder!=null) {
            if(new ForwarderService().saveNewForwarder(forwarder)) {
                new view.AlertMessage("Info","Neue Spedition wurde angelegt",
                        forwarder.getForwarderName()  +", "+
                                forwarder.getForwarderCountry()+"-"+forwarder.getForwarderPostCode()+" "+forwarder.getForwarderCity());

                getStage().close();
            }
            else {
                new view.AlertMessage("Info","Problem beim Speichern",
                        "Der neue Kunde konnte nicht angelegt werden");
            }
        }
    }

    @FXML
    private void btnCancelClicked()
    {
        getStage().close();
    }

    private boolean ifTxtFieldsValid() {
        if ((forwarderName.getText().equals(""))
                ||
                (forwarderStreet.getText().equals(""))
                ||
                (forwarderCountry.getText().equals(""))
                ||
                (forwarderPostCode.getText().equals(""))
                ||
                (forwarderCity.getText().equals(""))
                ||
                (forwarderEmploee.getText().equals(""))
                ||
                (forwarderTelOffice.getText().equals(""))
                ||
                (forwarderTelMobile.getText().equals(""))
                ||
                (forwarderFax.getText().equals(""))
                ||
                (forwarderEmail.getText().equals(""))
                ||
                (forwarderNote.getText().equals("")))
        {
            return false;
        }
        else
            return true;
    }

    private void setForwarder() {
        if (ifTxtFieldsValid()) {

            forwarder = new Forwarder();
            forwarder.setForwarderName(forwarderName.getText());
            forwarder.setForwarderStreet(forwarderStreet.getText());
            forwarder.setForwarderCountry(forwarderCountry.getText());
            forwarder.setForwarderPostCode(forwarderPostCode.getText());
            forwarder.setForwarderCity(forwarderCity.getText());
            forwarder.setForwarderEmploee(forwarderEmploee.getText());
            forwarder.setForwarderTelefone1(forwarderTelOffice.getText());
            forwarder.setForwarderTelefone2(forwarderTelMobile.getText());
            forwarder.setForwarderEmail(forwarderEmail.getText());
            forwarder.setForwarderNote(forwarderNote.getText());


        }
        else {
            new view.AlertMessage("Fehler","Eingabe ist nicht valid",
                    "Alle Felder gekennzeichnet mit * müssen ausgefüllt sein");
        }
    }

}
