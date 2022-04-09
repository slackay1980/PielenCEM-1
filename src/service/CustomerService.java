package service;

import dao.CustomerDAO;
import dao.CustomerStationDAO;
import entyties.Customer;
import entyties.CustomerStation;

import java.util.List;

public class CustomerService {

    public CustomerService(){

    }

    public Boolean saveCustomer(Customer customer)  {
        try {
            new CustomerDAO().saveCustomer(customer);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public List<Customer> getCustomersLikeString(String customerString)  {

        List<Customer> customers= null;

        try {
           customers = new CustomerDAO().getCustomerAccordToString(customerString);
        }
        catch (Exception e) {

        }
        return  customers;
    }

    public  List<CustomerStation> getStationsFromCustomer(int id) {

        List<CustomerStation> customerStations= null;

        try {
            customerStations = new CustomerStationDAO().getAllCustomerStationsForCertainCustomer(id);
        }
        catch (Exception e) {

        }
        return  customerStations;
    }
}
