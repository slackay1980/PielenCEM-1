package service;

import dao.CustomerDAO;
import entyties.Customer;

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
}
