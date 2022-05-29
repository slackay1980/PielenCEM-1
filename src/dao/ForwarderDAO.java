package dao;


import entyties.Forwarder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.StateOfObjectRequest;

import java.util.List;

public class ForwarderDAO {

    public ForwarderDAO() {
        // TODO Auto-generated constructor stub
    }

    public void saveNewForwarder(Forwarder forwarder) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(forwarder);
        transaction.commit();
        session.close();
    }

    public List<Forwarder> getForwarderLikeString(String forwarderString) throws HibernateException, Exception  {

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        String querry = "FROM Forwarder as f WHERE f.forwarderName LIKE : searchString";

        @SuppressWarnings("deprecation")
        List<Forwarder> forwarderList = (List<Forwarder>) session.createQuery(querry, Forwarder.class).setString("searchString",forwarderString).list();

        return forwarderList;
    }
}
