package service;

import dao.CustomerDAO;
import dao.CustomerStationDAO;
import entyties.Customer;
import entyties.CustomerStation;
import entyties.Region;

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

    public Boolean saveCustomerStation(CustomerStation customerStation)  {
        try {
            new CustomerStationDAO().saveNewStation(customerStation);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Boolean updateCustomerStation(CustomerStation customerStation)  {
        try {
            new CustomerStationDAO().updateStation(customerStation);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
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

    public List<Region> getAllRegions() {

        List<Region> regions = null;
        try {
            regions = new CustomerStationDAO().getAllRegions();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  regions;
    }

    public CustomerStation getCustomerStationFromList(int id, List<CustomerStation> customerStations) {

        for (CustomerStation station : customerStations
        ) {
            if (station.getId() == id) return station;

        }


        return null;
    }
}
