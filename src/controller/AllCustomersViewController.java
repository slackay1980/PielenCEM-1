package controller;


import dao.CustomerDAO;
import entyties.Customer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CustomerService;
import view.AlertMessage;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.TabableView;
import java.util.List;
import java.util.Observable;

public class AllCustomersViewController extends Controller {

    private List<Customer> customers;

    private Integer i = 1;

    @FXML
    private TableView<Customer> tableAllCustomers;

    @FXML
    private TableColumn<String, String>  tableColNumber;

    @FXML
    private TableColumn<String, String>  tableColCustomerName;

    @FXML
    private TableColumn<String, String>  tableColCustomerStreet;

    @FXML
    private TableColumn<String, String>  tableColCustomerCountryPostCode;

    @FXML
    private TableColumn<String, String>  tableColCity;

    @FXML
    private TableColumn<String, String> tableColSeller;

    @FXML
    private TableColumn<String, String> tableColCustomerEmploye;

    @FXML
    private TableColumn<String, String> tableColCustomerTel1;

    @FXML
    private TableColumn<String, String> tableColCustomerEmail;


    public AllCustomersViewController() {

    }

    @FXML
    private void initialize()
    {
        prepareColumnsBinding();
        if (getAllCustomers()) {
            showAllCustomersOnTable();
        }

    }

    private Boolean getAllCustomers() {
        try {
            customers = new CustomerDAO().getAllCustomers();
            return true;
        }
        catch (Exception  e) {
            new AlertMessage("Fehler","Fehler beim lesesn aus Datenbank",
                    "Es konnten keine Daten aus der Datenbank gelesen werden ");
            return false;
        }
    }

        private void showAllCustomersOnTable() {
            System.out.println(customers);



            //tbv.getColumns().add(cl1);
            //tableAllCustomers.getColumns().add(tableColCustomerName);

            // setting PosNumber for Table from 1....
            i = 1;
            for (Customer customer: customers
            ) {
                customer.setPosNumber(i);
                tableAllCustomers.getItems().add(customer);
                i++;
            }

        }

        private void prepareColumnsBinding() {
            tableColNumber.setCellValueFactory(new PropertyValueFactory<>("posNumber"));
            tableColCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            tableColCustomerStreet.setCellValueFactory(new PropertyValueFactory<>("customerStreet"));
            tableColCustomerCountryPostCode.setCellValueFactory(new PropertyValueFactory<>("customerCountryAndPOstCode"));
            tableColCity.setCellValueFactory(new PropertyValueFactory<>("customerCity"));
            tableColCustomerEmploye.setCellValueFactory(new PropertyValueFactory<>("customerEmploee"));
            tableColCustomerTel1.setCellValueFactory(new PropertyValueFactory<>("customerTelefone1"));
            tableColCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
            tableColSeller.setCellValueFactory(new PropertyValueFactory<>("sellerName"));

        }




}
