package controller;

import entyties.Producer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import service.ProducerService;

public class AddProducerController extends Controller {

    private Producer producer;


    public  AddProducerController() {}

    @FXML
    private TextField producerName;

    @FXML
    private TextField producerStreet;

    @FXML
    private TextField producerCountry;

    @FXML
    private TextField producerPostCode;

    @FXML
    private TextField producerCity;

    @FXML
    private TextField producerEmploee;

    @FXML
    private TextField producerTelOffice;

    @FXML
    private TextField producerTelMobile;

    @FXML
    private TextField producerFax;

    @FXML
    private TextField producerEmail;

    @FXML
    private TextField producerLogicID;




    @FXML
    private void btnSaveClicked()
    {
        setProducer();
        if (producer!=null) {
            if(new ProducerService().saveProducer(producer)) {
                new view.AlertMessage("Info","Neuer Hersteller wurde angelegt",
                        producer.getProducentName()  +", "+
                                producer.getProducentLand()+"-"+producer.getProducentPostCode()+" "+producer.getProducentCity());

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
        if ((producerName.getText().equals(""))
                ||
                (producerStreet.getText().equals(""))
                ||
                (producerCountry.getText().equals(""))
                ||
                (producerPostCode.getText().equals(""))
                ||
                (producerCity.getText().equals(""))
                ||
                (producerEmploee.getText().equals(""))
                ||
                (producerTelOffice.getText().equals(""))
                ||
                (producerTelMobile.getText().equals(""))
                ||
                (producerFax.getText().equals(""))
                ||
                (producerFax.getText().equals(""))
                ||
                (producerLogicID.getText().equals("")))
        {
            return false;
        }
            else
            return true;
    }

    private void setProducer() {
        if (ifTxtFieldsValid()) {

            producer = new Producer();
            producer.setProducentName(producerName.getText());
            producer.setProducentStreet(producerStreet.getText());
            producer.setProducentLand(producerCountry.getText());
            producer.setProducentPostCode(producerPostCode.getText());
            producer.setProducentCity(producerCity.getText());
            producer.setProducentEmploee(producerEmploee.getText());
            producer.setProducentTelefone1(producerTelOffice.getText());
            producer.setProducentTelefone2(producerTelMobile.getText());
            producer.setProducentEmail(producerEmail.getText());
            producer.setProducentLogicId(producerLogicID.getText());


        }
        else {
            new view.AlertMessage("Fehler","Eingabe ist nicht valid",
                    "Alle Felder gekennzeichnet mit * müssen ausgefüllt sein");
        }
    }


}
