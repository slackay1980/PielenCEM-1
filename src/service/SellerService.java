package service;

import dao.CustomerDAO;
import dao.SellerDAO;
import entyties.Customer;
import entyties.Seller;

import java.util.List;

public class SellerService {

    private List<Seller> sellerList = null;


    public List<Seller> getAllSeller()  {
        try {
            sellerList = (List<Seller>) new SellerDAO().getAllSeller();
            return sellerList;
        }
        catch (Exception e) {
            return sellerList;
        }
    }
}
