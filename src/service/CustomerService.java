package service;

import dao.CustomerDAO;
import entyties.Customer;

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
}
