package dao;

import entyties.Seller;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class SellerDAO {

    public List<Seller> getAllSeller() throws HibernateException, Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();
        List<Seller> sellerList = session.createQuery("from Seller", Seller.class).getResultList();


        return sellerList;
    }

}
