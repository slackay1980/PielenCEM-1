package controller;


import dao.CustomerDAO;
import entyties.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CustomerService;

import javax.swing.text.TabableView;
import java.util.List;

public class AllCustomersViewController extends Controller {

    private List<Customer> customers;

    @FXML
    private TableView<Customer> tableAllCustomers;

    @FXML
    private TableColumn<String,Customer>  tableColNumber;

    @FXML
    private TableColumn<Customer, String>  tableColCustomerName;

    @FXML
    private TableColumn<String, String>  tableColCustomerStreet;

    @FXML
    private TableColumn<String, String>  tableColCustomerCountryPostCode;

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
        try {
            customers = new CustomerDAO().getAllCustomers();
        }
        catch (Exception  e) {

        }

        System.out.println(customers);

        tableColCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        //tbv.getColumns().add(cl1);
        //tableAllCustomers.getColumns().add(tableColCustomerName);

        Integer i = 1;

        for (Customer customer: customers
             ) {

            tableAllCustomers.getItems().add(customer);
        }


    }

    private void getAllCustomers() {

    }


}
