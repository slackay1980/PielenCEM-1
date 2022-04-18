package controller;

import entyties.Customer;
import entyties.Seller;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.CustomerService;
import service.SellerService;

import java.util.List;


public class AddCustomerController extends Controller {
    private Customer customer = null;
    private List<Seller> sellerList;


    public AddCustomerController() {

    }

    @FXML
    private TextField customerName;
    @FXML
    private TextField customerStreet;
    @FXML
    private TextField customerCountry;
    @FXML
    private TextField customerPostCode;
    @FXML
    private TextField customerCity;
    @FXML
    private TextField customerEmploee;
    @FXML
    private TextField customerTelOffice;

    @FXML
    private TextField customerTelMobile;

    @FXML
    private TextField customerFax;

    @FXML
    private TextField customerEmail;

    @FXML
    private TextField customerLogicID;

    @FXML
    private ChoiceBox<String> choiceSeller;



    @FXML
    private void customerNameClicked() {
        System.out.println(getStage());
    }

    @FXML
    private void btnSaveClicked() {
        setCustomer();
        if (customer!=null) {
            if(new CustomerService().saveCustomer(customer)) {
                new view.AlertMessage("Info","Neuer Kunde wurde angelegt",
                        customer.getCustomerName()+", "+
                        customerCountry+"-"+customerPostCode+" "+customer.getCustomerCity());

                getStage().close();
            }
            else {
                new view.AlertMessage("Info","Problem beim Speichern",
                        "Der neue Kunde konnte nicht angelegt werden");
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
        sellerList =new SellerService().getAllSeller();
        if (sellerList!=null) {
            for (Seller seller: sellerList) {
                choiceSeller .getItems().add(seller.getSellerName()+" /" + seller.getSellerShortName());
            }
        }
    }



    @FXML
    private void printOutput(){

    }

    private boolean ifTxtFieldsValid() {
        if ((customerName.getText().equals(""))
                ||
                (customerStreet.getText().equals(""))
                ||
                (customerCountry.getText().equals(""))
                ||
                (customerPostCode.getText().equals(""))
                ||
                (customerCity.getText().equals(""))
                ||
                (customerEmploee.getText().equals(""))
                ||
                (customerTelOffice.getText().equals(""))
                ||
                (customerTelMobile.getText().equals(""))
                ||
                (customerFax.getText().equals(""))
                ||
                (customerEmail.getText().equals(""))
                ||
                (customerLogicID.getText().equals(""))
                ||
                (choiceSeller.getSelectionModel().getSelectedIndex()==-1)) {return false; }
        else
        return true;
    }

    private void setCustomer() {
        if (ifTxtFieldsValid()) {
            Seller seller = sellerList.get(choiceSeller.getSelectionModel().getSelectedIndex());
            customer = new Customer();
            customer.setCustomerName(customerName.getText());
            customer.setCustomerStreet(customerStreet.getText());
            customer.setCustomerLand(customerCountry.getText());
            customer.setCustomerPostCode(customerPostCode.getText());
            customer.setCustomerCity(customerCity.getText());
            customer.setCustomerEmploee(customerEmploee.getText());
            customer.setCustomerTelefone1(customerTelOffice.getText());
            customer.setCustomerTelefone2(customerTelMobile.getText());
            customer.setCustomerTelefone3(customerFax.getText());
            customer.setCustomerEmail(customerEmail.getText());
            customer.setCustomerLogicId(customerLogicID.getText());
            customer.setSeller(seller);
        }
        else {
            new view.AlertMessage("Fehler","Eingabe ist nicht valid",
                    "Alle Felder gekennzeichnet mit * müssen ausgefüllt sein");
        }
    }
}
